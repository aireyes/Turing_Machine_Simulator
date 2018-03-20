package TuringMachine;

import javafx.scene.layout.Pane;

import java.io.IOException;

public class InputPane extends Pane {

    AppComponents appComponents;

    InputPane(float width, float height) throws IOException {

        setPrefSize(width, height);
        setTranslateY(250);

        this.appComponents = new AppComponents();

        getChildren().addAll(
                this.appComponents.cB_machines,
                this.appComponents.btn_loadMachine,
                this.appComponents.txt_enterString,
                this.appComponents.btn_enterString,
                this.appComponents.lbl_enterString,
                this.appComponents.btn_run,
                this.appComponents.btn_compile,
                this.appComponents.txtArea_program,
                this.appComponents.btn_reset
        );

        this.appComponents.displays.mD.diagramTR();
        this.appComponents.displays.mD.refresh();
    }
}
