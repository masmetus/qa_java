package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @BeforeEach
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void shouldReturnCatSound() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual, "Котик должен говорить 'Мяу'.");
    }

    @Test
    public void shouldReturnFoodForCat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood, "Для хищника должны вернуться такие значения: " + expectedFood);
    }
}
