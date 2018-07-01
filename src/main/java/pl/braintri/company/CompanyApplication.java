package pl.braintri.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EntityScan(basePackageClasses = {CompanyApplication.class})
@SpringBootApplication
public class CompanyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}
}
