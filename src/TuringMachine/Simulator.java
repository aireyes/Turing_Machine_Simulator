package TuringMachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    public List<State> machineRules;
    State initState;

    String chosen = "Every 1, twice 0's";

    int lastChar;
    int numStates;
    boolean first;

    void initValues() {
        this.chosen = "Every 1, twice 0's";
        this.numStates = 0;
        this.first = true;
    }

    public Simulator() throws IOException {
        initValues();
    }

    public void initiateRules() {
        State mr;
        List<Character> readSymbol = new ArrayList<>();
        List<Integer> nextState = new ArrayList<>();
        List<Character> nextSymbol = new ArrayList<>();
        List<Integer> direction = new ArrayList<>();
        int state = 1;
        int prevState = 1;

        for (int i = 1; chosen.length() > i; i++)
        {
            switch (i % lastChar)
            {
                case 1:
                    state = Character.getNumericValue(chosen.charAt(i));
                    if (state != prevState)
                    {
                        mr = new State();
                        mr.number = prevState;
                        mr.readSymbols = readSymbol;
                        mr.nextStates = nextState;
                        mr.writeSymbols = nextSymbol;
                        mr.directions = direction;
                        machineRules.add(mr);
                        numStates++;
                        readSymbol = new ArrayList<>();
                        nextState = new ArrayList<>();
                        nextSymbol = new ArrayList<>();
                        direction = new ArrayList<>();
                        prevState = state;
                    }
                    break;
                case 3:
                    readSymbol.add(chosen.charAt(i));
                    break;
                case 5:
                    nextState.add(Character.getNumericValue(chosen.charAt(i)));
                    break;
                case 7:
                    nextSymbol.add(chosen.charAt(i));
                    break;
                case 9:
                    int dir;
                    if (chosen.charAt(i) == '<')
                        dir = -1;
                    else
                        dir = 1;
                    direction.add(dir);
                    break;
            }
        }
    }

    public void load_machine(String machine) {
        if (first) {
            machineRules = new ArrayList<State>();
        } else {
            machineRules.clear();
        }
        lastChar = machine.indexOf("\n");
        chosen = machine;
        initiateRules();
        initState = machineRules.get(0);
    }
}
