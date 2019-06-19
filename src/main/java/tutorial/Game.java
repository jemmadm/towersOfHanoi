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

        if (!towers.get(towerFrom).empty() && (towers.get(towerFrom).peek() < towers.get(towerTo).peek())) {
            towers.get(towerTo).push(towers.get(towerFrom).pop());
        } else {
            towers.get(towerFrom).push(towers.get(towerTo).pop());
        }

    }

    public void play() {


        if (numberOfDiscs % 2 == 0) {

//            try {
            while (tower3.size() != numberOfDiscs) {
                if (tower2.empty()) {
                    move(0, 1);
                } else {
                    move(1, 0);
                }
                if (tower3.empty()) {
                    move(0, 2);
                } else {
                    move(2, 0);
                }
                if (tower3.peek() > tower2.peek()) {
                    move(1, 2);
                } else {
                    move(2, 1);
                }
                if (tower3.size() == numberOfDiscs) {
                    result();
                    break;
                }
            }
        } else {
            while (tower3.size() != numberOfDiscs) {
                move(0, 2);

                if (tower3.size() == numberOfDiscs) {
                    result();
                    break;
                }
                if (tower2.size() < tower1.size()) {
                    move(0, 1);
                } else {
                    move(1, 0);
                }
                if (tower2.size() < tower3.size()) {
                    move(2, 1);
                } else {
                    move(1, 2);
                }
            }
        }
    }


    public Stack result() {
        return tower3;
    }

}

