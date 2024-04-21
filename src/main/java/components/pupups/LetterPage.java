package components.pupups;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LetterPage extends AbsCommon {


    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public void writeLetter() {
        String StringSend = "//label[@class=\"container--zU301\"]";
        driver.findElement(By.xpath(StringSend)).sendKeys("alex291990@gmail.com");
        ;
    }


    public void writeTextMail() {

        String textletter = "//div[@role='textbox']";
        driver.findElement(By.xpath(textletter)).sendKeys("Привет, проверка!");
    }

    public void sendMail() throws InterruptedException {
        String sendBut = "//span[text()='Отправить']";
        driver.findElement(By.xpath(sendBut)).click();
        Thread.sleep(8000);

    }

    @Override
    public void popupShouldBeVisile() {

    }
}
