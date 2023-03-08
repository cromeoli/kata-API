package syntaxt3rr0r.apikata.error;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/*
* Creamos la clase APIError para destilar los errores que java nos devuelve
* a un formato mucho más legible y entendible. Como si fuera una especie de DTO.
* */
@Setter @Getter
@RequiredArgsConstructor @NoArgsConstructor

public class APIError {
    @NonNull
    private HttpStatus state;

    @NonNull
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime currentDateTime = LocalDateTime.now();
}
