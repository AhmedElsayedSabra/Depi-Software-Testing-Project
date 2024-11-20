package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P05_Logout_page {
  public By logoutMenuButton = By.id("react-burger-menu-btn");  // Menu button to open the logout menu
  public By logoutButton = By.id("logout_sidebar_link");  // Logout button within the menu

  // Method to click the menu button
  public void clickLogoutMenu() {
    driver.findElement(logoutMenuButton).click();
  }

  // Method to click the logout button
  public void clickLogoutButton() {
    driver.findElement(logoutButton).click();
  }
}
