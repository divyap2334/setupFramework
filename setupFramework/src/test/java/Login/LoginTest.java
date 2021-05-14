package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.ProtocolHandshake;


public class LoginTest {

    @Test

    public void testLoginIntoSpree() {
        System.setProperty("webdriver.chrome.driver", "/Users/divyapolaki/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        login_icon.click();

        driver.close();

    }


}
