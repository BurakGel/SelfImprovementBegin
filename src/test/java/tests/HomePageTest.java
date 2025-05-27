package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void searchLaptopOnTrendyol() {
        // Google anasayfası baseUrl olarak config'de tanımlı olmalı (örnek: https://www.google.com)

        // Arama kutusunu bul (Google'ın arama kutusu name="q" ile bulunur)
        driver.findElement(By.id("firstname")).sendKeys("Burak");
        driver.findElement(By.id("surname")).sendKeys("Gel");
        new Select(driver.findElement(By.id("gender"))).selectByValue("male");
        driver.findElement(By.id("red")).click();
        driver.findElement(By.cssSelector("#contactus > div:nth-child(5) > div > label > textarea")).sendKeys("easy peasy lemon squezy");
        new Select(driver.findElement(By.id("continent"))).selectByValue("asia");
        driver.findElement(By.id("submitbutton")).click();
        System.out.println("Test başarıyla tamamlandı");


    }
}
