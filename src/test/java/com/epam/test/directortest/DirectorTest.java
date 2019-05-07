package com.epam.test.directortest;

import com.epam.task.director.Director;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DirectorTest {
    private Director director =new Director();
    @Test
    public void shouldReturnList(){
        Assert.assertNotNull(director.saxParse());
    }
    @Test
    public void shouldReturnNotNull(){
        Assert.assertNotNull(director.DOMParse());
    }
}
