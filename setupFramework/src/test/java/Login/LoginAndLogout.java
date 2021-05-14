package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginAndLogout {
    @Test
    public void loginAndLogoutImmediately() {
        System.setProperty("webdriver.chrome.driver", "/Users/divyapolaki/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");


        //Click on Login button
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Link-to-login")));
        login_icon.click();

        //Enter text in Email textbox
        driver.findElement(By.id("spree_user_email")).sendKeys("abc@abc.com");

        //Enter text in Password textBox
        driver.findElement(By.id("spree_user_password")).sendKeys("divyap2334");

        //Click on Login button
        WebElement login_bttn=driver.findElement(By.name("commit"));
        login_bttn.click();

        //click on Logout Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        WebElement logout_icon=driver.findElement(By.linkText("Logout"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        logout_icon.click();

        driver.close();
    }

}
