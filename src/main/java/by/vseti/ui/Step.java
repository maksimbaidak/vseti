package by.vseti.ui;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

@Slf4j
public abstract class Step {

    public static Consumer await(Integer sec){
        return o -> {
            try {
                Thread.sleep(sec*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Consumer logInfo(String str){
        return o -> log.info(str);
    }

    public static Consumer logDebug(String str){
        return o -> log.info(str);
    }
}
