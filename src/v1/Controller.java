package v1;

import java.net.URL;
import java.util.ResourceBundle;

import com.yananas.synsound.AudioEditor;
import com.yananas.synsound.AudioLibrary;
import com.yananas.synsound.AudioPlayer;
import com.yananas.synsound.experiments.Hyphenator;
import com.yananas.synsound.experiments.TextTransformer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class Controller implements Initializable {

	@FXML
	private Button play;

	@FXML
	private TextArea text;

	@FXML
	private TextArea samples;

	@FXML
	private ChoiceBox<String> examples;

	public void play(ActionEvent event) {
		TextTransformer tt = new TextTransformer();
		String cyrillicText = text.getText();
		cyrillicText = Hyphenator.textToSamples(cyrillicText);
		cyrillicText = tt.transform(cyrillicText);
		samples.setText(cyrillicText);
		AudioPlayer.play(AudioEditor.union(AudioLibrary.phonemes(cyrillicText)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text.setText("Привет мир");
	}

}
