package Server.Services;

import Server.Models.Forms.LoginForm;
import Server.Models.Entities.Token;
import Server.Models.DTOs.TokenDTO;
import Server.Models.Entities.User;
import Server.Repos.HibernateTokenRepo;
import Server.Repos.HibernateUsersRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private HibernateTokenRepo tokenRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HibernateUsersRepo usersRepo;

    @Override
    public TokenDTO login(LoginForm loginForm) {
        User user = usersRepo.findByUserName(loginForm.getLogin());
        if(user != null){
            if(passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
                Token token = Token.builder().user(user).
                        value(RandomStringUtils.random(10, true, true)).build();
                tokenRepo.save(token);
                return TokenDTO.from(token);
            }
        }throw new IllegalArgumentException("User not found");
    }
}
