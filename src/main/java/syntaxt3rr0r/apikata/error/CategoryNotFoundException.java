package syntaxt3rr0r.apikata.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(){
        super("No se ha podido encontrar ninguna categoría");
    }

    public CategoryNotFoundException(Long id){
        super("No se ha podido encontrar la categoría con el id " + id);
    }
}
