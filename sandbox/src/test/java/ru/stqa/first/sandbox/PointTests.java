package ru.stqa.first.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance(){
        myFirstProgram s = new myFirstProgram(5, 6);
        Assert.assertEquals(s.myFirstProgram(), 5.0);

    }
}