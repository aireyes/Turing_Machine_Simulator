package TuringMachine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class MachineDiagram {

    GraphicsContext gc;
    List<State> states;
    public int currentState;

    double width;
    double height;

    boolean accept;

    MachineDiagram (GraphicsContext gc) {
        this.gc = gc;
    }

    void initializeComponents() {
        this.currentState = 1;
        this.accept = false;
        setState(states);
        width = gc.getCanvas().getWidth();
        height = gc.getCanvas().getHeight();
    }

    void diagramTR() {
        initializeComponents();
    }

    void setState (List<State> st) {
        this.states = st;
    }

    void refresh () {
        gc.setFill(Color.rgb(51, 51, 51));
        gc.fillRect(0, 0, width, height);

        int i = 4;
        int j = (states.size() + 1) / 3;
        int k = (states.size() + 1) % 3;

        boolean d3 = ((states.size() + 1) % 3 == 0)? true : false;

        int numState = 0;

        int num = j + ((k > 0) ? 1 : 0) + 1;
        int number = 1;

        for (int n = 1; j >= n; n++) {
            for (int m = 1; 3 >= m; m++, number++, numState++) {
                double x = (width * m) / i;
                double y = (height * n) / num;

                gc.setFill(Color.WHITE);
                if (currentState == numState + 1 && !accept) {
                    gc.setFill(Color.CYAN);
                    gc.fillOval(x - 20, y - 20, 40, 40);
                    gc.setFill(Color.WHITE);
                } else {
                    gc.fillOval(x - 20, y - 20, 40, 40);
                }
                gc.setStroke(Color.rgb(51, 51, 51));
                gc.setLineWidth(1.5);
                if (numState < states.size())
                    gc.strokeText(Integer.toString(states.get(numState).number), x - 3, y + 5);

                if (d3) {
                    if (n + 1 > j && m + 1 > 3) {
                        if (accept) {
                            gc.setFill(Color.LIGHTGREEN);
                            gc.fillOval(x - 20, y - 20, 40, 40);
                            gc.setStroke(Color.rgb(51, 51, 51));
                            gc.setLineWidth(1.5);
                            gc.strokeText("H", x - 3, y + 5);

                        } else {
                            gc.fillOval(x - 20, y - 20, 40, 40);
                            gc.setStroke(Color.rgb(51, 51, 51));
                            gc.setLineWidth(1.5);
                            gc.strokeText("H", x - 3, y + 5);
                        }
                    }
                }
            }
        }

        if (k > 0) {
            int l = k;
            k++;
            j++;
            for (int m = 1; l >= m; m++) {
                double x = (width * m) / k;
                double y = (height * j) / num;

                if (currentState == numState) {
                    gc.setFill(Color.CYAN);
                    gc.fillOval(x - 20, y - 20, 40, 40);
                    gc.setFill(Color.WHITE);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillOval(x - 20, y - 20, 40, 40);
                }

                gc.setFill(Color.rgb(51, 51, 51));
                gc.setLineWidth(1.5);

                if(numState < states.size()) {
                    gc.strokeText(Integer.toString(states.get(numState).number), x - 3, y + 5);
                }

                if (!d3) {
                    if (m + 1 > l) {
                        if (accept) {
                            gc.setFill(Color.LIGHTGREEN);
                            gc.fillOval(x - 20, y - 20, 40, 40);
                            gc.setStroke(Color.rgb(51, 51, 51));
                            gc.setLineWidth(1.5);
                            gc.strokeText("H", x - 3, y + 5);

                        } else {
                            gc.setFill(Color.WHITE);
                            gc.fillOval(x - 20, y - 20, 40, 40);
                            gc.setStroke(Color.rgb(51, 51, 51));
                            gc.setLineWidth(1.5);
                            gc.strokeText("H", x - 3, y + 5);
                        }
                    }
                }
                numState++;
            }
        }
    }
}
