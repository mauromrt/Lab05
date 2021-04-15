package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	this.txtCorretti.clear();
        this.txtErrati.clear();
    	
    	String parola;
    	try {
    	parola  = this.txtParola.getText(); // prendiamo la parola inserita e su cui andare a calcolare gli anagrammi
    	if(parola.equals("")) {
    		this.txtErrati.setText("Errore: nessuna parola inserita");
    		return;
    	}
    		
    	}catch(NullPointerException npe) {
    		this.txtErrati.setText("Devi inserire una parola!!");
    		return;
    	}
    	//List<String> anagrammi = new ArrayList<String>(model.calcolaAnagrammi(parola));
    	
    	
    	for(Anagramma a : model.calcolaAnagrammi(parola) ) {
    	  if(a.isCorretta())
    		 this.txtCorretti.appendText(a.getParola()+ "\n");
    	  
    	  else
    		  this.txtErrati.appendText(a.getParola()+"\n");
    	}
    	
    	
    
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtParola.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
