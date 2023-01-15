package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Test for Buy one item and check Cart
 * Open Games.rs site
 * Accept cookies on page
 * Hover on burger meni Sve Kategorije
 * Hover on Gift
 * Select Majce page
 * Find 1st item and opening to check item
 * Buying item
 * Checking cart to see is fill with item we wanna buy

 * Expected results
 * One item select and put in cart for shoping
 */

public class BuyItem {

    @Test
    public void BuyItemAndCheckCart() throws InterruptedException {
        final String MODAL_URL = "https://www.games.rs/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MODAL_URL);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        Actions act = new Actions(driver);

        //Gasenje cookie-a na games stranici
        WebElement cookie = driver.findElementByXPath("//*[@id=\"modal-cookie-info\"]/div/div/div[1]/div/div[3]/button/span");
        cookie.click();

        //Obelezavanje padajuceg menija SveKategorije
        WebElement SveKategorije = driver.findElementByXPath("/html/body/header/div/div[4]/div/nav/ul/li[1]/a");
        act.moveToElement(SveKategorije).perform();

        //Obelezavanje padajuceg menija Gift
        WebElement Gift = driver.findElementByXPath("/html/body/header/div/div[4]/div/nav/ul/li[1]/div/div/ul/li[7]");
        act.moveToElement(Gift).perform();

        //Selektovanje stranice Majce
        WebElement Majce = driver.findElementByXPath("/html/body/header/div/div[4]/div/nav/ul/li[1]/div/div/ul/li[7]/div/div/div/div[1]/div/div[1]/ul/li[4]/a");
        Majce.click();

        //Pronalazenje Majce koju zelimo da kupimo i otvaranje proizvoda
        WebElement M_StarWars = driver.findElementByXPath("/html/body/div[1]/main/div[3]/div/div[2]/div[2]/div[3]/div/div[7]/div/div/div[3]/div[4]/a");
        act.moveToElement(M_StarWars).perform();
        M_StarWars.click();

        //Kupovina proizvoda
        WebElement M_StarWarsKupi = driver.findElementByXPath("/html/body/div[1]/main/div[4]/div/div[1]/div/div[1]/div[2]/div[5]/ul/li/div/button");
        M_StarWarsKupi.click();

        //Provera kupovine preko korpe
        WebElement ProveraKorpe = driver.findElementByXPath("//*[@id=\"miniCartContent\"]/div[1]/a/div[2]");
        ProveraKorpe.click();

        driver.quit();


    }
}
