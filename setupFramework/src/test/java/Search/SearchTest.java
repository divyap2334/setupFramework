package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
    @Test
    public void SearchAndAddToCart() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","/Users/divyapolaki/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");
        WebDriverWait wait= new WebDriverWait(driver,30);

        //Search for an Item
        driver.findElement(By.xpath("//*[@id='keywords']")).sendKeys("Shirt");

        //Click on Search Button
        WebElement searchButton=driver.findElement(By.xpath("//*[@id='search-bar']/form/input[2]"));
        searchButton.click();

        //Select an Item from the Content of the resultant Page
        WebElement selectItem= driver.findElement(By.xpath("//*[@id='product_5']/div/div[1]/a/span"));
        String itemName=selectItem.getText();
        System.out.println(itemName);
        selectItem.click();

        //Add to cart
        WebElement addToCart=driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        Thread.sleep(3000);
        //Check for the item in cart
        WebElement itemInCart=driver.findElement(By.linkText("Ruby on Rails Ringer T-Shirt"));
        String cartItemName=itemInCart.getText();
        System.out.println(cartItemName);
        Assert.assertEquals(itemName,cartItemName);

        driver.close();

    }
}
