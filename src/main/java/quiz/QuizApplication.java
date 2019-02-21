package quiz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan(basePackages="quiz")
@SpringBootApplication
public class QuizApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
	SpringApplication.run(QuizApplication.class, args);

	}
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(QuizApplication.class);
	    }
	 
	 

}

