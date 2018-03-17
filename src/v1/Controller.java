package v1;

import java.net.URL;
import java.util.ResourceBundle;

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
		AudioPlayer player = new AudioPlayer();
		String phoneme = text.getText();
		// 1 call phonems(String phonemsSequence)
		// 2 call audio editor uninon method
		player.play(AudioLibrary.phoneme(phoneme));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
