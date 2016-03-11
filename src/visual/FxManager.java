package visual;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import fachada.OFacade;

public class FxManager implements Initializable {

	@FXML
	TextField textMsg;
	@FXML
	public static ListView<String> listPortas;
	@FXML
	Button botConectar, botEnviar, botDesconectar, botLimpar;
	@FXML
	static TextArea areaConsole;
	@FXML
	Label labEstado, labX, lab_;
	@FXML
	Pane paneMovel;
	@FXML
	Circle fechar, minimizar, reiniciar;
	@FXML
	Circle led11, led12, led13, led14, led15, led16, led17, led18;
	@FXML
	Circle led21, led22, led23, led24, led25, led26, led27, led28;
	@FXML
	Circle led31, led32, led33, led34, led35, led36, led37, led38;
	@FXML
	Circle led41, led42, led43, led44, led45, led46, led47, led48;
	@FXML
	Circle led51, led52, led53, led54, led55, led56, led57, led58;
	@FXML
	Circle led61, led62, led63, led64, led65, led66, led67, led68;
	@FXML
	Circle led71, led72, led73, led74, led75, led76, led77, led78;
	@FXML
	Circle led81, led82, led83, led84, led85, led86, led87, led88;

	OFacade of;
	String op;
	boolean led = false;
	double x, y;

	public EventHandler<MouseEvent> getEventHandler(final Circle ledCircle,
			final int coord1, final int coord2) {

		EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (led == false) {
					ledCircle.setFill(Color.RED);
					of.enviar2Coord(coord1, coord2);
					led = true;
				} else if (led) {
					ledCircle.setFill(Color.GRAY);
					of.apagar2Coord(coord1, coord2);
					led = false;
				}
			}
		};

		return event;
	}

	public EventHandler<MouseEvent> getEventHandler(final Circle ledCircle,
			final int coord) {

		EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (led == false) {
					ledCircle.setFill(Color.RED);
					of.enviarCoord(coord);
					led = true;
				} else if (led) {
					ledCircle.setFill(Color.GRAY);
					of.apagarCoord(coord);
					led = false;
				}
			}
		};

		return event;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		new OFacade.ListarPortas();

		led11.setOnMouseClicked(getEventHandler(led11, '1'));
		led12.setOnMouseClicked(getEventHandler(led12, '2'));
		led13.setOnMouseClicked(getEventHandler(led13, '3'));
		led14.setOnMouseClicked(getEventHandler(led14, '4'));
		led15.setOnMouseClicked(getEventHandler(led15, '5'));
		led16.setOnMouseClicked(getEventHandler(led16, '6'));
		led17.setOnMouseClicked(getEventHandler(led17, '7'));
		led18.setOnMouseClicked(getEventHandler(led18, '8'));
		led21.setOnMouseClicked(getEventHandler(led21, '9'));
		led22.setOnMouseClicked(getEventHandler(led22, '1', '0'));
		led23.setOnMouseClicked(getEventHandler(led23, '1', '1'));
		led24.setOnMouseClicked(getEventHandler(led24, '1', '2'));
		led25.setOnMouseClicked(getEventHandler(led25, '1', '3'));
		led26.setOnMouseClicked(getEventHandler(led26, '1', '4'));
		led27.setOnMouseClicked(getEventHandler(led27, '1', '5'));
		led28.setOnMouseClicked(getEventHandler(led28, '1', '6'));
		led31.setOnMouseClicked(getEventHandler(led31, '1', '7'));
		led32.setOnMouseClicked(getEventHandler(led32, '1', '8'));
		led33.setOnMouseClicked(getEventHandler(led33, '1', '9'));
		led34.setOnMouseClicked(getEventHandler(led34, '2', '0'));
		led35.setOnMouseClicked(getEventHandler(led35, '2', '1'));
		led36.setOnMouseClicked(getEventHandler(led36, '2', '2'));
		led37.setOnMouseClicked(getEventHandler(led37, '2', '3'));
		led38.setOnMouseClicked(getEventHandler(led38, '2', '4'));
		led41.setOnMouseClicked(getEventHandler(led41, '2', '5'));
		led42.setOnMouseClicked(getEventHandler(led42, '2', '6'));
		led43.setOnMouseClicked(getEventHandler(led43, '2', '7'));
		led44.setOnMouseClicked(getEventHandler(led44, '2', '8'));
		led45.setOnMouseClicked(getEventHandler(led45, '2', '9'));
		led46.setOnMouseClicked(getEventHandler(led46, '3', '0'));
		led47.setOnMouseClicked(getEventHandler(led47, '3', '1'));
		led48.setOnMouseClicked(getEventHandler(led48, '3', '2'));
		led51.setOnMouseClicked(getEventHandler(led51, '3', '3'));
		led52.setOnMouseClicked(getEventHandler(led52, '3', '4'));
		led53.setOnMouseClicked(getEventHandler(led53, '3', '5'));
		led54.setOnMouseClicked(getEventHandler(led54, '3', '6'));
		led55.setOnMouseClicked(getEventHandler(led55, '3', '7'));
		led56.setOnMouseClicked(getEventHandler(led56, '3', '8'));
		led57.setOnMouseClicked(getEventHandler(led57, '3', '9'));
		led58.setOnMouseClicked(getEventHandler(led58, '4', '0'));
		led61.setOnMouseClicked(getEventHandler(led61, '4', '1'));
		led62.setOnMouseClicked(getEventHandler(led62, '4', '2'));
		led63.setOnMouseClicked(getEventHandler(led63, '4', '3'));
		led64.setOnMouseClicked(getEventHandler(led64, '4', '4'));
		led65.setOnMouseClicked(getEventHandler(led65, '4', '5'));
		led66.setOnMouseClicked(getEventHandler(led66, '4', '6'));
		led67.setOnMouseClicked(getEventHandler(led67, '4', '7'));
		led68.setOnMouseClicked(getEventHandler(led68, '4', '8'));
		led71.setOnMouseClicked(getEventHandler(led71, '4', '9'));
		led72.setOnMouseClicked(getEventHandler(led72, '5', '0'));
		led73.setOnMouseClicked(getEventHandler(led73, '5', '1'));
		led74.setOnMouseClicked(getEventHandler(led74, '5', '2'));
		led75.setOnMouseClicked(getEventHandler(led75, '5', '3'));
		led76.setOnMouseClicked(getEventHandler(led76, '5', '4'));
		led77.setOnMouseClicked(getEventHandler(led77, '5', '5'));
		led78.setOnMouseClicked(getEventHandler(led78, '5', '6'));
		led81.setOnMouseClicked(getEventHandler(led81, '5', '7'));
		led82.setOnMouseClicked(getEventHandler(led82, '5', '8'));
		led83.setOnMouseClicked(getEventHandler(led83, '5', '9'));
		led84.setOnMouseClicked(getEventHandler(led84, '6', '0'));
		led85.setOnMouseClicked(getEventHandler(led85, '6', '1'));
		led86.setOnMouseClicked(getEventHandler(led86, '6', '2'));
		led87.setOnMouseClicked(getEventHandler(led87, '6', '3'));
		led88.setOnMouseClicked(getEventHandler(led88, '6', '4'));

		botConectar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				op = listPortas.getSelectionModel().getSelectedItem()
						.toString();
				of = new OFacade(op);

				try {
					of.conectar();
					labEstado.setText("Conectado!");
				} catch (Exception erro) {
					labEstado.setText("Não conectado!");
				}

				listPortas.setDisable(true);
			}
		});

		botEnviar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String msg = textMsg.getText().toString();
				of.escrever(msg);
			}
		});

		botDesconectar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					of.desconectar();
					labEstado.setText("Desconectado!");
				} catch (Exception erro) {
					labEstado.setText("ERRO!");
				}

				listPortas.setDisable(false);
			}
		});

		botLimpar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				led11.setFill(Color.GRAY); led12.setFill(Color.GRAY); led13.setFill(Color.GRAY); led14.setFill(Color.GRAY);
				led15.setFill(Color.GRAY); led16.setFill(Color.GRAY); led17.setFill(Color.GRAY); led18.setFill(Color.GRAY);
				led21.setFill(Color.GRAY); led22.setFill(Color.GRAY); led23.setFill(Color.GRAY); led24.setFill(Color.GRAY);
				led25.setFill(Color.GRAY); led26.setFill(Color.GRAY); led27.setFill(Color.GRAY); led28.setFill(Color.GRAY);
				led31.setFill(Color.GRAY); led32.setFill(Color.GRAY); led33.setFill(Color.GRAY); led34.setFill(Color.GRAY);
				led35.setFill(Color.GRAY); led36.setFill(Color.GRAY); led37.setFill(Color.GRAY); led38.setFill(Color.GRAY);
				led41.setFill(Color.GRAY); led42.setFill(Color.GRAY); led43.setFill(Color.GRAY); led44.setFill(Color.GRAY);
				led45.setFill(Color.GRAY); led46.setFill(Color.GRAY); led47.setFill(Color.GRAY); led48.setFill(Color.GRAY);
				led51.setFill(Color.GRAY); led52.setFill(Color.GRAY); led53.setFill(Color.GRAY); led54.setFill(Color.GRAY);
				led55.setFill(Color.GRAY); led56.setFill(Color.GRAY); led57.setFill(Color.GRAY); led58.setFill(Color.GRAY);
				led61.setFill(Color.GRAY); led62.setFill(Color.GRAY); led63.setFill(Color.GRAY); led64.setFill(Color.GRAY);
				led65.setFill(Color.GRAY); led66.setFill(Color.GRAY); led67.setFill(Color.GRAY); led68.setFill(Color.GRAY);
				led71.setFill(Color.GRAY); led72.setFill(Color.GRAY); led73.setFill(Color.GRAY); led74.setFill(Color.GRAY);
				led75.setFill(Color.GRAY); led76.setFill(Color.GRAY); led77.setFill(Color.GRAY); led78.setFill(Color.GRAY);
				led81.setFill(Color.GRAY); led82.setFill(Color.GRAY); led83.setFill(Color.GRAY); led84.setFill(Color.GRAY);
				led85.setFill(Color.GRAY); led86.setFill(Color.GRAY); led87.setFill(Color.GRAY); led88.setFill(Color.GRAY);
				
				of.enviarCoord('L');
			}
		});

		labX.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (listPortas.isDisabled())
					of.desconectar();
				Main.stage.close();
			}
		});

		fechar.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (listPortas.isDisabled())
					of.desconectar();
				Main.stage.close();
			}
		});

		lab_.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				Main.stage.setIconified(true);
			}
		});

		minimizar.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				Main.stage.setIconified(true);
			}
		});

		reiniciar.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				if (listPortas.isDisabled()) {

					consoleMensagem("Para reiniciar, desconecte da porta " + op
							+ "!\n");
				} else {

					Main.stage.close();

					try {
						new Main().start(new Stage());
					} catch (Exception erro) {
						erro.printStackTrace();
					}
				}
			}
		});

		paneMovel.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				x = me.getScreenX() - Main.stage.getX();
				y = me.getScreenY() - Main.stage.getY();
			}
		});

		paneMovel.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				Main.stage.setX(me.getScreenX() - x);
				Main.stage.setY(me.getScreenY() - y);
			}
		});
	}

	public static void consoleMensagem(String estado) {

		areaConsole.setText(estado);
	}

	public static void listarPortas(String[] portas) {

		listPortas.setItems(FXCollections.<String> observableArrayList(portas));
	}

	public static String pegarTextoConsole() {

		return areaConsole.getText().toString();
	}
}
