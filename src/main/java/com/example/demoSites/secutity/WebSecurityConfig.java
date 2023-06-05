package com.example.demoSites.secutity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "spring.security.enable", havingValue = "true")
public class WebSecurityConfig  {

    public WebSecurityConfig(AuthenticationManagerBuilder managerBuilder, UserDetailService userDetailService) throws Exception {
        managerBuilder.userDetailsService(userDetailService);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/listener/**").hasRole("LISTENER")
                        .requestMatchers("/anonymous/**").permitAll()
        )
                .formLogin(formLogin ->{
                    formLogin.successHandler(new CustomAuthenticationSuccessHandler());
                    formLogin.loginPage("/anonymous/login");
                    formLogin.usernameParameter("username");
                    formLogin.passwordParameter("password");
                    formLogin.loginProcessingUrl("/perform-login");
                }) ;
        return httpSecurity.build();
//        httpSecurity
//                .csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/home").anonymous();
//        httpSecurity
//                .csrf()
//                .disable();
//        httpSecurity
//                .authorizeHttpRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .requestMatchers("/registration")
//                //Доступ только для пользователей с ролью Администратор
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/news").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//
//        return httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder.encode("user1Pass"))
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("user2")
//                .password(passwordEncoder.encode("user2Pass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
