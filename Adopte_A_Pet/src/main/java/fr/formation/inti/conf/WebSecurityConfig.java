package fr.formation.inti.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.csrf().disable();
    	
    	http.authorizeRequests().antMatchers("/*").permitAll();
    	
    	//On met les pages ou tous les visiteurs ont accès sans être loggé
    	http.authorizeRequests().antMatchers("/login","/inscription","/logout").permitAll().and().httpBasic();
    	
    	//On commence les restrictions sur certaines pages en fonction du title attribué à l'utilisateurs
//    	http.authorizeRequests().antMatchers("EXAMPLEAREMPLIR");
//    	.access("hasAnyTitle('TITLE_USER','TITLE_ADMIN')");
    	
    	//Controle de la redirection en cas d'accès à une page non valide pour un title
    	http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/pageErreurTitle");
    	
    	
    	
    	// Config du formulaire de connexion
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userAccountInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config de la page de déconnexion
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
 
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
    	
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}