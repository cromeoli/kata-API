package syntaxt3rr0r.apikata.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(){
        super("No se han encontrado datos de ninguna cerveza");
    }
    public BeerNotFoundException(Long id){
        super("No se ha encontrado una cerveza con el id " + id);
    }
}
