package org.ecn.version2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;


class CombinationTest {
    private final Combination combination = new Combination();

    @Test
    void testGenerateCombination() {
        combination.generateCombination();
        String combinationString = combination.getCombinationString();
        assertEquals(4, combinationString.length());
        for (int i = 0; i < 4; i++) {
            assertTrue(combination.getPossibleColors().contains(Character.toString(combinationString.charAt(i))));
        }
    }

    @Test
    void testChooseCombination() {
        String combinationInput = "ybgr";
        byte[] input = combinationInput.getBytes();
        InputStream inputStream = new ByteArrayInputStream(input);

        combination.chooseCombination(inputStream, null);
        String combinationString = combination.getCombinationString();
        assertEquals(4, combinationString.length());
        for (int i = 0; i < 4; i++) {
            assertTrue(combination.getPossibleColors().contains(Character.toString(combinationString.charAt(i))));
        }
    }

    @Test
    void testCheckCombination() {
        combination.setCombinationString("ybgr");
        String guess = "yyyy";
        String markers = combination.checkCombination(guess);
        assertEquals("bwww", markers);
        guess = "ybrg";
        markers = combination.checkCombination(guess);
        assertEquals("bbww", markers);
    }

    @Test
    void testReset() {
        combination.setCombinationString("yyyy");
        combination.reset();
        assertEquals("", combination.getCombinationString());
    }
}
