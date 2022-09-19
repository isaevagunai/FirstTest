import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    String MobiPay_URL = "https://next.privat24.ua/mobile";

    @Test
    void CheckMinSum()  {


        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

     // 1-st Test
     // элементы
        By PhoneNum = By.xpath("//input[@data-qa-node='phone-number']");
        By Amount = By.xpath("//input[@data-qa-node='amount']");
        By CardNum = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By CardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By CVV = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By SubmitButton = By.xpath("//button[contains(text(), 'Додати в кошик')]");

        By ExpectedNum = By.xpath("//div[@data-qa-node='details']");


        // действия
         driver.get(MobiPay_URL);
         driver.findElement(PhoneNum).sendKeys("680490695");
         driver.findElement(Amount).sendKeys(Keys.chord(Keys.CONTROL, "a"),"1");
         driver.findElement(CardNum).sendKeys("4006 8956 8904 8337");
         driver.findElement(CardExpDate).sendKeys("03/23");
         driver.findElement(CVV).sendKeys("480");
        // driver.findElement(TandCLink).click();
         driver.findElement(SubmitButton).submit();

         Assertions.assertEquals("Поповнення телефону. На номер +380680490695",driver.findElement(ExpectedNum).getText());

     //  2-nd Test

    // By TandCLink = By.xpath("//a[@href='https://privatbank.ua/terms']");

//        driver.get(MobiPay_URL);
//        String oldTab = driver.getWindowHandle();
//        driver.findElement(TandCLink).click();
//        ArrayList<String>newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(oldTab);
//        driver.switchTo().window(newTab.get(0));
//        Assertions.assertEquals("Умови та правила", driver.getTitle());


    }
}
