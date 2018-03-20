package TuringMachine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TuringMachine extends Application {

    public TuringMachine() throws IOException {
    }

    public static void main(String[] args) { launch(args); }

    InputPane inputPane = new InputPane(300, 400);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Turing Machine Simulator");

        StackPane root = new StackPane();
        root.setPrefSize(300, 600);

        root.getChildren().addAll(
                inputPane.appComponents.displays.canvas,
                inputPane,
                inputPane.appComponents.displays.tapeDisplay.canvasTape
        );

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
