package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class TestAlex {

    @Mock
    Feline feline;

    Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void doesHasManeReturnTrue() {
        MatcherAssert.assertThat(
                "Алекс почему-то без гривы",
                alex.doesHaveMane(),
                is(true));
    }

    @Test
    public void getPlaceOfLivingReturnNYZoo() {
        String expected = "New-York zoo";
        String actual = alex.getPlaceOfLiving();

        MatcherAssert.assertThat(
                String.format("Дом Алекса не зоопарк Нью-Йорка, а %s", actual),
                actual,
                is(expected));
    }

    @Test
    public void getFriendsReturnList() {
        List<String> expected = new ArrayList<>(Arrays.asList("Марти", "Глория", "Мелман"));
        List<String> actual = alex.getFriends();

        // Проверка списков на равенство без учета порядка элементов
        MatcherAssert.assertThat(
                String.format("Друзья Алекса должны быть %s", Arrays.toString(expected.toArray(new String[0]))),
                actual,
                hasItems(expected.toArray(new String[0])));
    }

    @Test
    public void alexGetKittensCallsGetKittensZero() {
        alex.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
    }


}
