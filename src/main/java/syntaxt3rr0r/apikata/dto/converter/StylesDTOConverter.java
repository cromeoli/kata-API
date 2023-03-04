package syntaxt3rr0r.apikata.dto.converter;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.StylesDTO;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Styles;

@Component
@RequiredArgsConstructor
public class StylesDTOConverter {
    private final ModelMapper modelMapper;
    public StylesDTO convertToDto(Styles styles) {
        return modelMapper.map(styles, StylesDTO.class);

    }
}
