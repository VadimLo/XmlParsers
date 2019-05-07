package com.epam.test.validatortest;

import com.epam.task.validation.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorTest {
    @Test
    public void shouldCheckXMLAndReturnTrue(){
        Validator validator = new Validator();
        Assert.assertTrue(validator.checkXMLFile("src\\main\\resources\\gems.xml"));
    }
}
