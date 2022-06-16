import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class UserInput {
    private int x = 200, y1 = 150, y2 = 250, width = 200, height = 50;

    public UserInput(ChromeDriver driver) {
        //success label
        JLabel success = new JLabel("Login successfully :)");
        success.setBounds(0, 0, 300, 100);
        Font fSuccess = new Font("ARIEL ", Font.BOLD, 15);
        success.setForeground(Color.YELLOW);
        success.setFont(fSuccess);
        MainWindow.window.add(success);
        // font setting
        Font myFont = new Font("Arial", Font.BOLD, 22);

        // button setting
        Button sendButton = new Button("Send");
        sendButton.setFont(myFont);
        sendButton.setBackground(new Color(13, 168, 138));
        sendButton.setBounds(90, 400, 300, 70);
        MainWindow.window.add(sendButton);

        // number textField
        JTextField phoneNumber = new JTextField("0502592666");
        phoneNumber.setBounds(this.x, this.y1, this.width, this.height);
        phoneNumber.setBackground(new Color(13, 168, 138));
        phoneNumber.setFont(myFont);

        // massage textField
        JTextField textMessage = new JTextField();
        textMessage.setBounds(this.x, this.y2, this.width, this.height);
        textMessage.setBackground(new Color(13, 168, 138));
        textMessage.setFont(myFont);
        MainWindow.window.add(textMessage);
        MainWindow.window.add(phoneNumber);
        MainWindow.window.setVisible(true);

        // number label
        JLabel numberLabel = new JLabel("Enter number");
        numberLabel.setBounds(50, this.y1, 170, this.height);
        numberLabel.setBackground(new Color(13, 168, 138));
        numberLabel.setOpaque(true);
        numberLabel.setFont(myFont);
        MainWindow.window.add(numberLabel);


        // text label
        JLabel textLabel = new JLabel("Enter text");
        textLabel.setBounds(50, this.y2, 170, this.height);
        textLabel.setBackground(new Color(13, 168, 138));
        textLabel.setOpaque(true);
        textLabel.setFont(myFont);
        MainWindow.window.add(textLabel);

        // error label setting
        Font erorFont = new Font("Arial", Font.BOLD, 17);
        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(90, 350, 300, 50);
        errorLabel.setForeground(Color.RED);
        errorLabel.setBackground(new Color(13, 168, 138));
        errorLabel.setOpaque(true);
        errorLabel.setFont(erorFont);
        errorLabel.setVisible(false);
        MainWindow.window.add(errorLabel);

        // button affect -->
        sendButton.addActionListener((e -> {
            try {
                if (!noMessage(textMessage) || noNumber(phoneNumber) || checkNumber(phoneNumber)) {
                    errorLabel.setVisible(true);
                    if (!noMessage(textMessage) && checkNumber(phoneNumber) && noNumber(phoneNumber)) {
                        errorLabel.setText("ENTER MESSAGE");
                    }
                    if (!checkNumber(phoneNumber) || !noNumber(phoneNumber)) {
                        errorLabel.setText("YOU MUST ENTER NUMBER(10 digits)");
                    }
                    if (noMessage(textMessage) && noNumber(phoneNumber) && checkNumber(phoneNumber)) {
                        MainWindow.window.setVisible(false);
                        success.setVisible(false);
                        errorLabel.setVisible(false);
                        textLabel.setVisible(false);
                        phoneNumber.setVisible(false);
                        textMessage.setVisible(false);
                        numberLabel.setVisible(false);
                        sendButton.setVisible(false);

                        driver.get("https://web.whatsapp.com/send?phone=972" + phoneNumber.getText());
                        Robot robot = new Robot();
                        robot.delay(12000);
                        WebElement input = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]"));
                        input.click();
                        input.sendKeys(textMessage.getText());
                        WebElement sendMessage = driver.findElement(By.cssSelector("#main > footer > div._2BU3P.tm2tP.copyable-area > div > span:nth-child(2) > div > div._2lMWa > div._3HQNh._1Ae7k"));
                        sendMessage.click();
                        MainWindow.window.setVisible(true);

                    }
                }
            } catch (Exception ex) {
                errorLabel.setVisible(true);
                errorLabel.setText("YOU MUST ENTER NUMBER(10 digits)");
            }

        }));


    }


    //  checkNumber  method
    public boolean checkNumber(JTextField t) {
        String str = "";
        int numOfCars = t.getText().length();
        for (int i = 0; i < 3; i++) {
            str += t.getText().charAt(i);
        }

        if (numOfCars != 10)
            return false;
        if (str.equals("050") || str.equals("051") || str.equals("052") || str.equals("053") || str.equals("054") || str.equals("055") || str.equals("058")) {
            return true;
        }
        return false;
    }

    // noNumber method
    public boolean noNumber(JTextField t) {
        if (t.getText().equals(""))
            return false;
        return true;
    }

    // check message method
    public boolean noMessage(JTextField t) {
        if (t.getText().equals(""))
            return false;
        return true;
    }
}




