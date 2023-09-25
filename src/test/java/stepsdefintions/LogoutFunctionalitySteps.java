package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogoutFunctionalitySteps {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        driver.close();
    }
    @Given("I am on the EBankApp page Launch Browser valid User ID ,Pin And logout")
    public void i_am_on_the_e_bank_app_page_launch_browser_valid_user_id_pin_and_logout() {
        driver.get("https://qaebank.ccbp.tech/ebank/login");

    }
    @When("I am enter the valid User ID and PIN in input field in Logout test")
    public void i_am_enter_the_valid_user_id_and_pin_in_input_field_in_logout_test() {
        //Enter the User ID as 142420 and PIN as 231225
        WebElement userIdInputEle  = driver.findElement(By.id("userIdInput"));
        userIdInputEle.sendKeys("142420");
        WebElement pinInputEle  = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");

    }
    @And("After given valid User ID and PIN I click the Login button in logout test")
    public void after_given_valid_user_id_and_pin_i_click_the_login_button_in_logout_test() {
        //Click the Login button
        WebElement loginBtnEle = driver.findElement(By.className("login-button"));
        loginBtnEle.click();
    }
    @And ("After click on the login and Wait for the page to be redirected to Homepage")
    public void after_click_on_the_login_and_wait_for_the_page_to_be_redirected_to_homepage() {
        //Verify the URL,
        //Expected URL: https://qaebank.ccbp.tech/

        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "https://qaebank.ccbp.tech/";

        Assert.assertEquals(actualUrl,expectedUrl,"Home Url Mismatch");
    }
    @And ("After redirected to homepage and Click on Logout Button")
    public void after_redirected_to_homepage_and_click_on_logout_button() {
        //Click the Logout button

        WebElement LogoutButtonEle = driver.findElement(By.className("logout-button"));
        LogoutButtonEle.click();

    }
    @Then("After ClickOn Logout I should be Show the Login Page")
    public void after_click_on_logout_i_should_be_show_the_login_page() {
       //Verify the URL,
        //Expected URL: https://qaebank.ccbp.tech/login

        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/ebank/login"));

        String actualLoginUrl = driver.getCurrentUrl();
        String expectedLoginUrl = "https://qaebank.ccbp.tech/ebank/login";

        Assert.assertEquals(actualLoginUrl,expectedLoginUrl,"Login Url mismatch");
    }


}
