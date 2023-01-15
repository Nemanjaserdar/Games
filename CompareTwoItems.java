package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/**
 * Test for Compare two items
 * Open Games.rs site
 * Accept cookies on page
 * Hover on burger meni Sve Kategorije
 * Hover on Gift
 * Select Majce page
 * Find 1st item
 * Select item and put in compare folder
 * Go back on Majca page
 * Select 2nd item
 * Check if both products are in the folder for cheking
 * Opening folder for cheking

 * Expected results
 * Two product item are put in compare list and you can compare two products
 */

public class CompareTwoItems {


        @Test
        public void Compare() throws InterruptedException {
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

            //Ubacivanje u uporedjivanje folder
            WebElement M_StarWarsUporedi = driver.findElementByXPath("/html/body/div[1]/main/div[4]/div/div[1]/div/div[1]/div[2]/div[10]/a/span");
            M_StarWarsUporedi.click();

            //Vracanje na stranicu gde se nalaze sve majce
            WebElement VracanjeNaMajce = driver.findElementByXPath("/html/body/div[1]/main/div[1]/div/div/ul/li[4]/a");
            VracanjeNaMajce.click();

            //Biranje druge majce
            WebElement M_Mandalorian = driver.findElementByXPath("/html/body/div[1]/main/div[3]/div/div[2]/div[2]/div[3]/div/div[11]/div/div/div[3]/div[4]/a");
            M_Mandalorian.click();

            //Ubacivanje druge majce za uporedjivanje
            WebElement M_MandalorianUporedi = driver.findElementByXPath("/html/body/div[1]/main/div[4]/div/div[1]/div/div[1]/div[2]/div[10]/a");
            M_MandalorianUporedi.click();

            //Proveravanje da li su oba proizvoda ubacena u folder za uporedjivanje
            WebElement Uporedjivanjeclick = driver.findElementByXPath("/html/body/div[1]/main/div[2]/div[1]");
            Uporedjivanjeclick.click();

            //Otvaranje stranice za uporedjivanje dva proizvoda
            String StranaZaUporedjivanje = "https://www.games.rs/uporedjivanje-proizvoda";
            driver.get(StranaZaUporedjivanje);
            WebElement UporedjivanjeDveMajce = driver.findElementByXPath("//*[@id=\"product-compare-content\"]/div/div[3]/div/div/div/div/div[3]/div");
            act.moveToElement(UporedjivanjeDveMajce).perform();

            driver.quit();

        }
}
