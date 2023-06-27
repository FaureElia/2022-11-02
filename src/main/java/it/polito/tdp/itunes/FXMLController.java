/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.itunes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.itunes.model.Genre;
import it.polito.tdp.itunes.model.Model;
import it.polito.tdp.itunes.model.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnPlaylist"
    private Button btnPlaylist; // Value injected by FXMLLoader

    @FXML // fx:id="cmbGenere"
    private ComboBox<Genre> cmbGenere; // Value injected by FXMLLoader

    @FXML // fx:id="txtDTOT"
    private TextField txtDTOT; // Value injected by FXMLLoader

    @FXML // fx:id="txtMax"
    private TextField txtMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtMin"
    private TextField txtMin; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCalcolaPlaylist(ActionEvent event) {
    	

    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	Genre genre=this.cmbGenere.getValue();
    	String minS=this.txtMin.getText();
    	String maxS=this.txtMax.getText();
    	if(genre==null || minS==null || maxS==null) {
    		this.txtResult.setText("inserire un genere");
    		return;
    	}
    	try {
    		double min=Double.parseDouble(minS);
    		double max=Double.parseDouble(maxS);
    		List<Set<Track> >vertici=this.model.creaGrafo(genre,min,max);	
    		if(vertici==null) {
    			this.txtResult.setText("inserire valori compatibili con il minimo e il massimo");
    		}
    		this.txtResult.setText("trovato grafo con: "+this.model.getVertici() +" vertici\n");
    		this.txtResult.appendText("trovato grafo con: "+this.model.getNodi() +" nodi\n");
    		
    		for(Set<Track> compConn: vertici) {
    			this.txtResult.appendText("componente connessa, dimensione : "+compConn.size()+".Numero Playlist:"+ this.model.numeroPlaylist(compConn)+"\n");
    		}
    		
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("inserire numeri");
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnPlaylist != null : "fx:id=\"btnPlaylist\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbGenere != null : "fx:id=\"cmbGenere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDTOT != null : "fx:id=\"txtDTOT\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMin != null : "fx:id=\"txtMin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.cmbGenere.getItems().addAll(model.getGenres());
    }

}
