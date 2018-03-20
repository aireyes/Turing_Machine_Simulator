package TuringMachine;

import java.util.ArrayList;
import java.util.List;

public class State {
    int number;
    List<Character> readSymbols = new ArrayList<>();
    List<Integer> nextStates = new ArrayList<>();
    List<Character> writeSymbols = new ArrayList<>();
    List<Integer> directions = new ArrayList<>();
}
