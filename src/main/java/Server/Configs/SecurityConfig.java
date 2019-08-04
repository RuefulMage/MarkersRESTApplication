package Server.Configs;


import Server.Services.UserDetail.UserDetailsServiceImpl;
import Server.Services.UserServiceImpl;
import Server.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**").authenticationProvider(authenticationProvider)
                .authorizeRequests().antMatchers("/users/**").hasAuthority("USER")
                .antMatchers("/login").permitAll()
                .and().csrf().disable();
    }
    @Bean
    public UserDetailsService userService(){
        return new UserDetailsServiceImpl();
    }
}
