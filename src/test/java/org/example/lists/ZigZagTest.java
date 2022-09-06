package org.example.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ZigZagTest {

    public static ZigZag zigZag;

    @BeforeEach
    public void before() {
        zigZag = new ZigZag();
    }

    @Test
    public void zigZagTestSanity() {

        // test the indexes show up in correct order instead of testing strings
        for (int i = 1; i < 40; i++) {
            List<Integer> expected = zigZag.buildAnswer(30, i);
            List<Integer> result = zigZag.betterNumbers(30, i);
            Assertions.assertEquals(expected, result);
        }
    }

}