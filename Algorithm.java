import java.awt.*;
import java.util.*;

public class Algorithm {
    public static void start() {
        // There has to be a start and an end square.
        if (MainPanel.startSquare != null && MainPanel.endSquare != null) {
            // The open set is a priority queue that uses a custom square comparator.
            PriorityQueue<Square> openSet = new PriorityQueue<>(10, new SquareComparator());

            // The initial gScore is 0, since nothing has been walked.
            MainPanel.startSquare.gScore = 0;

            // The fScore of the start node is equal to the heuristics.
            MainPanel.startSquare.fScore = MainPanel.startSquare.heuristic(MainPanel.endSquare);

            openSet.add(MainPanel.startSquare);

            while (!openSet.isEmpty()) {
                Square currentSquare = openSet.poll();
                currentSquare.setColor(Color.pink);
                Main.jFrame.repaint();

                if (currentSquare == MainPanel.endSquare) {
                    reconstructPath(currentSquare);
                    return;
                } else {
                    for (Square neighborSquare: currentSquare.getNeighbors()) {
                        // Is the path to the neighbor better than any previously found paths.
                        boolean isPathBetter = (currentSquare.gScore + 1) < neighborSquare.gScore;
                        if (isPathBetter) {
                            neighborSquare.parent = currentSquare;

                            // Updates the gScore to be whatever takes to get to the current + 1.
                            neighborSquare.gScore = currentSquare.gScore + 1;

                            // The heuristic algorithm just takes the euclidean distance between two points. Can be improved to use Manhattan distance.
                            neighborSquare.fScore = neighborSquare.gScore + neighborSquare.heuristic(MainPanel.endSquare);
                            if (!openSet.contains(neighborSquare)) { // Adds to the open set if not already there.
                                openSet.add(neighborSquare);
                            }
                        }
                    }
                }
            }
        }
    }
    public static void reconstructPath(Square current) {
        for (current = current.parent; current.parent != null; current = current.parent) {
            current.setColor(Color.cyan);
        }
        MainPanel.startSquare.setColor(Color.green);
        MainPanel.endSquare.setColor(Color.red);

        Main.jFrame.repaint();
    }
}
