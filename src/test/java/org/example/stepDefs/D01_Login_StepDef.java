package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Utilities.AssertionUtilities;
import org.example.Utilities.Utilities;
import org.example.pages.P01_Log_inPages;
import org.openqa.selenium.By;

import static org.example.stepDefs.Hooks.driver;
public class D01_Login_StepDef
{
    P01_Log_inPages log_in = new P01_Log_inPages();
    @When("enter valid username")
    public void enterUsername(){
      //  Utilities.Send_Data(driver ,log_in.user_name , "error_user");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

    @And("enter valid password")
    public void enterValidPassword() {
        Utilities.Send_Data(driver ,log_in.password , "secret_sauce");
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        Utilities.ClickingOnElement(driver , log_in.login);
    }

    @Then("verify to login page")
    public void verifyToLoginPage() {
        AssertionUtilities.hard_assertion.assertElementDisplayed(driver ,log_in.productTxt );
    }
}
