package com.example;

import java.util.List;
import java.util.Arrays;

public class Alex extends Lion {
    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "New-York zoo";
    }

    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }
}
