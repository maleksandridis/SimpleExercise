/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package javafxapplicationjavelas;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import spellchecker.SpellingTest;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField textArea;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }


    @FXML
    private void checkWrittenText(ActionEvent event) {
    	String text = textArea.getText();
    	if (text != null && !text.isEmpty())
			SpellingTest.checkSpellingTest(text);
    	else
			System.out.println("The input given was empty.");
    }

    @FXML
    private void checkImportTxt(ActionEvent event) {
    	JFileChooser fileChooser = new JFileChooser();
		File testFile = fileChooser.getSelectedFile();
		if(testFile != null)
			System.out.println("Pixtis");
		System.out.println("Done");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
