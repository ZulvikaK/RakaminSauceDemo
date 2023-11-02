package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class sorting {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user launch saucedemo web app")
    public void user_launch_saucedemo_web_app() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);

    }
    @When("user click Name \\(A to Z) in top right of page")
    public void user_click_name_A_to_Z_in_top_right_of_page() throws Exception{
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
    }
    @And("user choose price \\(high to low)")
    public void user_choose_price_high_to_low() throws Exception{
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        Thread.sleep(500);
    }
    @Then("will display list product in home page will sorting based on price high to low")
    public void will_display_list_product_in_home_page_will_sorting_based_on_price_high_to_low() {
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText());
        System.out.println("Scenario: choose price (high to low)");
        System.out.println("If Success Sorting Price High to Low, You Can See First Product Will See Price" + driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText());
        driver.quit();
    }
}
