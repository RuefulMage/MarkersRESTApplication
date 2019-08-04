package Server;

import Server.Models.Entities.Token;
import Server.Repos.HibernateTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private HibernateTokenRepo tokenRepo;
    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;

        Token token  = tokenRepo.findByValue(tokenAuthentication.getName());

        if(token != null){
            // Исправить на вытаскивание из токена
            UserDetails userDetails = userDetailsService.loadUserByUsername(token.getUser().getUserName());
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        }else throw  new IllegalArgumentException("bad token");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TokenAuthentication.class.equals(aClass);
    }
}
