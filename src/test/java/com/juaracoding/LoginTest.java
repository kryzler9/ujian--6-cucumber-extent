package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    private WebDriver driver;
    private ExtentTest extentTest;

    private LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    // #001

    @Given("I am on the SwagLabs login page")
    public void i_am_on_the_swaglabs_login_page(){
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"I am on the SwagLabs login page");
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password(){
        loginPage.login("standard_user","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter a valid username and password");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"I click on the login button");
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page(){
        Assert.assertEquals(loginPage.getTxtProducts(), "Products");
        extentTest.log(LogStatus.PASS,"I should be redirected to the products page");
    }

    // #002
    @When("I enter an invalid username and password")
    public void i_enter_an_invalid_username_and_password(){
        loginPage.login("new_user","mayo_sauce");
        extentTest.log(LogStatus.PASS,"I enter an invalid username and password");
    }

    @Then("I should see username and password do not match")
    public void i_should_see_username_and_password_do_not_match(){
        DriverSingleton.delay(2);
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS,"I should see username and password do not match");
    }

    // #003
    @When("I enter a valid username without password")
    public void i_enter_a_valid_username_without_password(){
        loginPage.clearUsername();
        loginPage.clearPassword();
        DriverSingleton.delay(2);
        loginPage.login("standar_user","");
        extentTest.log(LogStatus.PASS,"I enter an invalid username and a valid password");
    }

    @Then("I should see password required")
    public void i_should_see_password_required(){
        DriverSingleton.delay(2);
        Assert.assertEquals(loginPage.getTxtPasswordRequired(),"Epic sadface: Password is required");
        extentTest.log(LogStatus.PASS,"I should see password required");
    }

    // #004
    @When("I enter nothing on username and a valid password")
    public void i_enter_nothing_on_username_and_a_valid_password(){
        loginPage.clearUsername();
        loginPage.clearPassword();
        DriverSingleton.delay(2);
        loginPage.login("","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter nothing on username and a valid password");
    }

    @Then("I should see username required")
    public void i_should_see_username_required(){
        DriverSingleton.delay(2);
        Assert.assertEquals(loginPage.getTxtUsernameRequired(),"Epic sadface: Username is required");
        DriverSingleton.closeObjectInstance();
        extentTest.log(LogStatus.PASS,"I should see username required");

    }
}
