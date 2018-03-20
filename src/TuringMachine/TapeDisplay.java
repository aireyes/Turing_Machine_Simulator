package TuringMachine;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TapeDisplay {
    int tapeLength;
    int scl;

    double width;
    double height;

    double move;
    int initdest;

    String inputString;

    Canvas canvasTape;
    GraphicsContext graphicsContext;

    TapeDisplay() {
        initializeComponents();

        this.canvasTape = new Canvas(300, 50);
        this.canvasTape.setTranslateY(-75);
        this.width = canvasTape.getWidth();
        this.height = canvasTape.getHeight();
        this.graphicsContext = canvasTape.getGraphicsContext2D();

        draw(this.inputString, 0);
    }

    void initializeComponents() {
        this.tapeLength = 100;
        this.scl = 0;

        this.move = 0;
        this.initdest = 0;

        this.inputString = "";
    }

    void draw(String inputString, double leftRight) {
        char[] iString = inputString.toCharArray();

        if (leftRight == 25) {
            initdest += -1;
        } else if (leftRight == -25) {
            initdest += 1;
        }

        move += leftRight;

        this.graphicsContext.setFill(Color.BLACK);
        this.graphicsContext.fillRect(0, 0, width, height);
        this.graphicsContext.setFill(Color.rgb(51, 51, 51));
        this.graphicsContext.setLineWidth(2);
        this.graphicsContext.setStroke(Color.WHITE);

        for (int i = 0; tapeLength > i; i++) {
            this.graphicsContext.setStroke(((initdest == i)? Color.CYAN : Color.WHITE));
            scl = i * 25;
            graphicsContext.strokeRect(width/2 - 12.5 + scl + move, height/2 - 12.5, 25, 25);
            if (iString.length > i) {
                graphicsContext.strokeText(Character.toString(iString[i]), width / 2 + scl - 3 + move, height / 2 + 3);
            }
        }

//        initdest = 0;
//        move = 0;
    }
}
