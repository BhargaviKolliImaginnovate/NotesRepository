package Notes.com.example.Notesdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfiguration {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
//		http.authorizeHttpRequests().requestMatchers("/**").permitAll();
		http.authorizeHttpRequests().requestMatchers("/user/**").hasRole("user");
		http.authorizeHttpRequests().requestMatchers("/**").authenticated();
		http.csrf().disable();  // disable CSRF

		return http.build();
	}
}