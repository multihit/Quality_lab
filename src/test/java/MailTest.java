import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools.WaitTools;

public class MailTest {

    private final Logger logger = (Logger) LogManager.getLogger(MailTest.class);

    private final String authUrl = System.getProperty("auth.url");
    private final String login = System.getProperty("login");
    private final String password = System.getProperty("password");
    private WebDriver driver;
    private WaitTools waitTools;


    @BeforeEach
    public void init() {
        driver = new DriverFactory("--start-maximized").create();
        waitTools = new WaitTools(driver);
        driver.get(authUrl);
        logger.info("Start driver");
    }

    @AfterEach
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Stop driver");
    }

    @Test
    public void authViewCookie() throws InterruptedException {
        String signInBtnLocator = "//button[text()='Войти']";
//        String signInBtnLocator2 = "//*[@id=\"root\"]//button/span";//span[text()='Войти']
        String signInBtnLocator2 = "//button[@type='submit']/*[1]";//span[text()='Войти']
//        waitTools.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ph-whiteline > div")));
//        logger.info("Button sign in is visibility. Continue the test");
//        waitTools.waitForCondition(ExpectedConditions
//                .presenceOfElementLocated(By.xpath(signInBtnLocator)));
//        waitTools.waitForCondition(ExpectedConditions
//                .elementToBeClickable(By.xpath(signInBtnLocator)));

        WebElement signInBtn = driver.findElement(By.xpath(signInBtnLocator));

        logger.info("Check authorization popup status. Continue the test");

//        String authPopupSelector = "#root > div";
//
//        Assertions.assertTrue(waitTools
//               .waitForCondition(ExpectedConditions.not(ExpectedConditions
//                        .visibilityOfElementLocated(By.cssSelector(authPopupSelector)))), "Authorization popup status error");

        signInBtn.click();

//        WebElement authPopupEl = driver.findElement(By.cssSelector("#root > div"));
//        Assertions.assertTrue(waitTools
//                .waitForCondition(ExpectedConditions
//                        .visibilityOf(authPopupEl)), "Authorization popup status error");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement emailInputField = driver.findElement(By.xpath("//div[@class=\"login-row username\"]/*/*/*/*/*[2]"));
//        js.executeScript("arguments[0].setAttribute('type','displayed;');", emailInputField);
//       Thread.sleep(4000);
        driver.switchTo().frame(3);
//       waitTools.waitForCondition(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div")));
//        driver.findElement(By.xpath("//input[@name='username']")).click();
        WebElement emailInputField = driver.findElement(By.xpath("//input[@name='username']"));

        waitTools.waitForCondition(ExpectedConditions.stalenessOf(emailInputField));
        emailInputField.sendKeys(login);
//span[text()='Войти']

//        WebElement emailInputField = driver.findElement(By.xpath("//input[@name='username']"));
//
//        waitTools.waitForCondition(ExpectedConditions.stalenessOf(emailInputField));
//        emailInputField.sendKeys(login);
//        Thread.sleep(4000);
//       WebElement emailInputField = driver.findElement(By.xpath("//div[@class=\"login-row username\"]/*/*/*/*/*[2]"));
//        waitTools.waitForCondition(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("//div[@class=\"login-row username\"]/*/*/*/*/*[2]")));
//        Thread.sleep(8000);
//        emailInputField.sendKeys(login);

        WebElement signInBtn2 = driver.findElement(By.xpath(signInBtnLocator2));
        waitTools.waitForCondition(ExpectedConditions.stalenessOf(signInBtn2));
        signInBtn2.click();
     //   Thread.sleep(8000);
//        driver.switchTo().frame(3);


        WebElement passwordInputField = driver.findElement(By.cssSelector("input[type='password']"));
        //driver.findElement(By.xpath("//div[./input[@type='password']]")).click();
        waitTools.waitForCondition(ExpectedConditions.stalenessOf(passwordInputField));
        passwordInputField.sendKeys(password);
        WebElement button3 = driver.findElement(By.xpath("//button[@type='submit']/*[1]"));
                waitTools.waitForCondition(ExpectedConditions
               .visibilityOfElementLocated(By.xpath("//button[@type='submit']/*[1]")));
        button3.submit();
        // Thread.sleep(8000);


        //пишу письмо

//span[@class='compose-button__ico']
     //   Thread.sleep(8000);

   //            waitTools.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ph-whiteline > div")));
    //   logger.info("Button write in is visibility. Continue the test");
    //    driver.switchTo().frame(String.valueOf(By.xpath("//div[@class='sidebar__full sidebar__full_fixed fn-enter']")));
   //    driver.switchTo().frame(By.ByCssSelector(""));
     //   driver.switchTo().frame(3);
       String buttonLetter = "//span[text()='Написать письмо']";

            WebElement write = driver.findElement(By.xpath(buttonLetter));
       waitTools.waitForCondition(ExpectedConditions
               .presenceOfElementLocated(By.xpath(buttonLetter)));


        waitTools.waitForCondition(ExpectedConditions.elementToBeClickable(write));
        write.click();



   //     driver.switchTo().frame(buttonLetter);

       JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", buttonLetter);
      //  waitTools.waitForCondition(ExpectedConditions
       //        .visibilityOfElementLocated(By.xpath("//span[@class='compose-button__txt']")));

//

 //      driver.findElement(By.xpath("//div[./input[@type='password']]")).click();
//       waitTools.waitForCondition(ExpectedConditions.stalenessOf(passwordInputField));
//        passwordInputField.sendKeys(password);


//        logger.info("Enter authorization data. Continue the test");
//
//        driver.findElement(By.cssSelector("#__PORTAL__ button")).click();
//
//        logger.info("Check successful auth. Continue the test");
//        Assertions.assertTrue(waitTools
//                .waitForCondition(ExpectedConditions
//                        .presenceOfElementLocated(By.cssSelector("img[src*='blue-owl']"))));
//
//        String cookies = driver.manage().getCookies().toString();
//        logger.info("Cookies" + cookies);
    }
}
