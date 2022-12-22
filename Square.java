import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Square extends JButton implements ActionListener {

    // Both scores have default values of infinity.
    double fScore = Double.POSITIVE_INFINITY;
    double gScore = Double.POSITIVE_INFINITY;

    // The row and column in the grid the square is in.
    private final int row;
    private final int column;

    // Property to store from where each node came from.
    Square parent;
    private Color color = Color.white;

    public void actionPerformed(ActionEvent event) {
        if (color == Color.white)
        {
            // Checks if there are start and end squares.
            if (MainPanel.startSquare == null) {
                color = Color.green;
                MainPanel.startSquare = this;
            } else if (MainPanel.endSquare == null) {
                color = Color.red;
                MainPanel.endSquare = this;
            }
        } else if (MainPanel.startSquare == this) {
            MainPanel.startSquare = null;
            color = Color.white;
        } else if (MainPanel.endSquare == this) {
            MainPanel.endSquare = null;
            color = Color.white;
        }
        setBackground(color);
        Main.jFrame.repaint();
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    public Square(int row, int column) {
        this.row = row;
        this.column = column;

        setBackground(color); // Sets to the default color: white.
        addActionListener(this); // Listens for click on the button.
        this.addKeyListener(new KeyInputHandler(this)); // Handles the Enter key press.
    }

    public double heuristic(Square endSquare) {
        int xDistance = Math.abs(column - endSquare.column);
        int yDistance = Math.abs(row - endSquare.row);
        return xDistance + yDistance;
    }

    public List<Square> getNeighbors() {
        List<Square> neighbors = new ArrayList<>();
        if (row > 0) { // UP
            neighbors.add(MainPanel.squares[row - 1][column]);
        }

        if (column > 0) { // LEFT
            neighbors.add(MainPanel.squares[row][column - 1]);
        }

        if (row < Main.ROWS - 1) { // DOWN
            neighbors.add(MainPanel.squares[row + 1][column]);
        }

        if (column < Main.ROWS - 1) { // RIGHT
            neighbors.add(MainPanel.squares[row][column + 1]);
        }
        return neighbors;
    }
}
