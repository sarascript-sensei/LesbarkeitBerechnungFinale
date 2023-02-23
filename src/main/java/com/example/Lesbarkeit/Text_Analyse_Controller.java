package com.example.Lesbarkeit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller

public class Text_Analyse_Controller {
    @GetMapping("/text_analyse")
    public String text_analyseForm(Model model, SilbenAnzahl silbenAnzahl) {
      model.addAttribute("text_analyse", new TextAnalyse());
      model.addAttribute("silben_anzahl", silbenAnzahl);
      return "text_analyse";
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }
  
    @PostMapping("/text_analyse")
    public String text_analyseSubmit(@ModelAttribute TextAnalyse textAnalyse, Model model, HttpServletResponse response) {
        model.addAttribute("silben_anzahl", SilbenAnzahl.countSyllables(textAnalyse.getContent()));
        model.addAttribute("getNumberOfWords", TextAnalyse.getNumberOfWords());
        model.addAttribute("getNumberOfCharacters", textAnalyse.getNumberOfCharacters());
        model.addAttribute("numberOfDiphthongs", TextAnalyse.numberOfDiphthongs());
        model.addAttribute("getNumberOfSentences", textAnalyse.getNumberOfSentences());
        model.addAttribute("getReadingTime", TextAnalyse.getReadingTime());
        model.addAttribute("getSpeakingTime", TextAnalyse.getSpeakingTime());
        model.addAttribute("getFleschReadingEase", textAnalyse.getFleschReadingEase());
        model.addAttribute("getAge", textAnalyse.getAge());
        model.addAttribute("getFlesch_Kincaid_Grade_Level", textAnalyse.getFlesch_Kincaid_Grade_Level());
        model.addAttribute("getLIX", textAnalyse.getLIX());
        model.addAttribute("calculateWienerSachtextformel", textAnalyse.calculateWienerSachtextformel());
        model.addAttribute("getNumberOfWordsPerSentence", textAnalyse.getNumberOfWordsPerSentence());
        model.addAttribute("precentageOfComplexWords", textAnalyse.precentageOfComplexWords());
        model.addAttribute("getGunningFog", textAnalyse.getGunningFog());

        // das aktualisierte TextAnalyse-Objekt zum Modell hinzufügen
        model.addAttribute("text_analyse", textAnalyse.getContent());

        // den Wert des Inhaltsfeldes im TextAnalyse-Objekt löschen
        TextAnalyse.setContent("");

        return "result";
    }

}