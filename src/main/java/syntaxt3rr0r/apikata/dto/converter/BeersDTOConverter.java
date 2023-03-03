package syntaxt3rr0r.apikata.dto.converter;

import com.example.api.dto.BeersDTO;
import com.example.api.modelo.Beers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class BeersDTOConverter {
    private final ModelMapper modelMapper;
    public BeersDTO convertToDto(Beers beers) {
        return modelMapper.map(beers, BeersDTO.class);

    }
}
