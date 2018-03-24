package v0;

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
	private TextField frequency;

	@FXML
	private TextField time;

	public void play(ActionEvent event) {
		String f = frequency.getText();
		String t = time.getText();
		AudioPlayer.play(AudioLibrary.note(Double.parseDouble(t), Double.parseDouble(f)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		frequency.setText("440.0");
		time.setText("2");
	}

}
