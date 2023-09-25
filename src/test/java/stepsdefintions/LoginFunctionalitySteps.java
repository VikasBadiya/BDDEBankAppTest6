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

public class LoginFunctionalitySteps {
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


    //Test the login functionality with empty fields


    @Given("I am on the EBankApp page with the Empty fields")
    public void i_am_on_the_e_bank_app_page_with_the_empty_fields() {
        driver.get("https://qaebank.ccbp.tech/ebank/login");

    }
    @When("I click the Login button")
    public void i_click_the_login_button() {
        WebElement LoginButton = driver.findElement(By.className("login-button"));
        LoginButton.click();

    }
    @Then("The EBankApp page should be show the Error Message")
    public void the_e_bank_app_page_should_be_show_the_error_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        WebElement errorMessageText = driver.findElement(By.className("error-message-text"));
        String actualErrorMessage = errorMessageText.getText();
        String expectedErrorMessage = "Invalid user ID";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");

    }


    //Test the login functionality with an empty User ID field
    @Given("I am on the EBankApp page")
    public void i_am_on_the_e_bank_app_page() {
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        driver.get("https://qaebank.ccbp.tech/ebank/login");

    }
    @When("I am enter the pin in input field and with empty user Id")
    public void i_am_enter_the_pin_in_input_field_and_with_empty_user_id() {
        //Enter the PIN as 231225
        WebElement pinInputField = driver.findElement(By.id("pinInput"));
        pinInputField.sendKeys("231225");


    }
    @And("After given pin I click the Login button")
    public void after_given_pin_i_click_the_login_button() {
        //Click the Login button
        WebElement loginBtnEle = driver.findElement(By.className("login-button"));
        loginBtnEle.click();

    }
    @Then("The EBankApp page should be show the Error Message Invalid user ID")
    public void the_e_bank_app_page_should_be_show_the_error_message_invalid_user_id() {
        //Verify the error text,
        //Expected text: Invalid PIN

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        WebElement errorMessageText = driver.findElement(By.className("error-message-text"));
        String actualErrorMessage = errorMessageText.getText();
        String expectedErrorMessage = "Invalid user ID";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");

    }

    //Test the login functionality with an empty PIN field


    @Given("I am on the EBankApp page Launch Browser")
    public void i_am_on_the_e_bank_app_page_launch_browser() {
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        driver.get("https://qaebank.ccbp.tech/ebank/login");

    }
    @When("I am enter the user Id in input field and with empty PIN")
    public void i_am_enter_the_user_id_in_input_field_and_with_empty_pin() {

        //Enter the User ID as 142420
        WebElement userIdInputEle = driver.findElement(By.id("userIdInput"));
        userIdInputEle.sendKeys("142420");

    }
    @And("After given User Id I click the Login button")
    public void after_given_user_id_i_click_the_login_button() {
        //Click the Login button
        WebElement loginBtnEle = driver.findElement(By.className("login-button"));
        loginBtnEle.click();

    }

    @Then("The EBankApp page should be show the Error Message Invalid PIN")
    public void the_e_bank_app_page_should_be_show_the_error_message_invalid_PIN() {
        //Verify the error text,
        //Expected text: Invalid PIN

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        WebElement errorMessageText = driver.findElement(By.className("error-message-text"));
        String actualErrorMessage = errorMessageText.getText();
        String expectedErrorMessage = "Invalid PIN";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");

    }

    //Test the login functionality with an invalid PIN field

    @Given("I am on the EBankApp page Launch Browser invalid PIN field")
    public void i_am_on_the_e_bank_app_page_launch_browser_invalid_pin_field() {
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        driver.get("https://qaebank.ccbp.tech/ebank/login");
    }
    @When("I am enter the User Id And invalid PIN field in input field")
    public void i_am_enter_the_user_id_and_invalid_pin_field_in_input_field() {
        //Enter the User ID as 142420 and PIN as 123456
        WebElement userIdInputEle  = driver.findElement(By.id("userIdInput"));
        userIdInputEle.sendKeys("142420");
        WebElement pinInputEle  = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("123456");

    }
    @And("After given User Id And Pin I click the Login button")
    public void after_given_user_id_and_pin_i_click_the_login_button() {
        //Click the Login button
        WebElement loginBtnEle = driver.findElement(By.className("login-button"));
        loginBtnEle.click();
    }
    @Then("The EBankApp page should be show the Error Message Invalid PIN Text")
    public void the_e_bank_app_page_should_be_show_the_error_message_invalid_pin_text() {
        //Verify the error text,
        //Expected text: User ID and PIN didn't match
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        WebElement errorMessageText = driver.findElement(By.className("error-message-text"));
        String actualErrorMessage = errorMessageText.getText();
        String expectedErrorMessage = "User ID and PIN didn't match";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error Message Mismatch");
    }

    //Test the login functionality with a valid User ID and PIN

    @Given("I am on the EBankApp page Launch Browser valid User ID and PIN")
    public void i_am_on_the_e_bank_app_page_launch_browser_valid_user_id_and_pin() {
        driver.get("https://qaebank.ccbp.tech/ebank/login");

    }
    @When("I am enter the valid User ID and PIN in input field")
    public void i_am_enter_the_valid_user_id_and_pin_in_input_field() {
        //Enter the User ID as 142420 and PIN as 231225
        WebElement userIdInputEle  = driver.findElement(By.id("userIdInput"));
        userIdInputEle.sendKeys("142420");
        WebElement pinInputEle  = driver.findElement(By.id("pinInput"));
        pinInputEle.sendKeys("231225");

    }
    @And("After given valid User ID and PIN I click the Login button")
    public void after_given_valid_user_id_and_pin_i_click_the_login_button() {
        //Click the Login button
        WebElement loginBtnEle = driver.findElement(By.className("login-button"));
        loginBtnEle.click();

    }
    @Then("The EBankApp page should be show the Error Message valid User ID and PIN")
    public void the_e_bank_app_page_should_be_show_the_error_message_valid_user_id_and_pin() {
        //Verify the URL,
        //Expected URL: https://qaebank.ccbp.tech/

        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "https://qaebank.ccbp.tech/";

        Assert.assertEquals(actualUrl,expectedUrl,"Home Url Mismatch");

    }







}
