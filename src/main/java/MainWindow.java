import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public static Window window;
    public static UserInput userInput;


    public static void main(String[] args) {
        MainWindow atemp = new MainWindow();
    }

    // constractor
    public MainWindow() {
        Font f = new Font("ARIEL ", Font.BOLD, 18);

        window = new Window();

        // button setting
        JButton enterButton = new JButton(" to enter whathap web ");
        enterButton.setBackground(new Color(0 ,209 ,142));
        enterButton.setBounds(150, 280, 200, 100);
        enterButton.setFont(f);
        window.add(enterButton);

        // button affect
        enterButton.addActionListener((e -> {
            window.setVisible(false);
            enterButton.setVisible(false);
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://web.whatsapp.com/");
            checkScan(driver);
        }));

    }

    // checkLoginSuccessful method
    public static void checkScan(ChromeDriver c) {
        Thread t = new Thread(() -> {
            boolean falg = true;
            while (falg) {
                if (c.getPageSource().contains("תיבת טקסט להזנת החיפוש")) {
                    falg = false;
                    JLabel success = new JLabel("Login successfully :)");
                    success.setBounds(0, 0, 300, 100);
                    Font fSuccess = new Font("ARIEL ", Font.BOLD, 15);
                    success.setForeground(Color.YELLOW);
                    success.setFont(fSuccess);
                    window.add(success);
                    userInput = new UserInput();

                }
            }

        });
        t.start();
    }
}
