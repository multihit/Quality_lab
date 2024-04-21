package components;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPopups extends AbsCommon implements IPopup {

    public AuthPopups(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popupShouldBeVisile() {
    }


    private String login = System.getProperty("login");
    private String password = System.getProperty("password");

    private String signInBtnLocator = "//button[text()='Войти']";
    private String signInBtnLocator2 = "//span[text()='Войти']";


    @Override
    public void popupShouldBeVisible() {
    }

    @Override
    public void popupShouldNotBeVisible() {
    }

    public void enterDataButton() {
        WebElement signInBtn = driver.findElement(By.xpath(signInBtnLocator));
        signInBtn.click();
        driver.switchTo().frame(3);

    }

    public void enterDataEmail() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
    }


    public void loginButton() {
        WebElement signInBtn2 = driver.findElement(By.xpath(signInBtnLocator2));
        waitTools.waitForCondition(ExpectedConditions.elementToBeClickable(signInBtn2));
        signInBtn2.click();
    }

    public void enterDataPassword() {
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']/*[1]")).submit();

    }

}
