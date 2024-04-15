package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    private final String predator = "Хищник";
    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getFoodShouldCallEatMeat() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(predator);
    }

    @Test
    public void getKittensShouldCallGetKittens() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
}
