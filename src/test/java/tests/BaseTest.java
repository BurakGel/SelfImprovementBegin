package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // config.properties dosyasından ayarları al
        String browser = ConfigReader.getProperty("browser"); // şu anda "chrome"
        String baseUrl = ConfigReader.getProperty("baseUrl");
        int waitTime = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        // Tarayıcı seçimi
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Desteklenmeyen tarayıcı: " + browser);
        }

        driver.manage().window().maximize(); // ekranı büyüt
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        driver.get(baseUrl); // URL'e git
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // testi bitirince tarayıcıyı kapat
        }
    }
}
