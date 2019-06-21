package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game {

    private Stack<Integer> tower1 = new Stack<>();
    private Stack<Integer> tower2 = new Stack<>();
    private Stack<Integer> tower3 = new Stack<>();
    private List<Stack> towers = new ArrayList<>();

    int numberOfDiscs;

    public Game(int numberOfDiscs) {

        this.numberOfDiscs = numberOfDiscs;

        for (int i = numberOfDiscs; i > 0; i--) {

            tower1.push(i);
        }

        towers.add(tower1);
        towers.add(tower2);
        towers.add(tower3);
    }

    public void move(int towerFrom, int towerTo) {

        Stack<Integer> towerFromStack = towers.get(towerFrom);
        Stack<Integer> towerToStack = towers.get(towerTo);

        if (!towerFromStack.empty() && towerToStack.empty()) {
            towerToStack.push(towerFromStack.pop());
        } else if (towerFromStack.empty() && !towerToStack.empty()) {
            towerFromStack.push(towerToStack.pop());
        } else if (towerFromStack.peek() < towerToStack.peek()) {
            towerToStack.push(towerFromStack.pop());
        } else {
            towerFromStack.push(towerToStack.pop());
        }

    }

    public void play() {
        if (numberOfDiscs % 2 == 0) {
            while (tower3.size() != numberOfDiscs) {
                move(0, 1);
                if (checkGameComplete()) break;
                move(0, 2);
                if (checkGameComplete()) break;
                move(1, 2);
                if (checkGameComplete()) break;
            }
        } else {
            while (tower3.size() != numberOfDiscs) {
                move(0, 2);
                if (checkGameComplete()) break;
                move(0, 1);
                if (checkGameComplete()) break;
                move(1, 2);
                if (checkGameComplete()) break;
            }
        }
    }
    private boolean checkGameComplete() {
        if (tower3.size() == numberOfDiscs) {
            result();
            return true;
        }
        return false;
    }

    public Stack result() {
        return tower3;
    }
}

