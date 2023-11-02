package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class order {
    WebDriver driver = null;
    String baseUrl = "https://www.saucedemo.com/";
    static String expectedProductName = "";

    @Given("user in home page")
    public void user_in_home_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        assertEquals("Swag Labs", driver.getTitle());
    }

    @When("user enters login credentials {string} and {string}")
    public void user_enters_login_credentials_and(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @When("user click on {string} button")
    public void user_click_on_button(String button) {
        switch (button) {
            case "login":
                driver.findElement(By.id("login-button")).click();
                break;
            case "add to cart":
                driver.findElement(By.cssSelector("button[id^=add-to-cart]")).click();
                break;
            case "go to cart":
                driver.findElement(By.className("shopping_cart_link")).click();
                break;
            case "checkout":
                driver.findElement(By.id("checkout")).click();
                break;
            case "continue":
                driver.findElement(By.id("continue")).click();
                break;
            case "finish":
                driver.findElement(By.id("finish")).click();
                break;
        }
    }
    @Then("user verifies the {string} page")
    public void user_verifies_the_page(String page) {
        String actualTitle = driver.findElement(By.className("title")).getText();
        String expectedTitle = "";
        switch (page) {
            case "product":
                expectedTitle = "Products";
                break;
            case "cart":
                expectedTitle = "Your Cart";
                break;
            case "checkout information":
                expectedTitle = "Checkout: Your Information";
                break;
            case "checkout overview":
                expectedTitle = "Checkout: Overview";
                break;
            case "checkout complete":
                expectedTitle = "Checkout: Complete!";
                break;
        }
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("user select a product {string}")
    public void user_select_a_product(String productName) {
        List<WebElement>products = driver.findElements(By.className("inventory_item_name"));
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                product.click();
                break;
            }
        }
        expectedProductName = productName;
    }
    @Then("user verifies the product title on {string} page")
    public void user_verifies_the_product_title_on_page(String page) {
        String actualProductTitle = "";
        if (page.equals("product details")) {
            actualProductTitle =
                    driver.findElement(By.className("inventory_details_name")).getText();
        } else {
            actualProductTitle = driver.findElement(By.className("inventory_item_name")).getText();
        }
        assertEquals(expectedProductName, actualProductTitle);
    }

    @Then("user enters checkout information {string} {string} and {string}")
    public void user_enters_checkout_information_and(String firstname, String lastname, String zipcode) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        driver.findElement(By.id("postal-code")).sendKeys(zipcode);
    }
    @Then("user verifies the success message on checkout complete page")
    public void user_verifies_the_success_message_on_checkout_complete_page() {
        String successMessage =driver.findElement(By.className("complete-header")).getText();
        assertEquals("Thank you for your order!", successMessage);
        driver.close();
    }
}
