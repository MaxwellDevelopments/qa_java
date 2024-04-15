package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestFelineParameterizied {

    private final int kittensCount;

    public TestFelineParameterizied(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[]{1, 0, -5, 10, 15, Integer.MAX_VALUE};
    }

    @Test
    public void test() {
        Integer expected = this.kittensCount;
        Integer actual = new Feline().getKittens(this.kittensCount);
        Assert.assertEquals(
                String.format("Ожидалось котят %d, возвращено %d", expected, actual),
                actual,
                expected);
    }

}
