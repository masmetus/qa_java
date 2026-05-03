package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void shouldReturnDefaultKittensCount() {
        int expectedKitten = 1;
        int actualKitten = feline.getKittens();
        assertEquals(expectedKitten, actualKitten, "По умолчанию должно вернуться 1.");
    }


    @Test
    public void shouldReturnGivenKittensCount() {
        int expectedKitten = 5;
        int actualKitten = feline.getKittens(5);
        assertEquals(expectedKitten, actualKitten, "Должно вернуться: " + expectedKitten + " котят");
    }

    @Test
    public void shouldReturnFoodForFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Для хищника должны вернуться такие значения: 'Животные', 'Птицы', 'Рыба'");
    }

    @Test
    public void shouldReturnKittenFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual, "Должно вернуться 'Кошачьи'.");
    }

}
