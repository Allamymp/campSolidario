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
public class Admin {

    private int codigo;
    private String login;
    private String senha;

}
