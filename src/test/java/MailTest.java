import components.AuthPopups;
import components.pupups.LetterPage;
import components.pupups.MainPage;
import components.pupups.PersonalArea;
import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MailTest {

    private final Logger logger = (Logger) LogManager.getLogger(MailTest.class);
    private WebDriver driver;


    @BeforeEach
    public void init() {
        this.driver = new DriverFactory().create();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    public void qualityLab() throws InterruptedException {
        new MainPage(driver).open("/");

        AuthPopups authPopups = new AuthPopups(driver);
        LetterPage letterPage = new LetterPage(driver);
        PersonalArea personalArea = new PersonalArea(driver);

        logger.info("Check status auth popup");
        authPopups.enterDataButton();
        authPopups.enterDataEmail();
        authPopups.loginButton();
        authPopups.enterDataPassword();

        personalArea.sendButtonWriteLetter();
        logger.info("Login in LK successful.");

        letterPage.writeLetter();
        letterPage.writeTextMail();
        letterPage.sendMail();
        logger.info("The letter was sent");
    }
}
