
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
public class Ong {
    private int codigo;
    private String nome;
    private String login;
    private String senha;
}
