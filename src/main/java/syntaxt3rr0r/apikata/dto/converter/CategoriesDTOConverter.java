package syntaxt3rr0r.apikata.dto.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import syntaxt3rr0r.apikata.dto.CategoriesDTO;
import syntaxt3rr0r.apikata.modelo.Categories;
@Component
@RequiredArgsConstructor
public class CategoriesDTOConverter {
    private final ModelMapper modelMapper;
    public CategoriesDTO convertToDto(Categories categories) {
        return modelMapper.map(categories, CategoriesDTO.class);

    }
}
