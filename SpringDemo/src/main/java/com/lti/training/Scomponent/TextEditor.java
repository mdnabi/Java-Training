package com.lti.training.Scomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("te")
public class TextEditor implements TextEditorInterface {
	
	@Autowired   //Implements the Dependency Injection to use the methods of the object of SpellChecker
	@Qualifier("spellcheck")
	private SpellChecker spellchecker;
	
	public void
	loadTextDocument(String document) {
		System.out.println("loaded" +document);
//		SpellCheckerInterface check = new SpellChecker(); // for this autowired is used
		spellchecker.checkSpellingMistakes(document);  //of different language
		
	}
}
