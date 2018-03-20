package TuringMachine;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Displays {

    public Simulator sim;
    public BuiltInMachine builtInMachine;

    Canvas canvas;
    GraphicsContext gc;
    MachineDiagram mD;
    TapeDisplay tapeDisplay;

    int num;
    int inputIndex;
    boolean accept;
    Alert alert;

    Displays() throws IOException {
        this.canvas = new Canvas(300, 200);
        this.canvas.setTranslateY(-200);
        this.gc = canvas.getGraphicsContext2D();
        this.mD = new MachineDiagram(gc);
        this.tapeDisplay = new TapeDisplay();

        this.sim = new Simulator();
        this.builtInMachine = new BuiltInMachine();

        initValues();
    }

    void initValues() {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.num = 0;
        this.inputIndex = -1;
        this.accept = true;
        this.builtInMachine.initializeComponents();
        this.sim.initValues();

    }

    void run(Simulator sim) {
        //            Process:
//            for ( ; ; ) {
        char[] input = this.tapeDisplay.inputString.toCharArray();

        for (; input.length > this.num;) {
            if (this.sim.initState.readSymbols.contains(input[this.num])) {
                this.inputIndex = this.sim.initState.readSymbols.indexOf(input[num]);

                input[num] = this.sim.initState.writeSymbols.get(inputIndex);

                System.out.println("Current State: " + this.sim.initState.number);
                System.out.println("Read Symbol: " + this.sim.initState.readSymbols.get(this.inputIndex));
                System.out.println("Write Symbol: " + this.sim.initState.writeSymbols.get(this.inputIndex));
                System.out.println("Next State: " + this.sim.initState.nextStates.get(this.inputIndex));
                System.out.println("Dir Symbol: " + this.sim.initState.directions.get(this.inputIndex));

                if (this.sim.initState.directions.get(this.inputIndex) == 1) {
                    this.num++;
                } else if (this.sim.initState.directions.get(this.inputIndex) == -1) {
                    this.num--;
                }
                this.accept = true;
                break;
            } else {
                this.alert.setContentText("Rejected");
                this.alert.show();
                break;
//                        break Process;
            }

        }

        String inputString = new String(input);
        System.out.println(inputString);
        this.tapeDisplay.inputString = inputString;
        System.out.println(((sim.initState.directions.get(inputIndex) == 1)? "Right" : "Left"));
        this.tapeDisplay.draw(inputString, ((this.sim.initState.directions.get(inputIndex) == 1)? -25 : 25 ));
        System.out.println(inputIndex);

        for (State st : this.sim.machineRules) {
            if (st.number == this.sim.initState.nextStates.get(this.inputIndex)) {
                System.out.println(inputIndex);
                System.out.println(st.number);
                sim.initState = st;
                break;

            } else if (this.sim.initState.nextStates.get(inputIndex) == 17) {
                System.out.println("The string is accepted!");
                this.alert.setContentText("Accepted");
                this.alert.show();
                this.mD.accept = true;
                this.mD.refresh();
//                        break Process;
            }
        }

        this.mD.currentState = this.sim.initState.number;
        this.mD.refresh();
    }

    void enterString(TextField txt_enterString, Simulator sim, String program) {
        this.num = 0;
        this.inputIndex = -1;
        this.accept = true;

        sim.load_machine(program);
        this.tapeDisplay.initdest = 0;
        this.tapeDisplay.scl = 0;
        this.tapeDisplay.move = 0;
        this.tapeDisplay.tapeLength = 50;
        this.tapeDisplay.inputString = txt_enterString.getCharacters().toString() + "~";
        this.tapeDisplay.draw(this.tapeDisplay.inputString, 0);

        this.mD.initializeComponents();
        this.mD.refresh();
    }

    void init() throws IOException {
        this.mD.accept = false;
        this.builtInMachine.pick(this.sim.chosen);
        this.sim.load_machine(this.builtInMachine.programming);
        this.mD.setState(this.sim.machineRules);
        this.mD.refresh();
    }
}
