package v1;

import java.net.URL;
import java.util.ResourceBundle;

import com.yananas.synsound.AudioEditor;
import com.yananas.synsound.AudioLibrary;
import com.yananas.synsound.AudioPlayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	private Button play;

	@FXML
	private TextField text;

	public void play(ActionEvent event) {
		String phoneme = text.getText();
		AudioPlayer.play(AudioEditor.union(AudioLibrary.phonemes(phoneme)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text.setText("-v la d'i m'i ir- pu t'i in- -ma la d'e ec-");
	}

}
