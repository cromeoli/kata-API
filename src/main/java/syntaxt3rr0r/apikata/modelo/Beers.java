package syntaxt3rr0r.apikata.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Beers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="cat_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name="style_id")
    @NotFound(action = NotFoundAction.IGNORE)
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
