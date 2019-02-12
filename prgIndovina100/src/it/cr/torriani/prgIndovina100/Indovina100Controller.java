package it.cr.torriani.prgIndovina100;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Indovina100Controller {
	
	private int numInserito;
	private String msg;
	private Model m;
 
	@FXML
    private Button btnInizia;

    @FXML
    private TextField txtNumInserito;

    @FXML
    private Button btnInvia;
 
    @FXML
    private Label lblMessaggio;

	/**
	 * gestore bottone inizia
	 */
    @FXML
    void doInizia(ActionEvent event) {
    	m.Inizia();//----------------------------------MODEL.Inizia
    	abilitaBtnInvia();
       	lblMessaggio.setText("Inizio Tentativo 0");
       	txtNumInserito.clear();
    	txtNumInserito.requestFocus();
    }
   
	/**
	 * gestore bottone invia
	 */
@FXML
    void doInvia(ActionEvent event) {  	
    	String strNumInserito=txtNumInserito.getText();
    	try {
    		numInserito=Integer.parseInt(strNumInserito);   	
    	}catch(NumberFormatException ex) {
    		lblMessaggio.setText("Errore numero");
    		return;
    	}
    	
    	if(numInserito<1 || numInserito>Model.getNmax()) {
    		lblMessaggio.setText(
    		String.format(
    		"Numero fuori intervallo %d - %d",1,Model.getNmax()));
    		return;
    	}
    	//numero inserito correttamente
    	
    	//--------	
    	int conf;
    	try {  		
    		conf=m.Invia(numInserito);//----------------------MODEL.Invia
    	}catch(Exception e) {
    		msg=e.getMessage();
    		lblMessaggio.setText(msg);
    		return;
    	}	
    	//--------
    	msg="Tentativo "+m.getNumTentativi()+" ";
    	if(conf==0) {
    		lblMessaggio.setText(msg+"Hai vinto");
    		abilitaBtnInizia();//*****
    	}else if(conf==-1) {
    		lblMessaggio.setText(msg+"Tuo numero minore");
    	}else {
    		lblMessaggio.setText(msg+"Tuo numero maggiore");
    	} 
    	txtNumInserito.requestFocus();
    	txtNumInserito.selectAll();
    	//--------
    	if(!m.isInGioco()) {
    		if(conf!=0) {
    		lblMessaggio.setText(msg+
    				"Hai perso (TMax tentativi) Numero era "+m.getNumCaso());
    		}
       		abilitaBtnInizia(); //*****	
    	}
    }
    
    void abilitaBtnInizia() {
    	btnInizia.setDisable(false);
    	txtNumInserito.setDisable(true);
    	btnInvia.setDisable(true);
    }
    
    private void abilitaBtnInvia() {
       	btnInizia.setDisable(true);
    	txtNumInserito.setDisable(false);
    	btnInvia.setDisable(false);
    }   
    
	/**
	 * getter setter
	 */
	public void setM(Model m) {
		this.m = m;
	}
}


