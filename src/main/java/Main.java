import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {
    public static void main(String[] args) throws InterruptedException {

        Main m = new Main();
    }

    public Main() {
        this.setSize(500, 650);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        Font f = new Font("ARIEL ", Font.BOLD, 15);
        JButton b = new JButton(" Moudle");
        b.setBackground(Color.YELLOW);
        b.setBounds(150, 280, 200, 100);
        b.setFont(f);
        this.add(b);
        // button affect
        b.addActionListener((e -> {
            this.dispose();
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.aac.ac.il/");

            WebElement data = driver.findElement(By.xpath("//*[@id=\"menu-%d7%9b%d7%9c%d7%9c%d7%99\"]/li[8]/a"));
            data.click();


            WebElement user = driver.findElement(By.id("Ecom_User_ID"));
            user.sendKeys("alihahrn");
            WebElement passwordInput = driver.findElement(By.id("Ecom_Password"));
            passwordInput.sendKeys("3124ab67");
            WebElement getIn = driver.findElement(By.cssSelector("#wp-submit"));
            getIn.click();
            WebElement moudle = driver.findElement(By.cssSelector("body > div.pageContentWrapper > div > div.row > div.col-md-7.nopadding > div > div > div:nth-child(4) > div.col-sm-6.dot-right.dot-bottom > a"));
            moudle.click();
        }));

    }
}
