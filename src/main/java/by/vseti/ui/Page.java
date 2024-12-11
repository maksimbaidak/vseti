package by.vseti.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

public abstract class Page {

    @Autowired protected WebDriver webDriver;

    protected WebElement findByXpath(String xPath){
        return webDriver.findElement(By.xpath(xPath));
    }
}
