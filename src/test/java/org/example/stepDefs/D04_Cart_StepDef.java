package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Utilities.AssertionUtilities;
import org.example.pages.P04_Cart_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.stepDefs.Hooks.driver;
import java.time.Duration;

public class D04_Cart_StepDef {

    P04_Cart_page cartPage = new P04_Cart_page();

    // Step to add a product to the cart
    @When("I add a product to the cart")
    public void iAddAProductToTheCart() {
        // Clicking the add to cart button for the Sauce Labs Backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    // Step to verify that the product has been added to the cart
    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, cartPage.CartIcon);
    }

    // Step to click on the cart icon to view the cart
    @And("I click on the cart icon")
    public void iClickOnTheCartIcon() {
        driver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]")).click();
    }

    // Step to verify that the cart page is visible
    @Then("I should see the cart page")
    public void iShouldSeeTheCartPage() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, cartPage.cartPageTitle);
    }

    // Step to verify that a specific product is in the cart
    @Then("the product {string} should be in the cart")
    public void theProductShouldBeInTheCart(String productName) {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, cartPage.getCartItemByName(productName));
    }

    // Step to remove the product from the cart
    @When("I remove the product from the cart")
    public void iRemoveTheProductFromTheCart() {
        // Wait for the remove button to be clickable before clicking
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("remove-sauce-labs-backpack")));
        removeButton.click();
    }

    // Step to verify that the cart is empty
    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        // Assuming cartPage.cartItemCount and cartPage.emptyCartMessage are defined in P04_Cart_page
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, cartPage.cartItemCount);
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, cartPage.emptyCartMessage);
    }
}