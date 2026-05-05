package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    private Lion lion;

    @Mock
    Feline feline;

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void shouldReturnGivenLionKitten() throws Exception {
        int expected = 6;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual, "Ожидаем у льва: " + expected + " львят.");
    }

    @Test
    public void shouldReturnFoodForLion() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Для хищника должны вернуться такие значения: " + expectedFood);
    }
}
