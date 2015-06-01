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

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		System.out.println(userDetailsService);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().antMatchers("/admin/**")
//			.access("hasRole('ROLE_ADMIN')").and().formLogin()
//			.loginPage("/login").failureUrl("/login?error")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.and().logout().logoutSuccessUrl("/login?logout")
//			.and().csrf()
//			.and().exceptionHandling().accessDeniedPage("/403");

		    	  http
		          .authorizeRequests().antMatchers("/","/hello", "/user/addNew").permitAll()
		          .antMatchers("/comment/delete").hasRole("ADMIN")//User.Roles.ROLE_ADMIN.toString())
		          .anyRequest()
		          .fullyAuthenticated().and().formLogin().loginPage("/login")
		          .failureUrl("/login?error").permitAll()
		          .and()
		          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout");
		          ;

	}
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//
//	}
}