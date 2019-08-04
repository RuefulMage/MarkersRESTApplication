package Server.Services;


import Server.Models.Enums.UserRoleEnum;
import Server.Models.Forms.UserForm;
import Server.Models.Entities.User;
import Server.Repos.HibernateUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private HibernateUsersRepo usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void signUp(UserForm userForm) {
//        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .userName(userForm.getUserName())
                .fullName(userForm.getFullName())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .passwordRepeat(passwordEncoder.encode(userForm.getPasswordRepeat()))
                .email(userForm.getEmail())
                .userRole(UserRoleEnum.USER)
                .build();

        usersRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findOne(Integer userId) {
        return usersRepository.findById(userId).get();
    }
}
