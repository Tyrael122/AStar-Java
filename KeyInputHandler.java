import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {
    final JButton jButton;

    public KeyInputHandler(JButton jButton) {
        this.jButton = jButton;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // If key pressed is the Enter, start the algorithm.
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Algorithm.start();
        } else if (e.getKeyCode() == KeyEvent.VK_C) {
            MainPanel.resetSquares();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
