package user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class connectionCheck {

    @GetMapping("/ping")
    public String pong(){
        return "Hello from the user-service";
    }
}
