package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P04_Cart_page {
   public By CartIcon = By.cssSelector("a[class=\"shopping_cart_link\"]");
    public By cartItemCount = By.className("shopping_cart_badge");
    public By cartPageTitle = By.xpath("//span[text()='Your Cart']");
    public By emptyCartMessage = By.xpath("//div[text()='Your cart is empty']");
    public By getCartItemByName(String productName) {
        return By.xpath("//div[text()='" + productName + "']");
    }
}
