package syntaxt3rr0r.apikata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.CreateBeersDTO;
import syntaxt3rr0r.apikata.dto.UpdateBeersDTO;
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
    public ResponseEntity <?> getAllBeers() {
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
     * Obtengo una cerveza por su id
     * @param id
     * @return 404 si no encuentra la cerveza, si la encuentra devuelve 200 y la cerveza
     */
    @GetMapping("/beer/{id}")
    public ResponseEntity<?> getOneBeer(@PathVariable Long id) {
        Beers result = beersService.findById(id).orElse(null);
        return (result == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }

    /**
     * Crea nueva cerveza
     * @param newBeerData datos de la nueva cerveza a crear
     * @return 201 y la cerveza creada
     */
    @PostMapping("/beer")
    public ResponseEntity<?> newBeer(@RequestBody CreateBeersDTO newBeerData){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(beersService.newBeers(newBeerData));
    }

    /**
     * Actualiza los datos nombre, descripción ó ruta del archivo
     * @param editBeer datos nuevos
     * @param id de la cerveza a modificar
     * @return 200 Ok si la edición tiene éxito, 404 si no se encuentra la cerveza
     */
    @PutMapping("/beer/{id}")
    public ResponseEntity<?> editBeer (@RequestBody UpdateBeersDTO editBeer, @PathVariable Long id){

        Beers updatedBeer = beersService.updateBeer(editBeer, id);

        if (updatedBeer == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updatedBeer);
    }

    /**
     * Borra una cerveza
     * @param id de la cerveza a borrar
     * @return Código 204 sin contenido o 404 si la cerveza no existe
     */
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<?> deleteBeers (@PathVariable Long id){
        Beers beer = beersService.findById(id).orElse(null);
        if(beer == null)
            return ResponseEntity.notFound().build();

        beersService.delete(beer);
        return ResponseEntity.noContent().build();

    }


}
