package visual;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	public static Stage stage;
	
	@Override
	public void start(Stage stg) throws IOException, InterruptedException {
		
		stg = new Stage(StageStyle.TRANSPARENT);
		Parent tela = FXMLLoader.load(getClass().getResource("Tela.fxml"));
		Scene cena = new Scene(tela);
		cena.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
		
		stg.setScene(cena);
		stg.show();
		
		stage = stg;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
