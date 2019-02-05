package com.lti.training.Scomponent;

import org.springframework.stereotype.Component;

@Component("spellcheck") 
public class SpellChecker implements SpellCheckerInterface {
	public void checkSpellingMistakes(String document) {
		 System.out.println("spell checker executed for this " +document);
	}
}
