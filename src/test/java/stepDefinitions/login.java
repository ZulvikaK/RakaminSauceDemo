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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user should be open https:\\/\\/www.saucedemo.com\\/ in web browser")
    public void user_should_be_open_https_www_saucedemo_com_in_web_browser() throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @When("user input valid username and password")
    public void user_input_valid_username_and_password() throws Exception{
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }
    @And("user click button login")
    public void user_click_button_login() throws Exception {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }
    @Then("user should navigate to swag labs home page")
    public void user_should_navigate_to_swag_labs_home_page() throws Exception{
        Assert.assertEquals("Products", driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : User login using registered user and password");
        System.out.println("if Success Login, You Can See Title Name" + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
}

