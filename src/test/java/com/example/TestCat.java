package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    private final String meow = "Мяу";

    @Mock
    Feline predator;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(predator);
    }


    @Test
    public void getSoundReturnMeow() {
        String actual = cat.getSound();
        Assert.assertEquals(
                String.format(
                        "Ожидалось %s, возвращено %s",
                        meow,
                        actual),
                meow,
                actual);
    }

    @Test
    public void getFoodShouldCallEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }
}
