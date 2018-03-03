package upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileLoadApplication {
  public static void main(String[] args) throws Exception {
	SpringApplication.run(FileLoadApplication.class, args);
}

}
