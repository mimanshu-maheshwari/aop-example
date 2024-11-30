package mm.vivarta.av;

import mm.vivarta.av.service.impl.ArgLoggingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service implements CommandLineRunner {

  @Autowired
  private ArgLoggingServiceImpl service;

  public static void main(String ...args) {
    SpringApplication.run(Service.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    service.processInput(args);
  }

}
