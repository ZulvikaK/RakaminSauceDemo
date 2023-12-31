package stepDefinitions;

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

public class product {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user success login in https:\\/\\/www.saucedemo.com\\/")
    public void user_launch_the_web_app() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @When("user click Name Product in first list product")
    public void user_click_name_product_in_first_list_product() throws Exception {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        Thread.sleep(500);
    }

    @Then("user should see product detail page")
    public void user_should_see_product_detail_page() {
        Assert.assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Product details are displayed");
        System.out.println("If Success Choose Product Detail" + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + ",You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + " in Product Detail Page");
        driver.quit();
    }
}
