package ie.cit.caf.config;

import java.util.ArrayList;
import java.util.List;

import ie.cit.caf.entity.User;
import ie.cit.caf.jparepo.UserJpaRepo;
import ie.cit.caf.service.UserServiceImpl;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 * 
 * @author R00048777 Kasia Brych
 * 
 * Application Security class sets up Spring Security
 *
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
/**
 * 
 * @param auth
 * @throws Exception
 * 
 * Method configures authentication 
 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		System.out.println(userDetailsService);
	}
/**
 * Method configures permission strings
 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		    	  http
		          .authorizeRequests().antMatchers("/","/hello", "/user/addNew").permitAll()
		          .antMatchers("/comment/delete/**", "/user/delete/**").hasRole("ADMIN")
		          .anyRequest()
		          .fullyAuthenticated().and().formLogin().loginPage("/login")
		          .failureUrl("/login?error").permitAll()
		          .and()
		          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout");
		          ;

	}
	/**
	 * Method configures athentication for in-memory user
	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//
//	}
}