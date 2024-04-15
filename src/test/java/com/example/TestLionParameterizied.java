package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class TestLionParameterizied {

    private final Boolean hasMane;
    private final String sex;

    Lion lion;

    public TestLionParameterizied(Boolean hasMane, String sex) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {false, "Самка"},
                {true, "Самец"},
                {null, "Андрогин"},
                {null, null},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        if (this.sex == null || !(this.sex.equals("Самка") || this.sex.equals("Самец"))) {
            return;
        }

        lion = new Lion(this.sex, null);
        MatcherAssert.assertThat(
                String.format(
                        "%s %sимеет гриву",
                        this.sex,
                        this.sex.equals("Самец") ? "не " : ""),
                hasMane,
                is(lion.doesHaveMane()));
    }

    @Test
    public void sexInConstructorThrowException() throws Exception {
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual;

        try {
            lion = new Lion(this.sex, null);
        }
        catch (Exception e) {
            if (this.sex != null && (this.sex.equals("Самка") || this.sex.equals("Самец"))) {
                actual = String.format("Параметр пола с значением %s в конструкторе Lion выбросил ошибку", this.sex);
            }
            else {
                actual = e.getMessage();
            }
            MatcherAssert.assertThat(
                    "Текст в выброшенной ошибке в конструкторе Lion не соответствует ожидаемому",
                    actual,
                    is(expected)
            );
            return;
        }

        if (!this.sex.equals("Самка") && !this.sex.equals("Самец")) {
            throw new Exception(this.sex + " в конструкторе не выбросило ошибку");
        }


    }

}
