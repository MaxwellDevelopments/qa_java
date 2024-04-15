package com.example;


import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TestAnimal {

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFamilyReturnString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        MatcherAssert.assertThat(
                String.format("Ожидалась строка: %s, но была возвращена: %s", expected, actual),
                animal.getFamily(),
                is(expected));
    }

    @Test
    public void getFoodThrowException() {
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual;
        try {
            animal.getFood("Абракадабра");
            actual = "Метод getFood с неправильным значением параметра не привёл к выбрасыванию исключения";
        }
        catch (Exception e) {
            actual = e.getMessage();
        }
        MatcherAssert.assertThat(
                String.format(
                        "Не возникло ошибки или ошибка не соответствует значению \"%s\",%nбыло возвращено: %s",
                        expected,
                        actual),
                actual,
                is(expected));
    }

}
