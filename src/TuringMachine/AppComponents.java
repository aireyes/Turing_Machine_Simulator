package TuringMachine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.io.IOException;

public class AppComponents {

    public Displays displays;

    public final ObservableList<String> machines = FXCollections.observableArrayList(
            "Every 1, twice 0's",
            "Binary numbers divisible by 3",
            "One's complement"
    );

    Button btn_enterString;
    Label lbl_enterString;
    TextField txt_enterString;
    Button btn_loadMachine;
    ComboBox cB_machines;
    Button btn_run;
    Button btn_compile;
    Button btn_reset;
    TextArea txtArea_program;

    void initializeComponents() throws IOException {
        this.displays.initValues();
        this.displays.init();
        this.txtArea_program.setText(displays.builtInMachine.programming);
        this.txt_enterString.setText("");
    }

    AppComponents() throws IOException {
        this.displays = new Displays();

        this.btn_enterString = new Button("Enter String");
        this.lbl_enterString = new Label("String");
        this.txt_enterString = new TextField();
        this.btn_loadMachine = new Button("Load Machine");
        this.cB_machines = new ComboBox(machines);
        this.btn_run = new Button("Run");
        this.btn_compile = new Button("Compile");
        this.btn_reset = new Button("Reset");
        this.txtArea_program = new TextArea();

        initializeComponents();

        this.txtArea_program.setPrefSize(280, 210);
        this.txtArea_program.setTranslateX(10);
        this.txtArea_program.setTranslateY(90);

        this.cB_machines.setTranslateX(10);
        this.cB_machines.setTranslateY(10);
        this.cB_machines.setPrefWidth(180);
        this.cB_machines.getSelectionModel().selectFirst();

        this.txtArea_program.setText(this.displays.builtInMachine.programming);

        this.cB_machines.valueProperty().addListener((observable, oldValue, newValue) -> this.displays.sim.chosen = newValue.toString());

        this.btn_loadMachine.setTranslateX(200);
        this.btn_loadMachine.setTranslateY(10);
        this.btn_loadMachine.setOnAction(event -> {
            try {
                this.displays.init();
                this.txtArea_program.setText(displays.builtInMachine.programming);
                this.txt_enterString.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        this.lbl_enterString.setTranslateX(10);
        this.lbl_enterString.setTranslateY(50);

        this.txt_enterString.setTranslateX(50);
        this.txt_enterString.setTranslateY(50);

        this.btn_enterString.setTranslateX(210);
        this.btn_enterString.setTranslateY(50);
        this.btn_enterString.setOnAction(event -> this.displays.enterString(this.txt_enterString, this.displays.sim, this.displays.builtInMachine.programming));

        this.btn_run.setTranslateX(250);
        this.btn_run.setTranslateY(310);
        this.btn_run.setOnAction(event -> this.displays.run(this.displays.sim));

        this.btn_compile.setTranslateX(180);
        this.btn_compile.setTranslateY(310);
        this.btn_compile.setOnAction(event -> {
            try {
                this.displays.builtInMachine.programming = this.txtArea_program.getText();
                this.displays.init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        this.btn_reset.setTranslateX(10);
        this.btn_reset.setTranslateY(310);
        this.btn_reset.setOnAction(event -> {
            try {
                initializeComponents();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
