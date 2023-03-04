package syntaxt3rr0r.apikata.dto;

import lombok.Getter;
import lombok.Setter;
import syntaxt3rr0r.apikata.modelo.Categories;

@Getter @Setter
public class BreweriesDTO {
    private long id;
    private String name;
    private String city;
    private String state;
    private String code;
    private String country;
    private String descript;

}
