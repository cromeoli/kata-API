package syntaxt3rr0r.apikata.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Styles {
    @Id
    @GeneratedValue
    private Long id;
    private String style_name;
    private Date last_mod;
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Categories category;
}
