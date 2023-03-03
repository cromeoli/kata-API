package syntaxt3rr0r.apikata.dto.converter;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import syntaxt3rr0r.apikata.dto.BeersDTO;
import syntaxt3rr0r.apikata.modelo.Beers;

@Component
@RequiredArgsConstructor
public class BeersDTOConverter {
    private final ModelMapper modelMapper;
    public BeersDTO convertToDto(Beers beers) {
        return modelMapper.map(beers, BeersDTO.class);

    }
}
