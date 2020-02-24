package org.virtusa.numbertowords.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberToWordServiceTest {

    @Autowired
    NumberToWordService numberToWordService;

    @Test
    public void whenNumberToWordSuccessCase() {
        Assert.assertEquals("Number in words: one hundred twenty-three", numberToWordService.getNumberToWord("123"));
    }
    @Test
    public void whenNumberToWordFailureCase() {
        Assert.assertEquals("Enter valid Number Format", numberToWordService.getNumberToWord("abc"));
    }
    @Test
    public void whenNumberToWordFailureCaseforNegativeNumber() {
        Assert.assertEquals("Enter positive number", numberToWordService.getNumberToWord("-22"));
    }
    @Test
    public void whenNumberToWordFailureCaseforNull() {
        Assert.assertEquals("Null value", numberToWordService.getNumberToWord("null"));
    }
}