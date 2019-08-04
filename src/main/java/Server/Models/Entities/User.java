package Server.Models.Entities;

import Server.Models.Enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@XmlRootElement
public class User implements Serializable {

    public User(String userName, String fullName, String password, String passwordRepeat, String email) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.email = email;
    }

    @Id
    @Column(unique = true, nullable = false, name ="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @NotBlank
    @Column(unique = true, nullable = false, name ="userName")
    @Size(min=6, message="Username must be at least 6 characters long")
    private String userName;

    @NotBlank
    @Column(nullable = false, name ="fullName")
    private String fullName;

    @NotBlank
    @Column(nullable = false, name ="password")
    @Size(min=6, message="Password must be at least 6 characters long")
    private String password;

    @NotBlank
    @Transient
    private String passwordRepeat;

    @NotBlank
    @Column(nullable = false, unique = true, name = "email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,255}$", message = "Wrong email!")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum userRole;



}
