package org.ecn.version2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class CombinationTest {
    private Combination combination = new Combination();

    @Test
    public void testGenerateCombination() {
        combination.generateCombination();
        String combinationString = combination.getCombination();
        assertTrue(combinationString.length() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(combination.getPossibleColors().contains(Character.toString(combinationString.charAt(i))));
        }
    }

    @Test
    public void testChooseCombination() {
        String combinationInput = "ybgr";
        byte[] input = combinationInput.getBytes();
        InputStream inputStream = new ByteArrayInputStream(input);

        combination.chooseCombination(inputStream);
        String combinationString = combination.getCombination();
        assertTrue(combinationString.length() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(combination.getPossibleColors().contains(Character.toString(combinationString.charAt(i))));
        }
    }

    @Test
    public void testCheckCombination() {
        combination.setCombination("ybgr");
        String guess = "yyyy";
        String markers = combination.checkCombination(guess);
        assertEquals("bwww", markers);
        guess = "ybrg";
        markers = combination.checkCombination(guess);
        assertEquals("bbww", markers);
    }

    @Test
    public void testReset() {
        combination.setCombination("yyyy");
        combination.reset();
        assertEquals("", combination.getCombination());
    }
}
