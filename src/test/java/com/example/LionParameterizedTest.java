package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {

    @Mock
    Feline feline;

    @ParameterizedTest
    @CsvSource({"Самка, false",
            "Самец, true"})
    public void shouldCheckManePresenceDependingOnSex(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual, "Ошибка в наличие гривы у: " + sex);
    }

    @ParameterizedTest
    @CsvSource({"Оно", "Вертолет", "САМЕЦ", "САМКА"})
    public void shouldReturnErrorOnUnexpectedSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(sex, feline);
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedMessage, exception.getMessage());
    }


}