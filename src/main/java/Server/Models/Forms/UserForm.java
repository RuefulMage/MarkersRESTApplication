package Server.Models.Forms;

import lombok.Data;

@Data
public class UserForm {
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String passwordRepeat;
}
