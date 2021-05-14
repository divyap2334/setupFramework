package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InValidLogin {
    @Test
    public void testErrorMessageOnInvalidLogin(){
        System.setProperty("webdriver.chrome.driver","/Users/divyapolaki/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");

        //Login
        WebElement login_icon=driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='link-to-login']/a")));
        login_icon.click();


        //Enter text in Email textbox
        driver.findElement(By.id("spree_user_email")).sendKeys("abc@abc.com");
        //Enter text in Password textBox
        driver.findElement(By.id("spree_user_password")).sendKeys("abcdef");


        //Click on Login button
        WebElement login_bttn=driver.findElement(By.name("commit"));
        login_bttn.click();

        //Error Message
        String expectedMessage="Invalid email or password.";
        String actualMessage=driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.close();

    }
}
