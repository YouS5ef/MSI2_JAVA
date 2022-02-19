package ma.yab.cigmaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"ma.yab.cigmaproject"})
public class CigmaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CigmaProjectApplication.class, args);
	}

}
