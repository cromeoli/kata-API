package syntaxt3rr0r.apikata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import syntaxt3rr0r.apikata.dto.CategoriesDTO;

import syntaxt3rr0r.apikata.modelo.Categories;
import syntaxt3rr0r.apikata.repo.CategoriesRepo;
import syntaxt3rr0r.apikata.dto.converter.CategoriesDTOConverter;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesRepo categoriesRepo;
    private final CategoriesDTOConverter categoriesDTOConverter;


    //obtenemos todas las categorias
    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        List <Categories> result = categoriesRepo.findAll();

        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<CategoriesDTO> dtoList = result.stream().map(categoriesDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    //Obtenemos solo una categoría en base a su ID
    @GetMapping("/categorie/{id}")
    public ResponseEntity<?> getOneCategorie(@PathVariable Long id) {
        Categories result = categoriesRepo.findById(id).orElse(null);
        return (result == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }

}
