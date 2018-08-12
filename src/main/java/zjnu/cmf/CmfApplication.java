package zjnu.cmf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("zjnu.cmf.project.mapper")
public class CmfApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfApplication.class, args);
    }
}
