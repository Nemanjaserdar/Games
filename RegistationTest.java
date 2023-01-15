package Tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Test Registretion On Site
 * Open Games.rs site
 * Click on Sing up button
 * Enter Firstname
 * Enter Lastname
 * Enter e-mail adress
 * Enter phone number
 * Enter City
 * Enter Street name
 * Enter Street number
 * Enter postcode
 * Enter password
 * Enter check password
 * Check box im not robot and terms
 * Click on register button
 * Popup page sucsessfully registred message
 * Pringing sucsessfully registred message
 */


public class RegistationTest {

        @Test
        public void RegistrationOnSite() {

            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.games.rs/");
            WebElement registrujseButton = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 col-md-5']//a[@class = 'register-btn']");
            registrujseButton.click();

            //Upisivanje u kolonu ime
            WebElement imeField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 naturalPerson']//input[@id = 'reg_firstname']");
            imeField.click();
            imeField.sendKeys("Nemanja");

            //Upisivanje u kolonu prezime
            WebElement prezimeField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 naturalPerson']//input[@id = 'reg_lastname']");
            prezimeField.click();
            prezimeField.sendKeys("Serdar");

            //Upisivanje u kolonu email adresu
            WebElement emailField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 reg-email-input-wrapper']//input[@id = 'reg_email']");
            emailField.click();
            emailField.sendKeys("nemanjaserdar@gmail.com");

            //Upisivanje u kolonu telefon
            WebElement telefonField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 reg-phone-input-wrapper']//input[@id = 'reg_phone']");
            telefonField.click();
            telefonField.sendKeys("0642898781");

            //Upisivanje u kolonu grad
            WebElement gradField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 city-input-wrapper']//input[@id = 'reg_city']");
            gradField.click();
            gradField.sendKeys("Novi Sad - Kisač");

            //Upisivanje u kolonu ulica
            WebElement ulicaField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 col-sm-6 address-input-wrapper']//input[@id = 'reg_address']");
            ulicaField.click();
            ulicaField.sendKeys("Masarikova");

            //Upisivanje u kolonu broj ulice
            WebElement brojField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 street-no-input-wrapper']//input[@id = 'reg_street_no']");
            brojField.click();
            brojField.sendKeys("92");

            //Upisivanje u kolonu postanski broj
            WebElement postanskibrojField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 postcode-input-wrapper']//input[@id = 'reg_postcode']");
            postanskibrojField.click();
            postanskibrojField.sendKeys("21211");

            //Upisivanje u kolonu lozinka
            WebElement lozinkaField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 password-input-wrapper']//input[@id = 'reg_password']");
            lozinkaField.click();
            lozinkaField.sendKeys("Nemanjatest");

            //Upisivanje u kolonu ponovljena lozinka
            WebElement ponovljenalozinkaField = driver.findElementByXPath("//div[@class = 'col-xs-12 col-sm-6 password-repeat-input-wrapper']//input[@id = 'reg_password_repeat']");
            ponovljenalozinkaField.click();
            ponovljenalozinkaField.sendKeys("Nemanjatest");


            /*
            //Ovaj deo sa stikliranjem checkbox-a nece da radi

            WebElement uslovikoriscenjaField = driver.findElementByXPath("//div[@class = 'col-xs-12 reg-check-werapper terms-conditions-wrapper'//div[@class = 'icheckbox_flat icheck-item icheck[rv5a8] hover checked']");
            uslovikoriscenjaField.click();

            WebElement robotField = driver.findElementByXPath("/html/body/div[2]/div[1]");
            robotField.click();
            */
            //Pokretanje registracije
            WebElement login = driver.findElementByXPath("//button[@class = 'btn btn-success confirm-loader']");
            login.click();

            //Izbacivanje poruke da ste se uspesno registrovali
            WebElement provera = driver.findElementByXPath("//*[@id=\"registration_modal\"]/div[2]/div[1]");
            provera.click();

            driver.quit();
            System.out.println("Successfully registered");


        }
    }