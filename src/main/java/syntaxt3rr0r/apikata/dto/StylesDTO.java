package syntaxt3rr0r.apikata.dto;


import lombok.Getter;
import lombok.Setter;
import syntaxt3rr0r.apikata.modelo.Categories;

/**
 * La tabla styles ofrece id, id de la categoría, nombre del estilo, y fecha de última modificación.
 * Al devolver el listado, vamos a devolver sólo la id, el nombre del estilo y el nombre de la categoría.
 * Para esto vamos a usar un DTO.
 */

@Getter @Setter
public class StylesDTO {
    private long id;
    private String style_name;
    private String categoryCat_name;

}
