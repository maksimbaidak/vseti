package by.vseti.tests;

import java.util.function.Consumer;

public class Actions {

    public static Consumer await(Integer sec){
        return o -> {
            try {
                Thread.sleep(sec*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
