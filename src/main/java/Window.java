import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 600;

    public Window() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("My whatsapp web -->");

    }

    public void customRemove() {
        this.getContentPane().removeAll();
        this.repaint();
    }
}
