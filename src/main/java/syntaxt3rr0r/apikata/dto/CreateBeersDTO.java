package syntaxt3rr0r.apikata.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class CreateBeersDTO {

    private String name;
    private Long id_Category;
    private Long id_Style;
    private float abv;
    private float ibu;
    private float srm;
    private float upc;
    private String filepath;
    private String descript;
    private int add_user;
}
