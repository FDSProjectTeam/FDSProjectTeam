package fdsprojectteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class FdsProjectTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdsProjectTeamApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "thymeleaf/index";
    }
}
