package Tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Test Login With Valid Creds
 * Open Games.rs site
 * Click on Sing in button
 * Click on email field and enter email
 * Click on password field and enter password
 * Click on button for check-in
 */

public class LoginTest {
    @Test
    public void loginWithValidCreds () {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.games.rs/");
        WebElement prijaviseButton =  driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 col-md-5']//a[@class = 'login-btn']");
        prijaviseButton.click();

        //Selectovanje i popunjavanje email polja
        WebElement userNameField =  driver.findElementByXPath("//*[@id=\"login_email\"]");
        userNameField.click();
        userNameField.sendKeys("nemanjaserdar@gmail.com");

        //Selectovanje i popunjavanje password polja
        WebElement passwordField = driver.findElementByXPath("//*[@id=\"login_password\"]");
        passwordField.click();
        passwordField.sendKeys("Nemanjatest");

        //Prijavljivanje na sajt
        WebElement login = driver.findElementByXPath("//button[@class = 'btn btn-success btn-login confirm-loader']");
        login.click();

        driver.quit();
    }


}
