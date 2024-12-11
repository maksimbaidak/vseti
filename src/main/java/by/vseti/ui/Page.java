package by.vseti.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

public abstract class Page<T> {

    @Autowired protected WebDriver webDriver;

    protected abstract T getThisCls();

    public T appendAction(Consumer c){
        c.accept(c);
        return getThisCls();
    }

    protected WebElement findByXpath(String xPath){
        return webDriver.findElement(By.xpath(xPath));
    }
}
