package syntaxt3rr0r.apikata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.CreateBeersDTO;
import syntaxt3rr0r.apikata.dto.converter.BeersDTOConverter;
import syntaxt3rr0r.apikata.modelo.Beers;

import syntaxt3rr0r.apikata.service.BeersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BeersController {

    private final BeersService beersService;
    private final BeersDTOConverter beersDTOConverter;


    /**
     * Obtenemos todas las cervezas
     * @return 404 si no hay cervezas, 200 y lista de cervezas si hay una o más
     */
    @GetMapping("/beers")
    public ResponseEntity<?> getAllBeers() {
        List <Beers> result = beersService.findAll();

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
        Beers result = beersService.findById(id).orElse(null);
        return (result == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }

    /**
     *
     * @param newBeerData datos de la nueva cerveza a crear
     * @return código 201 cuando ha creado la entrada en la bd
     */
    @PostMapping("/beers")
    public ResponseEntity<?> newBeer(@RequestBody CreateBeersDTO newBeerData){

        Beers beers = beersService.newBeers(newBeerData);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(beersService.save(beers));
    }



}
