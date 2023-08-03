package bg.proxiad.demo.ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserPostPageSeleniumTest {
    public final static String BROWSER_PATH = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";

    private WebDriver driver;

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions().setBinary(BROWSER_PATH);
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        String pageUnderTest = "http://localhost:8082/CrudAppUsers_war_exploded/create-user";  //better move it to a page object
        driver.get(pageUnderTest);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testFormCorrectMethod() {  //might be unnecessary
        WebElement form = driver.findElement(By.cssSelector(".form"));
        String actualFormMethod = form.getAttribute("method");
        String expectedFormMethod = "post";

        assertEquals(expectedFormMethod, actualFormMethod, "Expected Form method is not matching actual Form method");
    }

    @Test
    @DisplayName("Test error message if user submitted a blank input field for name")
    void testSubmittedBlankName() {
        WebElement inputFieldName = driver.findElement(By.cssSelector("#name"));
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        inputFieldName.sendKeys("");
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.id("name.errors"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Name is required";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test correct error message if user submitted less than min permitted age")
    void testSubmittedNegativeAge() {
        WebElement inputFieldName = driver.findElement(By.cssSelector("#age-input"));
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        inputFieldName.sendKeys("-1");
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[2]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Min age is 5";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test correct error message if user submitted bigger number than max permitted age")
    void testSubmittedBiggerThanMaxAge() {
        WebElement inputFieldName = driver.findElement(By.cssSelector("#age-input"));
        inputFieldName.sendKeys("101");
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[2]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Age must not be above 100";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test error message if user submitted a blank input field for age")
    void testSubmittedBlankAge() {
        WebElement inputFieldName = driver.findElement(By.cssSelector("#age-input"));
        inputFieldName.sendKeys("");
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[2]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Age is required";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test error message if user submitted a blank input field for city")
    void testSubmittedBlankCity() {
        WebElement inputFieldName = driver.findElement(By.id("addressDTO.city"));
        inputFieldName.sendKeys("");
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[3]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "City is required";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test error message if user submitted a blank input field for street")
    void testSubmittedBlankStreet() {
        WebElement inputFieldName = driver.findElement(By.id("addressDTO.city"));
        inputFieldName.sendKeys("");
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[4]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Street is required";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

    @Test
    @DisplayName("Test error message if user submitted a blank input field for number")
    void testSubmittedBlankNumber() {
        WebElement inputFieldName = driver.findElement(By.cssSelector("#number-input"));
        inputFieldName.sendKeys("");
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement errorDiv = driver.findElement(By.xpath("/html/body/div/form/div[1]/div[5]"));
        String actualErrorMessage = errorDiv.getText();
        String expectedErrorMessage = "Number is required";

        assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error div's text doesn't match actual error div's text");
    }

}
