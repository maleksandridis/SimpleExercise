

import java.util.Scanner;


public class SpellChecker {

	private JavelasApp javelasApp;

	public SpellChecker(JavelasApp javelasApp) {
		this.javelasApp = javelasApp;
	}

	public void checkSpelling(String text) {

		Word.createPunMap();
		Word word = new Word(null);
		Scanner input = new Scanner(System.in);

		for (String wordStr: text.split(" ")) {
			if (!wordIsValid(wordStr)) {
				//javelasApp.showEmptyScene();
				//javelasApp.showMistakeMenu(wordStr);



				int choice = input.nextInt();
				while (choice < 1 || choice > 3) {
					System.out.print("Invalid choice. Please try again.\nChoice: ");
					choice = new Scanner(System.in).nextInt();
				}
				word.handleMistake(choice);
			}
		}
		input.close();
	}

	public boolean wordIsValid(String wordStr) {
		boolean exists = false;
		Word word = new Word(wordStr);
		for (Dictionary dictionary: Dictionary.dictionaries) {
			if (word.getWordStr().matches("-?\\d+(\\.\\d+)+(\\,\\d+)?") || word.getWordStr().matches("-?\\d+(\\,\\d+)+(\\.\\d+)?")) {
				exists = true;
			} else {
				if (dictionary.wordExists(word)) {
					exists = true;
				}

				if (word.getWordStr().length() >= 2 && dictionary.wordExists(new Word(word.getWordStr().substring(0, 1).toLowerCase() + word.getWordStr().substring(1)))) {
					exists = true;
				}
			}
		}
		return exists;
	}
}
