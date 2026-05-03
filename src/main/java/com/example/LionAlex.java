package com.example;

import java.util.ArrayList;
import java.util.List;

public class LionAlex extends Lion {

    private final List<String> friends = new ArrayList<>(List.of("Марти", "Глория", "Мелман"));

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

}
