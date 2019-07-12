package com.xsis.batch197.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserPrincipalDetailsService userService;
	
	@Autowired
	private AuthenticationSuccessHandler authSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authFailureHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/","/select-role").permitAll()
				.and()
				.formLogin().loginProcessingUrl("/login")
				.usernameParameter("username").passwordParameter("password").loginPage("/login").permitAll()
				.successHandler(authSuccessHandler).failureHandler(authFailureHandler).defaultSuccessUrl("/select-role")
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(2)
				.expiredUrl("/session-expired");
		/*.and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(2592000)
				.key("RahasiaDong!!").and().exceptionHandling().accessDeniedPage("/access-denied")*/
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(encoderPassword());
		daoAuthenticationProvider.setUserDetailsService(this.userService);

		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder encoderPassword() {
		return new BCryptPasswordEncoder();
	}

}
