package com.example.OlimpiadasUNAM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    /*
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }*/

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("ENTRENADOR")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("ADMIN");
    }*/

/*
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("erwinsmith")
                .password("levi")
                .roles("ENTRENADOR")
                .build();

        UserDetails user2 = User.builder()
                .username("minyoongi")
                .password("yanaega")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(
                user1, user2
        );
    }*/

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource((javax.sql.DataSource) dataSource)
                .usersByUsernameQuery("SELECT correo as username, contrasenia as password, enabled FROM (SELECT correo, contrasenia, enabled "
                        + "FROM administrador UNION SELECT correo, contrasenia, enabled FROM entrenador) as foo WHERE correo=?")
                .authoritiesByUsernameQuery("SELECT foo.correo as username, foo.rol as authority FROM (SELECT correo, rol "
                        + "FROM administrador UNION SELECT correo, rol FROM entrenador) as foo WHERE foo.correo = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/").hasAuthority("ADMINISTRADOR")
                .antMatchers("/*").hasAnyAuthority("ADMINISTRADOR", "ENTRENADOR","COMPETIDOR","JUEZ")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/dashboard", true)
                .and()
                .logout().logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
