package syntaxt3rr0r.apikata.controller;

import com.example.api.dto.BeersDTO;
import com.example.api.dto.converter.BeersDTOConverter;
import com.example.api.modelo.Beers;
import com.example.api.repo.BeersRepo;
import com.example.api.repo.CategoriesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BeersController {

    private final BeersRepo beersRepo;
    private final BeersDTOConverter beersDTOConverter;
    private final CategoriesRepo categoriesRepo;


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




}