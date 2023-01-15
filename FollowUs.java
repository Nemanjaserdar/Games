package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.ArrayList;

/**
 * Test Follow Us On
 * Open Games.rs site
 * Accept cookies on page
 * Finding facebook page and check is it show us facebook page
 * Closing facebook page and switch to page games site
 * Finding instagram page and check is it show us instagram page
 * Closing instagram page and switch to page games site
 * Finding youtube page and check is it show us youtube page

 * Expected results
 * Checking facebook,instagram and youtube pages for site games
 */

public class FollowUs {

    @Test
    public void FollowUsOn() throws InterruptedException {
        final String MODAL_URL = "https://www.games.rs/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MODAL_URL);
        WebDriverWait wait = new WebDriverWait(driver,2);

        //Gasenje cookie-a na games stranici
        WebElement cookie = driver.findElementByXPath("//*[@id=\"modal-cookie-info\"]/div/div/div[1]/div/div[3]/button/span");
        cookie.click();

        //Ucitavanje facebook strane i stampanje url-a za istu radi provere
        WebElement Facebook = driver.findElementByXPath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/a/img");
        Facebook.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrlFacebook = driver.getCurrentUrl();
        System.out.println(currentUrlFacebook);
        System.out.println("Uspesno ste usli na Facebook stranu");
        driver.close();
        driver.switchTo().window(tabs.get(0));
        //Prebacivanje na Games strane
        WebElement Games = driver.findElementByXPath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/div/div[1]/div[1]/div/span");
        Games.click();
        //Ucitavanje instagram strane i stampanje url-a za istu radi provere
        WebElement Instagram = driver.findElementByXPath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/a/img");
        Instagram.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String currentUrlinstagram = driver.getCurrentUrl();
        System.out.println(currentUrlinstagram);
        System.out.println("Uspesno ste usli na Instagram stranu");
        driver.close();
        driver.switchTo().window(tabs.get(0));
        //Prebacivanje na Games strane
        Games.click();
        //Ucitavanje youtube strane i stampanje url-a za istu radi provere
        WebElement Youtube = driver.findElementByXPath("/html/body/div[1]/div[1]/div[2]/div/div/div[3]/div/div[2]/div[3]/div/a/img");
        Youtube.click();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(1));
        String currentUrlyoutube = driver.getCurrentUrl();
        System.out.println(currentUrlyoutube);
        System.out.println("Uspesno ste usli na Youtube stranu");

        driver.quit();
    }
}
