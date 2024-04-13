package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class TestAnimalParameterized {

    private final List<String> foodList;
    private final String foodType;

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    public TestAnimalParameterized(List<String> foodList, String foodType) {
        this.foodList = foodList;
        this.foodType = foodType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"}
        };
    }
    @Test
    public void getFoodWithParameters() throws Exception {
        List<String> expected = this.foodList;
        List<String> actual = animal.getFood(this.foodType);

        boolean result = Arrays.equals(actual.toArray(new String[0]), expected.toArray(new String[0]));
        // Проверка списков на равенство без учета порядка элементов
        MatcherAssert.assertThat(
                "Ожидаемый тип питания не соответствует возвращённому",
                result,
                is(true));
    }

}
