import javax.swing.*;
public class Main {
    static final JFrame jFrame = new JFrame();
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int ROWS = 50;
    public static void main(String[] args) {

        jFrame.add(new MainPanel());

        // Causes the Window to be sized to fit the preferred size and layouts of its subcomponents.
        jFrame.pack();

        // Centers the Window.
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
