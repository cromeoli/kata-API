package syntaxt3rr0r.apikata.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BreweryNotFoundException extends RuntimeException {
    public BreweryNotFoundException(){
        super("No se han encontrado datos de ninguna cervecería");
    }
    public BreweryNotFoundException(Long id){
        super("No se ha encontrado una cervecería con el id " + id);
    }
}
