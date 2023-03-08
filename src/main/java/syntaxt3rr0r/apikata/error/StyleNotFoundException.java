package syntaxt3rr0r.apikata.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StyleNotFoundException extends RuntimeException {
    public StyleNotFoundException(){
        super("No se ha podido encontrar ningún estilo de cerveza");
    }

    public StyleNotFoundException(Long id){
        super("No se ha podido encontrar el estilo con el id" + id);
    }
}
