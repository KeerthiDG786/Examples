package com.mob.sts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityCongfig {

	/*
	 * @Bean Authentication public UserDetailsManager userdetails() {
	 * List<UserDetails> userDetails=new ArrayList<>();
	 * 
	 * userDetails.add(User.withUsername("keerthi")
	 * .password(passwordEncoder().encode("keeru@2123")) .roles("User") .build());
	 * return new InMemoryUserDetailsManager(userDetails);
	 * 
	 * }
	 */
	
	 @Autowired
	 UserDetailsService userDetails;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Autowired private AppBasicAuthenticationEntryPoint authenticationEntryPoint;
	 */

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
//	{
//        http.csrf().disable()
//                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated()).
//                httpBasic(Customizer.withDefaults());
//		
//		return http.build();
//
//	}
//	@Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//      return  http
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(authorize ->
//                authorize
//                    .requestMatchers("/sts").permitAll()
//                  
//                    .requestMatchers("/authenticate").authenticated()
//                    
//            )
//            .httpBasic(Customizer.withDefaults()).build();
//        
//       
//    }
	@Bean

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf().disable().authorizeHttpRequests().requestMatchers("authenticate")

				.permitAll().and().authorizeHttpRequests().requestMatchers("/sts", "/sts/**").authenticated()

				.and().httpBasic(Customizer.withDefaults()).build();
	}

	
	public AuthenticationProvider authProvider()
	{
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetails);
//        authenticationProvider.setPasswordEncoder();
        
        return authenticationProvider;

	}
}
