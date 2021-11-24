import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class NetflixLogin {
    WebDriver driver;
    @Before
    public void Setup(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void Login() throws InterruptedException {
        driver.get("https://www.netflix.com/bd/");
        driver.findElement(By.xpath("//a[@class='authLinks redButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("id_userLoginId")).sendKeys("3darioala@gmail.com");
        driver.findElement(By.id("id_password")).sendKeys("teen3darioala");
        driver.findElement(By.xpath("//button[@class='btn login-button btn-submit btn-small']")).click();
    }
    @After
    public void FinishTest() {
        driver.close();
    }
}
