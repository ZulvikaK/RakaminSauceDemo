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

    @Given("user success login in https:\\/\\/www.saucedemo.com\\/")
    public void user_success_login_in_https_www_saucedemo_com() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
    public void will_display_list_product_in_home_page_will_sorting_based_on_price_high_to_low() throws Exception{
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        System.out.println("Scenario: choose price (high to low)");
        System.out.println("If Success Sorting Price High to Low, You Can See First Product Will See Price" + driver.findElement(By.xpath("//div[@class+'inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
    }
}
