package SortVisualization;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.util.Duration;


public class TransitionLines {

    public TransitionLines() {
    }

    public Line[] transitionLine(double sceneEndY, Line line, Line line2) {

        double startPoint = line.getStartX();
        double endPoint = line2.getStartX();
        double lineHigh1 = line.getEndY();
        double lineHigh2 = line2.getEndY();

        double lineCenter1 = (double) (lineHigh1 + (sceneEndY - lineHigh1)/2);
        double lineCenter2 = (double) (lineHigh2 + (sceneEndY - lineHigh2)/2);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(startPoint, lineCenter1, endPoint, lineCenter1);

        PathTransition transition = new PathTransition();
        transition.setNode(line);
        transition.setDuration(Duration.seconds(4));
        transition.setAutoReverse(true);
        transition.setPath(polyline);
        transition.play();

        Polyline polyline2 = new Polyline();
        polyline2.getPoints().addAll(endPoint, lineCenter2, startPoint, lineCenter2);

        PathTransition transition2 = new PathTransition();
        transition2.setNode(line2);
        transition2.setDuration(Duration.seconds(4));
        transition2.setAutoReverse(true);
        transition2.setPath(polyline2);
        transition2.play();

        Line[] lines = new Line[2];
        line.setStartX(endPoint);
        line.setEndX(endPoint);
        line2.setStartX(startPoint);
        line2.setEndX(startPoint);
        lines[0] = line;
        lines[1] = line2;

        return lines;

    }

    public static Line[] swapLines(Line line1, Line line2) {
        Line[] lines = new Line[2];

        lines[0] = line2;
        lines[1] = line1;

        return lines;
    }
}


