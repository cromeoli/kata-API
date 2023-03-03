package syntaxt3rr0r.apikata.dto;


import lombok.Getter;
import lombok.Setter;
import syntaxt3rr0r.apikata.modelo.Categories;

@Getter @Setter
public class BeersDTO {
    private long id;
    private String name;
    private Categories descript;
    private String categoriesCat_name;

}
