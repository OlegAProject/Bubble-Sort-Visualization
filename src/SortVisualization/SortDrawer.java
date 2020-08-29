package SortVisualization;

import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;


public class SortDrawer {

    public SortDrawer() { }

    public void Drawer(Group root) {

        double step = (double) LineManager.SCENE_X / LineManager.LINES_NUM;

        LineManager[] lines = new LineManager[(int) LineManager.LINES_NUM];
        List<Transition> transitionList = new ArrayList<>();
        lines = Generator.linesGenerator(root, LineManager.LINES_NUM, LineManager.SCENE_Y, step);

        Sort sort = new Sort();
        transitionList = sort.bubbleSort(lines);
        SequentialTransition st = new SequentialTransition();
        st.getChildren().addAll(transitionList);
        st.play();
    }
}

