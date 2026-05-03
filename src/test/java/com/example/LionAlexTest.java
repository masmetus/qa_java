package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionAlexTest {

    private LionAlex alex;

    @Mock
    Feline feline;


    @BeforeEach
    public void setUp() throws Exception {
        alex = new LionAlex(feline);
    }

    @Test
    public void shouldReturnListOfFriends() {
        List<String> expectedFriendsList = new ArrayList<>(List.of("Марти", "Глория", "Мелман"));
        List<String> actualFriendsList = alex.getFriends();
        assertEquals(expectedFriendsList, actualFriendsList, "Список друзей не совпадает.");
    }

    @Test
    public void shouldReturnLivingPlace() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(expected, actual, "Место жительства не совпадает.");
    }

    @Test
    public void shouldReturnZeroKittens() {
        int expected = 0;
        int actual = alex.getKittens();
        assertEquals(expected, actual, "Количество львят не совпадает.");
    }
}
