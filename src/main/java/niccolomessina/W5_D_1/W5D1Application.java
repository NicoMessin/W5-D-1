package niccolomessina.W5_D_1;

import niccolomessina.W5_D_1.config.ConfigClass;
import niccolomessina.W5_D_1.entities.MenuEffettivo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class W5D1Application {

	public static void main(String[] args) {
		SpringApplication.run(W5D1Application.class, args);


		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigClass.class);


		MenuEffettivo menu = ctx.etBean(MenuEffettivo.class);
		menu.print();


		ctx.close();
	}
}