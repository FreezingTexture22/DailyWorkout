package ru.andreisesiunin.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {

    @Test
    public void mainTest() {
        Main main = new Main();
        var result = main.addition(2,2);
        Assertions.assertEquals(4, result, "Wrong result");



    }

}
