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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	private Button play;

	@FXML
	private TextArea text;

	@FXML
	private TextArea samples;

	@FXML
	private TextField vowel;

	public void play(ActionEvent event) {
		double vowelDur = Double.parseDouble(vowel.getText());
		TextTransformer tt = new TextTransformer();
		String cyrillicText = text.getText();
		cyrillicText = Hyphenator.textToSamples(cyrillicText);
		cyrillicText = tt.transform(cyrillicText);
		samples.setText(cyrillicText);
		AudioPlayer.play(AudioEditor.union(AudioLibrary.phonemes(cyrillicText, vowelDur)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		text.setText("Привет мир");
		vowel.setText("100");
	}

}
