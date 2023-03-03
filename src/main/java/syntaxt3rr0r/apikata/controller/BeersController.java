package syntaxt3rr0r.apikata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.CreateBeersDTO;
import syntaxt3rr0r.apikata.dto.converter.BeersDTOConverter;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Categories;
import syntaxt3rr0r.apikata.modelo.Styles;
import syntaxt3rr0r.apikata.repo.BeersRepo;
import syntaxt3rr0r.apikata.repo.CategoriesRepo;
import syntaxt3rr0r.apikata.repo.StylesRepo;

import javax.swing.text.Style;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BeersController {

    private final BeersRepo beersRepo;
    private final BeersDTOConverter beersDTOConverter;
    private final CategoriesRepo categoriesRepo;
    private final StylesRepo stylesRepo;


    /**
     * Obtenemos todas las cervezas
     * @return 404 si no hay cervezas, 200 y lista de cervezas si hay una o más
     */
    @GetMapping("/beers")
    public ResponseEntity<?> getAllBeers() {
        List <Beers> result = beersRepo.findAll();

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<BeersDTO> dtoList = result.stream().map(beersDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     *  Obtengo una cerveza por su id
     * @param id
     * @return 404 si no encuentra la cerveza, si la encuentra devuelve 200 y la cerveza
     */
    @GetMapping("/beers/{id}")
    public ResponseEntity<?> getOneBeer(@PathVariable Long id) {
        Beers result = beersRepo.findById(id).orElse(null);
        return (result == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }

    @PostMapping("/beers")
    public ResponseEntity<?> newBeer(@RequestBody CreateBeersDTO newBeerData){

        Beers beers = new Beers();
        Categories categories = categoriesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Styles styles = stylesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Date now = new Date();


        beers.setName(newBeerData.getName());
        beers.setCategories(categories);
        beers.setStyle(styles);
        beers.setAbv(newBeerData.getAbv());
        beers.setIbu(newBeerData.getIbu());
        beers.setSrm(newBeerData.getSrm());
        beers.setUpc(newBeerData.getUpc());
        beers.setFilepath(newBeerData.getFilepath());
        beers.setDescript(newBeerData.getDescript());
        beers.setAdd_user(newBeerData.getAdd_user());
        beers.setLast_mod(now);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(beersRepo.save(beers));
    }



}
