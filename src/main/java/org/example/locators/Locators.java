package org.example.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class Locators {

    public static void main(String[] args) {
        // Initialize WebDriver and open the base URL
        WebDriver driver = new ChromeDriver();
        String webBaseUrl = "https://demo.opencart.com";
        driver.get(webBaseUrl);

        // Wait for the search box to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        searchBox.sendKeys("Macbook");

        // Get and check logo visibility by ID
        WebElement logo = driver.findElement(By.id("logo"));
        boolean logoStatus = logo.isDisplayed();
        System.out.println("Logo displayed: " + logoStatus);

        // Click on the link using full link text
        driver.findElement(By.linkText("tablets")).click();

        // Click on the link using partial link text
        driver.findElement(By.partialLinkText("tab")).click();

        // Find elements by class name and print count
        List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
        System.out.println("Header links count: " + headerLinks.size());

        // Find all links (anchor tags) and print the total number of links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the page: " + links.size());

        // Close the browser
        driver.quit();
    }
}
