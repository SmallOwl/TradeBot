package tradeBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class, DataSourceAutoConfiguration.class, SqlInitializationAutoConfiguration.class})
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
  

}
