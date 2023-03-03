package syntaxt3rr0r.apikata.dto;

import com.example.api.modelo.Categories;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BeersDTO {
    private long id;
    private String name;
    private Categories descript;
    private String categorieCat_name;

}
