import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 600;


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
    public void  addImage(){
        try {
            this.setContentPane(new JLabel(new ImageIcon("popup-1.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.pack();
        this.setVisible(true);
    }



}
