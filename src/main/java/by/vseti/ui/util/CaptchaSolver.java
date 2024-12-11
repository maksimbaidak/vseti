package by.vseti.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CaptchaSolver {

    @Autowired private WebDriver webDriver;

    public CaptchaSolver(String apiKey){}

    public void solveGCaptcha(){
        String siteKey =
                webDriver.findElement(By.xpath("//*[@id=\"register\"]/div[2]/div"))
                        .getAttribute("data-sitekey");

        String solution = handleGCaptcha(siteKey, webDriver.getCurrentUrl());

        WebElement textArea = webDriver.findElement(By.xpath("//*[@id=\"g-recaptcha-response\"]"));
        ((JavascriptExecutor)webDriver)
                .executeScript(
                        "arguments[0].setAttribute('style', 'width: 250px; height: 40px; border: 1px solid rgb(193, 193, 193); margin: 10px 25px; padding: 0px; resize: none;')",
                        textArea);
        textArea.sendKeys(solution);
    }

    protected abstract String handleGCaptcha(String siteKey, String url);
}
