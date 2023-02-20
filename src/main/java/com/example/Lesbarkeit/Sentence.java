package com.example.Lesbarkeit;
import com.aliasi.sentences.IndoEuropeanSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

import java.util.ArrayList;

/**
 Die Klasse Sentence stellt eine Methode bereit, um einen Text in einzelne Sätze zu unterteilen.
 Sie verwendet dazu das TokenizerFactory-Objekt und das SentenceModel-Objekt von LingPipe.
 @author [Sara Niiazakhunova]
 @version 2.0
 */

public class Sentence {
    private TokenizerFactory tokenizerFactory; // TokenizerFactory-Objekt
    private SentenceModel sentenceModel; // SentenceModel-Objekt

    public Sentence() {
        // TokenizerFactory- und SentenceModel-Objekte initialisieren
        tokenizerFactory = new IndoEuropeanTokenizerFactory(); // Initialisiere TokenizerFactory
        sentenceModel = new IndoEuropeanSentenceModel(); // Initialisiere SentenceModel
    }

    public String[] getSentences(String text) {
        // Text in Tokens aufteilen
        ArrayList<String> tokenList = new ArrayList<>();
        ArrayList<String> whiteList = new ArrayList<>();
        Tokenizer tokenizer = tokenizerFactory.tokenizer(text.toCharArray(), 0, text.length());
        tokenizer.tokenize(tokenList, whiteList);

        // Satzgrenzen bestimmen
        String[] tokens = tokenList.toArray(new String[0]);
        String[] whites = whiteList.toArray(new String[0]);
        int[] sentenceBoundaries = sentenceModel.boundaryIndices(tokens, whites);

        // Wenn es keine Satzgrenzen gibt, gib ein leeres Array zurück
        if (sentenceBoundaries.length < 1) {
            return new String[0];
        }

        // Text in Sätze aufteilen
        String[] sentences = new String[sentenceBoundaries.length];
        int sentenceStartToken = 0;
        for (int i = 0; i < sentenceBoundaries.length; i++) {
            int sentenceEndToken = sentenceBoundaries[i];
            StringBuilder sentence = new StringBuilder();
            for (int j = sentenceStartToken; j <= sentenceEndToken; j++) {
                sentence.append(tokens[j]).append(whites[j + 1]);
            }
            sentences[i] = sentence.toString().trim();
            sentenceStartToken = sentenceEndToken + 1;
        }

        // Gib das Array der Sätze zurück
        return sentences;
    }
}
