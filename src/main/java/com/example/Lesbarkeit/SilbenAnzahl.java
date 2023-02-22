package com.example.Lesbarkeit;

/**

 Diese Klasse zählt die Silbenanzahl von Wörtern und Sätzen und berechnet

 den Anteil von Wörtern mit einer Silbe bzw. von Wörtern mit drei oder mehr Silben.
 */
public class SilbenAnzahl {

    // Vokale, die für die Zählung von Silben verwendet werden
    private static final String VOWELS = "aeiouyäöü";

    /**
     * Diese Methode zählt die Anzahl der Silben in einem Wort.
     * @param word das zu zählende Wort
     * @return die Anzahl der Silben im Wort
     */
    public static int countSyllablesInWord(String word) {
        word = word.toLowerCase();
        int syllableCount = 0;
        boolean lastCharWasVowel = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (VOWELS.indexOf(c) != -1) {
                if (!lastCharWasVowel) {
                    syllableCount++;
                }
                lastCharWasVowel = true;
            } else {
                lastCharWasVowel = false;
            }
        }
        if (syllableCount == 0) {
            syllableCount = 1;
        }
        return syllableCount;
    }

    /**

     Diese Methode zählt die Anzahl der Silben in einem Satz.

     @param sentence der zu zählende Satz

     @return die Anzahl der Silben im Satz
     */
    public static int countSyllables(String sentence) {
        String[] words = sentence.split(" ");
        int syllableCount = 0;

        for (String word : words) {
            syllableCount += countSyllablesInWord(word);
        }

        return syllableCount;
    }

    /**

     Diese Methode berechnet den Anteil von Wörtern mit einer Silbe in einem Satz.

     @param sentence der zu untersuchende Satz

     @return der Anteil von Wörtern mit einer Silbe in Prozent
     */
    public static double percentageOfWordsWithOneSyllable(String sentence) {
        String[] words = sentence.split(" ");
        int oneSyllableWordCount = 0;

        for (String word : words) {
            if (countSyllablesInWord(word) == 1) {
                oneSyllableWordCount++;
            }
        }

        return (double) oneSyllableWordCount / words.length * 100;
    }

    /**

     Diese Methode berechnet den Anteil von Wörtern mit drei oder mehr Silben in einem Satz.

     @param sentence der zu untersuchende Satz

     @return der Anteil von Wörtern mit drei oder mehr Silben in Prozent
     */
    public static double percentageOfWordsWithThreeOrMoreSyllables(String sentence) {
        String[] words = sentence.split(" ");
        int threeOrMoreSyllableWordCount = 0;

        for (String word : words) {
            if (countSyllablesInWord(word) >= 3) {
                threeOrMoreSyllableWordCount++;
            }
        }

        return (double) threeOrMoreSyllableWordCount / words.length * 100;
    }
}
