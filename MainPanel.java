import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    static final Square[][] squares = new Square[Main.ROWS][Main.ROWS]; // Grid of squares
    static Square startSquare, endSquare;
    public MainPanel() {
        this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        this.setLayout(new GridLayout(Main.ROWS, Main.ROWS));

        // Add all squares to the grid in their rows and columns.
        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.ROWS; col++) {
                Square square = new Square(row, col);
                squares[row][col] = square;
                this.add(square); // Adds the square to the panel.
            }
        }
    }
    public static void resetSquares() {
        // Sets the color of all square to white.
        for (Square[] row: squares) {
            for (Square square: row) {
                square.setColor(Color.white);
                square.gScore = Double.POSITIVE_INFINITY;
                square.fScore = Double.POSITIVE_INFINITY;
            }
        }
        startSquare = null;
        endSquare = null;

        Main.jFrame.repaint();
    }
}
