package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Utilities.AssertionUtilities;
import org.example.pages.P02_AddToCart_Pages;
import org.openqa.selenium.By;

import static org.example.stepDefs.Hooks.driver;

public class D02_addToCart_Def {
    P02_AddToCart_Pages addCart = new P02_AddToCart_Pages();
    @When("Click on Add to cart")
    public void clickOnAddToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(3000);

    }

    @Then("verify that remove is displayed")
    public void verifyThatRemoveIsDisplayed() throws InterruptedException {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver,addCart.removeBtn);
        Thread.sleep(3000);
    }

    @When("click on shop icon")
    public void clickOnShopIcon() throws InterruptedException {
        driver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]")).click();
        Thread.sleep(3000);
    }

    @Then("verify that the product is added to cart")
    public void theProductIsAddedToCart() throws InterruptedException {
       AssertionUtilities.hard_assertion.assertElementsDisplayed(driver,addCart.Number_Txt,0);
       Thread.sleep(3000);
    }
}






