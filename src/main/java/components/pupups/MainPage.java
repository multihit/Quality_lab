package components.pupups;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public class MainPage extends AbsBasePage {

    public MainPage(WebDriver driver) {
        super(driver, "/");
    }

    @Override
    public void popupShouldBeVisile() {

    }
}
