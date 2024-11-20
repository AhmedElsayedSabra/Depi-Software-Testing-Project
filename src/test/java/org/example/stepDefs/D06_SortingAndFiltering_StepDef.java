package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_productSortingAndFiltering;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static org.example.stepDefs.Hooks.driver;

public class D06_SortingAndFiltering_StepDef {

    P06_productSortingAndFiltering productSortPage = new P06_productSortingAndFiltering(driver);

    @When("I select the sorting option")
    public void iSelectTheSortingOption() {
        // Select the sorting option from the dropdown
        productSortPage.selectSortingOption(3);
    }

    @Then("the products should be sorted by price in descending order")
    public void theProductsShouldBeSortedByPriceDescending() {
        // Check if the products are sorted by price (high to low)
        boolean isSortedCorrectly = productSortPage.isSortedByPriceDescending();

        // Use JUnit assertion to verify the sorting
        Assert.assertTrue(isSortedCorrectly, "The products are not sorted by price in descending order!");
    }


}
