package ie.cit.caf.config;

	import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	@Configuration
	@EnableAutoConfiguration
	@ComponentScan(basePackages = "ie.cit.caf.repository")
	public class DefaultConfig {
		
	}


