package com.example.Lesbarkeit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SilbenAnzahlTest {
    @Test
    public void testOneSyllableWord() {
        String word = "Haus";
        int expected = 1;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testThreeSyllableWord() {
        String word = "Computer";
        int expected = 3;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testFiveSyllableWord() {
        String word = "Universität";
        int expected = 5;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testSevenSyllableWord() {
        String word = "Elefantentrompete";
        int expected = 7;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyWord() {
        String word = "";
        int expected = 1;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testWordWithHyphen() {
        String word = "Rind-fleisch-etikettierungs-überwachungs-aufgaben-übertragungs-gesetz";
        int expected = 20;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testWordWithSpaces() {
        String word = "Lorem ipsum dolor sit amet";
        int expected = 9;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestGermanWord(){
        String word = "Kraftfahrzeug-Haftpflichtversicherung";
        int expected =  9;
        int actual = SilbenAnzahl.countSyllablesInWord(word);
        assertEquals(expected, actual);
    }
}
