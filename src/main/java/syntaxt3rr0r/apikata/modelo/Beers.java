package syntaxt3rr0r.apikata.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Beers {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Categories categorie;

    @ManyToOne
    @JoinColumn(name="style_id")
    private Styles style;
    private float abv;
    private float ibu;
    private float srm;
    private float upc;
    private String filepath;
    private String descript;
    private int add_user;
    private Date last_mod;


}
