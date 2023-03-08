package syntaxt3rr0r.apikata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.CreateBeersDTO;
import syntaxt3rr0r.apikata.dto.StylesDTO;
import syntaxt3rr0r.apikata.dto.converter.BeersDTOConverter;
import syntaxt3rr0r.apikata.dto.converter.StylesDTOConverter;
import syntaxt3rr0r.apikata.error.BreweryNotFoundException;
import syntaxt3rr0r.apikata.error.StyleNotFoundException;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Categories;
import syntaxt3rr0r.apikata.modelo.Styles;
import syntaxt3rr0r.apikata.repo.BeersRepo;
import syntaxt3rr0r.apikata.repo.CategoriesRepo;
import syntaxt3rr0r.apikata.repo.StylesRepo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StylesController {

    private final StylesDTOConverter stylesDTOConverter;
    private final StylesRepo stylesRepo;


    /**
     * Obtenemos todos los estilos
     * @return 404 si no hay estilos, 200 y lista de estilos si hay uno o más
     */
    @GetMapping("/styles")
    public ResponseEntity<?> getAllStyles() {
        List <Styles> result = stylesRepo.findAll();

        if(result.isEmpty()) {
            throw new StyleNotFoundException();
        } else {
            List<StylesDTO> dtoList = result.stream().map(stylesDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtengo un estilo por su id
     * @param id
     * @return 404 si no encuentra el estilo, si lo encuentra devuelve 200 y el estilo
     */
    @GetMapping("/style/{id}")
    public ResponseEntity<?> getOneStyle(@PathVariable Long id) {
        Styles result = stylesRepo.findById(id).orElseThrow(() -> new StyleNotFoundException(id));
        return (result == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }
}
