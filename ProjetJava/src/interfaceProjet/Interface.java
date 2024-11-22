package interfaceProjet;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interface extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		GridPane gbox = new GridPane();
		gbox.setAlignment(Pos.CENTER);
		gbox.setHgap(15);
		
		TextField txtf1 = new TextField();
		TextField txtf2 = new TextField();
		gbox.add(txtf1, 0, 0, 3, 1);
		gbox.add(txtf2, 0, 1, 3, 1);
		gbox.add(new Label("EUR"), 4, 0);
		gbox.add(new Label("JPY"), 4, 1);

		Scene scene = new Scene(gbox, 200, 75);

		txtf1.setText(String.valueOf(0));
		txtf2.setText(String.valueOf(0));
		
		txtf1.textProperty().addListener(
			new ChangeListener<String>() {
				@Override
				public void changed(
						ObservableValue<? extends String> observable,
						String oldValue,
						String newValue) {
					if (!newValue.isEmpty() && txtf1.isFocused() == true) {
						txtf2.setText(String.valueOf(Double.parseDouble(txtf1.getText()) * 120.2));
					}
				}
			}
		);
		
		txtf2.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue,
							String newValue) {
						if (!newValue.isEmpty() && txtf2.isFocused() == true) {
							txtf1.setText(String.valueOf(Double.parseDouble(txtf2.getText()) / 120.2));
						}
					}
				}
			);

		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}