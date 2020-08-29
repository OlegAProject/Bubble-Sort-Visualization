package SortVisualization;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;

import java.util.ArrayList;
import java.util.List;


public class Sort {

    List<Transition> transitionsAll;

    public Sort() {
        this.transitionsAll = new ArrayList<>();
    }


    public ParallelTransition linesSwap(LineManager[] linesArray, int leftPos, int rightPos) {

        double distance = (double) LineManager.SCENE_X / LineManager.LINES_NUM;
        int delta = rightPos - leftPos;

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(linesArray[leftPos].lineShift(distance * delta), linesArray[rightPos].lineShift(-distance * delta));

        LineManager temp;
        temp = linesArray[leftPos];
        linesArray[leftPos] = linesArray[rightPos];
        linesArray[rightPos] = temp;

        return pt;
    }

    public List<Transition> bubbleSort(LineManager[] linesArray) {

        List<Transition> transitions = new ArrayList<>();

        for (int i = 0; i < linesArray.length - 1; i++) {
            for (int j = 0; j < linesArray.length - i - 1; j++) {
                if (linesArray[j].getEndY() > linesArray[j + 1].getEndY()) {
                    transitions.add(linesSwap(linesArray, j, j + 1));

                }
            }
        }

        this.transitionsAll.addAll(transitions);

        return transitions;
    }

    public static int[] fullBubbleSort (int[] array) {
        int temp;

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }
}

