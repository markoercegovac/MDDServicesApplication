package generator.mbrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MbrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbrsApplication.class, args);
	}

}