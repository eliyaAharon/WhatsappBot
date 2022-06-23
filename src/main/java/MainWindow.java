import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MainWindow {

    public static Window window;
    private static UserInput userInput;
    private static ChromeDriver driver;
    private static FirstAudio firstAudio;


    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MainWindow mainWindow = new MainWindow();

    }

    // constractor
    public MainWindow() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        firstAudio = new FirstAudio();
        Font f = new Font("ARIEL ", Font.BOLD, 18);

        window = new Window();

        // button setting
        JButton enterButton = new JButton(" to enter whatApp web ");
        enterButton.setBackground(new Color(0, 209, 142));
        enterButton.setBounds(150, 280, 200, 100);
        enterButton.setFont(f);
        window.add(enterButton);

        // button affect
        enterButton.addActionListener((e -> {
            firstAudio.stopAudio();
            window.setVisible(false);
            enterButton.setVisible(false);
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://web.whatsapp.com/");
            checkScan(driver);
        }));

    }

    // checkLoginSuccessful method
    public static void checkScan(ChromeDriver c) {
        Thread t = new Thread(() -> {
            boolean falg = true;
            while (true) {
                List<WebElement> webElements = driver.findElements(By.cssSelector("#side > div.uwk68 > div > div > div._16C8p > div > div._13NKt.copyable-text.selectable-text"));
                if (webElements.size() != 0) {
                    try {
                        userInput = new UserInput(driver);
                        break;
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        t.start();
    }
}
