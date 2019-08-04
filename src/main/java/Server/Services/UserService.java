package Server.Services;

import Server.Models.Forms.UserForm;
import Server.Models.Entities.User;

import java.util.List;

public interface UserService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Integer userId);
}
