package app.business;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class MethodServiceTest {

    MethodService methodService = new MethodService();


    @Test
    public void test1(){
        Assertions.assertEquals("OK", methodService.getString(1));

    }


    @Test
    public void test2(){
        Assertions.assertEquals("Not good", methodService.getString(2));

    }

}