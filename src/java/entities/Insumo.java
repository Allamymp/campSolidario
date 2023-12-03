
package entities;

import enums.Categorias;
import lombok.*;

/**
 *
 * @author allamy
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insumo {
      
    private int codigo;
    private String nome;
    private String marca;
    private Categorias categoria;
    private int quantidade;
}
