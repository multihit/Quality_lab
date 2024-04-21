package components.pupups;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PersonalArea extends AbsCommon {


    public PersonalArea(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popupShouldBeVisile() {

    }

    public void sendButtonWriteLetter() {

        String buttonLetter = "//span[@class='compose-button__wrapper']";

        WebElement write = driver.findElement(By.xpath(buttonLetter));
        waitTools.waitForCondition(ExpectedConditions
                .elementToBeClickable(By.xpath(buttonLetter)));
        write.click();
    }
}
