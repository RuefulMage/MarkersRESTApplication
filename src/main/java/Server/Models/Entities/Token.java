package Server.Models.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tokens")
public class Token {

    @Id
    @Column(unique = true, nullable = false, name ="token_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int token_id;

    @NotBlank
    @Column(unique = true, nullable = false, name ="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
