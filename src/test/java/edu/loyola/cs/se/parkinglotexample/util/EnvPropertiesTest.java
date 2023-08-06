package edu.loyola.cs.se.parkinglotexample.util;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnvPropertiesTest {
    @Test
    public void smokeTest(){
        EnvProperties env = EnvProperties.getInstance();
        //If it does not raise any exception it worked.
        //Since there are no assertions, this is a smoke test
    }

    @Test
    public void testEnvFileDoesNotExist(){
        Exception exception = assertThrows(IOException.class, () -> {
            EnvProperties.getInstance().readFromFile("doesnotexist.test");
        });
    }

    @Test
    public void testGettingOneProperty(){
        String value = EnvProperties.get("testproperty");
        assertEquals(value,"123456");
    }

}
