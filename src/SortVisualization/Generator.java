package SortVisualization;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;


public class Generator {

    public Generator() { }

    public static LineManager[] linesGenerator(Group root, int numberOfLines, int sceneEndY, double stepX) {

        Random random = new Random();
        LineManager[] listLines = new LineManager[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            LineManager line = new LineManager();
            line.setStartX(i * stepX);
            line.setStartY(sceneEndY);
            line.setEndX(i * stepX);
            line.setEndY(sceneEndY - random.nextInt(sceneEndY));
            line.setStroke(Color.BLUE);
            listLines[i] = line;
            root.getChildren().add(line);
        }

        return listLines;
    }
}

