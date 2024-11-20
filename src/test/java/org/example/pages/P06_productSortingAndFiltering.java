package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P06_productSortingAndFiltering {
    WebDriver driver;

    // Constructor to initialize driver
    public P06_productSortingAndFiltering(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the sorting dropdown
    By sortingDropdown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span");

    // Method to get the product prices from the page
    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();

        for (WebElement element : priceElements) {
            // Remove $ sign and parse to double
            String priceText = element.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }

        return prices;
    }

    // Method to check if prices are sorted in descending order
    public boolean isSortedByPriceDescending() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);

        // Sort in descending order
        sortedPrices.sort(Comparator.reverseOrder());

        // Compare original prices with sorted list
        return prices.equals(sortedPrices);
    }

    // Method to select the sorting option (Price high to low)
    public void selectSortingOption(int optionText) {
        WebElement sortDropdownList = driver.findElement(By.className("product_sort_container"));
        WebElement dropdown = driver.findElement(sortingDropdown);
      //  dropdown.findElement(By.xpath("//option[text()='" + optionText + "']")).click();
        Select select = new Select(dropdown);
        select.selectByIndex(optionText);
    }



}
