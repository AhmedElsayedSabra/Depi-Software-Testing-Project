package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.example.Utilities.AssertionUtilities;
import org.example.pages.P01_Log_inPages;
import org.example.pages.P03_Chekout_Page;
import org.openqa.selenium.By;

import static org.example.stepDefs.Hooks.driver;

public class D03_Checkout_StepDef {
    P03_Chekout_Page chekoutPage = new P03_Chekout_Page();
    P01_Log_inPages logInPage = new P01_Log_inPages();


    Faker faker = new Faker();
    String firstName = faker.name().firstName();    // Random first name
    String lastName = faker.name().lastName();      // Random last name
    String postalCode = faker.address().zipCode();  // Random postal code

    @When("your cart page is visible successfully")
    public void your_cart_page_is_visible_successfully() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, chekoutPage.CheckoutYourInformationTxt);
    }


    @Then("Click on checkout button")
    public void clickOnCheckoutButton() {
        driver.findElement(By.cssSelector("button[id=\"checkout\"]")).click();
    }

    @And("enter your first name")
    public void enterYourFirstName() {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }
    @And("enter your last name")
    public void enterYourLastName() {
        driver.findElement(By.cssSelector("#last-name")).sendKeys("samah");
        System.out.println("hhhh");
    }

    @And("enter your postal code")
    public void enterYourPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @Then("Verify that form data is valid")
    public void verifyFormDataIsValid() {
        // Get the values from the form fields
        String firstName = driver.findElement(By.id("first-name")).getAttribute("value");
        String lastName = driver.findElement(By.id("last-name")).getAttribute("value");
        String postalCode = driver.findElement(By.id("postal-code")).getAttribute("value");

        // Validate that fields are not empty
        Assert.assertFalse("First name is empty!", firstName.isEmpty());
        Assert.assertFalse("Last name is empty!", lastName.isEmpty());
        Assert.assertFalse("Postal code is empty!", postalCode.isEmpty());

        // Optional: Additional validation (e.g., regex or length check)
        Assert.assertTrue("Postal code is not valid!", postalCode.matches("\\d{5}")); // Example for a 5-digit postal code
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Verify that detail of payment is visible")
    public void verifyThatDetailOfPaymentIsVisible() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, chekoutPage.CheckoutYourInformationTxt);
    }

    @When("click on finish button")
    public void clickOnFinishButton() {
        driver.findElement(By.cssSelector("button[id=\"finish\"]")).click();
    }

    @And("Click on Back Home")
    public void ClickOnBackHome() {
        driver.findElement(By.id("back-home")).click();
    }

    @Then("Verify that Login page is visible")
    public void verifyThatLoginPageIsVisible() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, logInPage.login);
    }

    @And("Checkout: Complete! page is displayed")
    public void checkoutCompletePageIsDisplayed() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, chekoutPage.CheckoutYourInformationTxt);
    }
}
