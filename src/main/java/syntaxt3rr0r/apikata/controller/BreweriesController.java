package syntaxt3rr0r.apikata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syntaxt3rr0r.apikata.dto.BreweriesDTO;
import syntaxt3rr0r.apikata.dto.converter.BreweriesDTOConverter;
import syntaxt3rr0r.apikata.modelo.Breweries;
import syntaxt3rr0r.apikata.repo.BreweriesRepo;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BreweriesController {

    private final BreweriesRepo breweriesRepo;
    private final BreweriesDTOConverter breweriesDTOConverter;


    /**
     * Endpoint GET para todas las cervecerías (breweries)
     * @return 404 si no se encuentran cervecerías,
     *         200 y lista de cervezas si hay una o más
     */
    @GetMapping("/breweries")
    public ResponseEntity<?> getAllBreweries() {
        List <Breweries> result = breweriesRepo.findAll();

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<BreweriesDTO> breweriesDTOList = result.stream().map(breweriesDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(breweriesDTOList);
        }
    }

    /**
     * Endpoint POST para obtener información completa de una cerveza
     * @param id
     * @return 404 si no encuentra la cervecería,
     *         200 si la encuentra, junto a información detallada de la cervecería.
     */
    @GetMapping("/breweries/{id}")
    public ResponseEntity<?> getOneBreweries(@PathVariable Long id) {
        Breweries brewerie = breweriesRepo.findById(id).orElse(null);
        return (brewerie == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(brewerie);
    }
}