import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/9/28.
 */
@Configuration
@ComponentScan(value = "com.sss")
@EnableAutoConfiguration
@MapperScan(value = "com.sss.user.mapper")
public class BootProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootProjectApplication.class, args);
    }
}
