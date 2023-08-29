import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMarket {

    @Test
    public void openMarket() {
        System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://ya.ru/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            String window1 = driver.getWindowHandle();

            WebElement search = driver.findElement(By.xpath("//input[@role='combobox']"));
            search.click();
            Thread.sleep(2000);
            WebElement market = driver.findElement(By.cssSelector(".services-suggest__icon"));
            market.click();
            Thread.sleep(5000);

            Set<String> currentWindows = driver.getWindowHandles();
            String window2 = null;

            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            driver.switchTo().window(window2);

            WebElement katalog = driver.findElement(By.cssSelector(".V9Xu6._1KI8u.Lfy7z._3iB1w._35Vhw"));
            katalog.click();
            Thread.sleep(3000);

            WebElement smart = driver.findElement(By.cssSelector(".egKyN._1mqvV._1wg9X"));
            smart.click();
            Thread.sleep(5000);

            WebElement price = driver.findElement(By.xpath("//label[text()='Цена, ₽ до']/parent::*//input"));
            price.sendKeys("20000");
            Thread.sleep(3000);

            WebElement made1 = driver.findElement(By.xpath("(//div[contains(@data-zone-data, 'Производитель')]//label)[1]//span[@class='_2XaWK']"));
            made1.click();
            Thread.sleep(500);
            WebElement made2 = driver.findElement(By.xpath("(//div[contains(@data-zone-data, 'Производитель')]//label)[2]//span[@class='_2XaWK']"));
            made2.click();
            Thread.sleep(500);
            WebElement made3 = driver.findElement(By.xpath("(//div[contains(@data-zone-data, 'Производитель')]//label)[3]//span[@class='_2XaWK']"));
            made3.click();
            Thread.sleep(500);
            WebElement made4 = driver.findElement(By.xpath("(//div[contains(@data-zone-data, 'Производитель')]//label)[4]//span[@class='_2XaWK']"));
            made4.click();
            Thread.sleep(500);
            WebElement made5 = driver.findElement(By.xpath("(//div[contains(@data-zone-data, 'Производитель')]//label)[5]//span[@class='_2XaWK']"));
            made5.click();
            Thread.sleep(500);

            Actions moveDia = new Actions(driver);
            WebElement dia = driver.findElement(By.xpath("//label[text()='Диагональ экрана (точно), \" от']/parent::*//input"));
            moveDia.moveToElement(dia);
            dia.sendKeys("3");
            Thread.sleep(3000);

            try {
                List<WebElement> childs = driver.findElements(By.xpath("//div[@data-test-id='virtuoso-item-list']/descendant::article[@data-autotest-id='product-snippet']"));
                int size = childs.size();
                assertEquals(10, size);
            } catch (AssertionError e) {
                System.out.println("Количество элементов не равно 10");
            }
            WebElement firtstElement = driver.findElement(By.xpath("//span[text()='Смартфон realme C35 4/64 ГБ RU, Dual nano SIM, зеленый']"));

            Actions moveRait = new Actions(driver);
            WebElement rait = driver.findElement(By.xpath("//button[contains(@data-zone-data, 'по рейтингу']"));
            moveDia.moveToElement(rait).click().build().perform();


        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }


    }

}
