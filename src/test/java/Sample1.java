import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample1 {
    //leisti po viena
    @Test // anotacija, kuri leidžia javai suprasti, kad tai yra testas ir jį reikia paleisti.
    public void test1(){//jei atidaro teisingai pakūrėme projektą
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");//reikia https
    }
    @Test //leisti po viena
    public void test2(){//jei atidaro teisingai pakūrėme projektą
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");

        WebElement cookieButton = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[1]/div/div[2]/div/button[1]")); //čia pilnas xphath. parodyti kaip išsitraukti pilną ir dalinį. (//*[@id="onetrust-accept-btn-handler"]) papasakoti kuo skirias. Dalinis xpath eina nuo artimiausio tėvinio unikalaus švyturio, pilnas nuo HTML pradžios.
        cookieButton.click();
        driver.findElement(By.xpath("//*[@id=\"searchKeyword\"]")).sendKeys("traktorius");// operacija nekuriant kintamojo.
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
    }


    @Test //leisti po viena
    public void test3(){//jei atidaro teisingai pakūrėme projektą
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("searchKeyword")).sendKeys("traktorius");// operacija nekuriant kintamojo.
        // //*[@id="searchKeyword"]  paltginti dalinio xpath struktūrą su id. iš xpath matosi, kad elementas turi savo id.
        // papasakoti kad galima selectinti pagal id, unikalu, pagal klase, (jei vienas elementas ok, jei keli su ta klase paims pirmą. arba su findelements galima paimti visus su x klase, bet tai vėliau.)
        driver.findElement(By.id("searchButton")).click();

    }

    //paleisti visus testus kartu. matome, kad sukuria 3 chromedriverius, ir kiekviename isjungiame cookius.
    //atsidaryti task managerį ir parodyti kabančius chromedriverius. mes juos paleidom bet neišjungėm. Sample2 sturktūra suhandlins tai.
}
