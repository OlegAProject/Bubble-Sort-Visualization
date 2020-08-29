package SortVisualization;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class LineManager extends Line {

    public static final int SCENE_X = 1000;
    public static final int SCENE_Y = 400;
    public static final int LINES_NUM = 100;
    public static final double ANI_TIMER = 2;


    public LineManager() { }

    public TranslateTransition lineShift(double shift) {

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(this);
        translateTransition.setDuration(Duration.millis(ANI_TIMER));
        translateTransition.setByX(shift);

        return translateTransition;
    }
}
