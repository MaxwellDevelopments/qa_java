package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    private final String predator = "Хищник";

    @Spy
    Feline felineSpied;


    @Test
    public void getFamilyReturnFeline() {
        String expected = "Кошачьи";
        String actual = felineSpied.getFamily();

        Assert.assertEquals(
                String.format(
                        "Ожидалось семейство %s, возвращено %s",
                        expected,
                        actual),
                actual,
                expected);
    }

    @Test
    public void callGetFoodFromEatMeat() throws Exception {

        Mockito.when(felineSpied.getFood(predator)).thenReturn(null);
        felineSpied.eatMeat();
        Mockito.verify(felineSpied).getFood(predator);


    }

    @Test
    public void getKittensWithNoArgumentsShouldCallGetKittensWithArgumentOne() {
        felineSpied.getKittens();
        Mockito.verify(felineSpied, Mockito.times(1)).getKittens(1);
    }

}
