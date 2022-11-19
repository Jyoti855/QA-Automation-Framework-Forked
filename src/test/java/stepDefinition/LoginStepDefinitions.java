package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.
                elementToBeClickable(
                        By.cssSelector("[type='email']")))
                .sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.
                elementToBeClickable(
                        By.cssSelector("[type='password']")))
                .sendKeys(password);
    }

    @And("I submit")
    public void iSubmit() {
        WebElement element = driver.findElement(By.cssSelector("[type='submit']"));
        element.click();
      /*  wait.until(ExpectedConditions.
                elementToBeClickable(
                        By.cssSelector("[type='submit']")))
                .click();*/
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After
    public void iCloseTheBrowser()  {
        driver.quit();
    }
}
