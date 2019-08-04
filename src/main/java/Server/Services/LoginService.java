package Server.Services;

import Server.Models.Forms.LoginForm;
import Server.Models.DTOs.TokenDTO;

public interface LoginService {
    TokenDTO login(LoginForm loginForm);

}
