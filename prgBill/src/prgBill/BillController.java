package prgBill;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BillController 
{
	private Bill m;
	
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources; 

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location; 

    @FXML // fx:id="txtImporto"
    private TextField txtImporto; // Value injected by FXMLLoader

    @FXML // fx:id="txaScontrino"
    private TextArea txaScontrino; // Value injected by FXMLLoader

    @FXML // fx:id="txtMancia"
    private TextField txtMancia; // Value injected by FXMLLoader

    @FXML // fx:id="dpData"
    private DatePicker dpData; // Value injected by FXMLLoader

    @FXML // fx:id="btnInvia"
    private Button btnInvia; // Value injected by FXMLLoader
    
    @FXML
    void doInvia(ActionEvent event) 
    {
    	String txt;
    	double importo = 0;
    	double mancia = 0;
    	
    	txaScontrino.clear();
    	
    	txt = txtImporto.getText();	
    	try {
    		importo = Double.parseDouble(txtImporto.getText());
    	}
    	catch(NumberFormatException e) {
    		txaScontrino.appendText("Err. L'importo \n<"
    					+txt+ "> non è corretto\n");
    		return;
    	}
 
    	txt = txtMancia.getText();
    	try {
    		mancia = Double.parseDouble(txtMancia.getText());
    	}
    	catch(NumberFormatException e) {
    		txaScontrino.appendText("Err. Mancia \n<" 
    	+txt+ "> non è corretto\n");
    		return;
    	}
    	
    	
    	try{
    		 m = new Bill(importo,mancia); 
    		 //ATTENZIONE: err Bill m=new(importo,mancia); 
    	}
    	catch(Exception e) {
    		txaScontrino.setText(e.getMessage());
    		return;
    	}
    	//non ci sono errori di input
    	LocalDate data = dpData.getValue();
    	String strData=data.format(
    			DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	txaScontrino.setText(strData+"\n");
    	txaScontrino.appendText(m.toString());
    	
    	
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
        assert txtImporto != null : "fx:id=\"txtImporto\" was not injected: check your FXML file 'Bill.fxml'.";
        assert txaScontrino != null : "fx:id=\"txaScontrino\" was not injected: check your FXML file 'Bill.fxml'.";
        assert txtMancia != null : "fx:id=\"txtMancia\" was not injected: check your FXML file 'Bill.fxml'.";
        assert dpData != null : "fx:id=\"dpData\" was not injected: check your FXML file 'Bill.fxml'.";
        assert btnInvia != null : "fx:id=\"btnInvia\" was not injected: check your FXML file 'Bill.fxml'.";
        dpData.setValue(LocalDate.now());
        //txaScontrino.setDisable(true);
        txaScontrino.setEditable(false);
    }
}
