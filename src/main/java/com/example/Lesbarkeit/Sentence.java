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
    private static TokenizerFactory tokenizerFactory = new IndoEuropeanTokenizerFactory();
    private static SentenceModel sentenceModel = new IndoEuropeanSentenceModel();

    public String[] getSentences(String text) {

        String[] whitespaces = new String[0];

        ArrayList<String> tokenList = new ArrayList<String>();
        ArrayList<String> whitespaceList = new ArrayList<String>();

        Tokenizer tokenizer = tokenizerFactory.tokenizer(text.toCharArray(), 0, text.length());
        tokenizer.tokenize(tokenList, whitespaceList);

        String[] tokens = new String[tokenList.size()];
        whitespaces = new String[whitespaceList.size()];

        tokenList.toArray(tokens);
        whitespaceList.toArray(whitespaces);

        int[] sentenceBoundaries = sentenceModel.boundaryIndices(tokens, whitespaces);

        String[] sentences = new String[sentenceBoundaries.length];

        for (int i = 0; i < sentenceBoundaries.length; ++i) {
            int start = sentenceBoundaries[i];
            int end = i == sentenceBoundaries.length - 1
                    ? tokens.length - whitespaces.length + 1
                    : sentenceBoundaries[i + 1];

            StringBuilder sb = new StringBuilder();
            for (int j = start; j < end; ++j) {
                sb.append(tokens[j]);
            }

            sentences[i] = sb.toString().trim();
        }

        return sentences;
    }
}
