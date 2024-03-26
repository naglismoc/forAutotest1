import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sample2 {
public static WebDriver driver; // papasakoti apie statinį kintamąjį, kad jis bus pasiekiamas klases scope, matomas iš visų metodų. kad jam reikšmė pirma suteikiame setUp metode, ir kiti metodai jau naudosis kintamuoju su ta reikšme. turėsime vieną chromeDriverio objektą visiems testams.

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("searchKeyword")).sendKeys("traktorius");
        driver.findElement(By.id("searchButton")).click();
    }
    @Test
    public void test2(){//sitas mes errorą. 1. testų eiliškumas: testus leidžia alphabetiškai. 2. mes jau išjungėme cookius, tad antras testas neturi ką išjungti ir lūžta.(žiūrėti setUp() komentarą sekančiam žingsniui
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("searchKeyword")).sendKeys("kompiuteris");
        driver.findElement(By.id("searchButton")).click();
    }
    @BeforeClass// papasakoti, kad pasileidžia šioje klasėje PRIEŠ testus
    public static void setUp(){
        driver = new ChromeDriver();
      //  acceptCookies(); pirmas paleidimas kartu test7 test1 ir test2 BE cookių. tikslas gauti erorą.
        // task1 ir task2 testuose užkomentuojame cookių acceptinimą ir atkomentuojame setUp/acceptCookies() metodą.
        //atkomentuojam sekančią eilutę ir papasakojam ką ji daro
        driver.manage().window().maximize(); // maximize window keista, bet padidina testų veikimą, mažiau feilina
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// palaukia iki 5s, jei kažkas negerai, jei nesimato elemento, jei jis dar neužsikrovė ir tt, užuot, kad iš karto sulūžtų. prieš rodant tai, parodyti Thread.sleep() kokiame nors metode, kad žinotų, kad galime uždėti fiksuotą palaukimą. papaskoti apie try catch, nerodžiau dar.
        //fsio, yra struktūra, galima toliau dirbti :D
    }
    @AfterClass// papasakoti, kad pasileidžia šioje klasėje PO testų
    public static void tearDown(){
        driver.quit();// uždaro naršyklės langą ir išjungia chromedriverį. siūlau kartą parodyti ir užkomentuoti, nes tada nesimato kurioje vietoje kodas sulūžo
    }
    public static void acceptCookies(){
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("searchKeyword")).sendKeys("traktorius");
    }
}
