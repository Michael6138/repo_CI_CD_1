package app.business;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/helloKatya")
    public String helloKatya(){
        return "Hello Katya!";
    }
}
