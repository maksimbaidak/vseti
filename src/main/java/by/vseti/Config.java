package by.vseti;

import by.vseti.api.HttpClient;
import by.vseti.api.HttpClientWithProxy;
import by.vseti.ui.util.CaptchaSolver;
import by.vseti.ui.util.TwoCaptchaSolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Locale;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"by.vseti"})
public class Config {

    private WebDriver webDriver;

    @Bean
    @Scope("singleton")
    public WebDriver getWebDriver(){

        ChromeOptions chromeOptions  = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)\"");

        ChromeDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        this.webDriver = driver;
        return driver;
    }

    @Bean
    public HttpClient getHttpClient(){
        return new HttpClientWithProxy();
    }

    @Bean
    public CaptchaSolver getCaptchaSolver(){
        return new TwoCaptchaSolver("ed9c40ae3ce3049b522945eab151947a");
    }

    @Bean
    public FakeValuesService getFakeValuesService(){
        return new FakeValuesService(new Locale("en-GB"), new RandomService());
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @PreDestroy
    public void tearDown(){
        this.webDriver.quit();
    }
}
