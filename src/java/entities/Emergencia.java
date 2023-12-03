
package entities;

import lombok.*;

/**
 *
 * @author allamy
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emergencia {
    
    
    
    private int codigo; 
    private String local;
    private String tipo;
    private String descricao; 
}
