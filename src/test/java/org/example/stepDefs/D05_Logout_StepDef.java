package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Utilities.AssertionUtilities;
import org.example.pages.P01_Log_inPages;
import org.example.pages.P04_Cart_page;
import org.example.pages.P05_Logout_page;

import static org.example.stepDefs.Hooks.driver;
public class D05_Logout_StepDef {


    P01_Log_inPages loginPage = new P01_Log_inPages();
    P05_Logout_page logoutPage = new P05_Logout_page();

    // Step to verify that the user is logged into the system
//    @Given("I am logged into the system")
//    public void iAmLoggedIntoTheSystem() {
//        // You can add pre-login steps here if needed, but for simplicity,
//        // we assume the user is already logged in
//        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, logoutPage.logoutMenuButton);
//    }

    // Step to click on the logout button
    @When("I click on the logout button")
    public void iClickOnTheLogoutButton() throws InterruptedException {
        logoutPage.clickLogoutMenu();
        logoutPage.clickLogoutButton();
        Thread.sleep(2000);
    }

    // Step to verify the user is redirected to the login page
    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() throws InterruptedException {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, logoutPage.logoutButton);
        Thread.sleep(2000);
    }

    // Step to verify that the login page is displayed after logout
    @And("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() throws InterruptedException {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver, loginPage.login);
        Thread.sleep(2000);
    }




}
