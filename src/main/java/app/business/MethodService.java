package app.business;

import org.springframework.stereotype.Component;

@Component
public class MethodService {


    public String getString(int a){
        if(a == 1){
            return "OK";
        }else {
            return "Not good";
        }
    }
}
