package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void firstSeleniumAutomation() {

        driver.findElement(By.id("firstname")).sendKeys("Burak");
        driver.findElement(By.id("surname")).sendKeys("Gel");
        new Select(driver.findElement(By.id("gender"))).selectByValue("male");
        driver.findElement(By.id("red")).click();
        driver.findElement(By.cssSelector("#contactus > div:nth-child(5) > div > label > textarea")).sendKeys("test text");
        new Select(driver.findElement(By.id("continent"))).selectByValue("asia");
        driver.findElement(By.id("submitbutton")).click();
        System.out.println("Test başarıyla tamamlandı");


    }
}
