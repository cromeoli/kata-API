package syntaxt3rr0r.apikata.dto.converter;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.dto.BreweriesDTO;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Breweries;

@Component
@RequiredArgsConstructor
public class BreweriesDTOConverter {
    private final ModelMapper modelMapper;
    public BreweriesDTO convertToDto(Breweries brewerie) {
        return modelMapper.map(brewerie, BreweriesDTO.class);
    }

}