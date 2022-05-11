package dgsw.hs.kr.dgsw_transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class DgswTransferApplication {
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DgswTransferApplication.class);
        application.setLogStartupInfo(false);
        application.run(args);
    }

}
