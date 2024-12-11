package by.vseti.ui.util;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TwoCaptchaSolver extends CaptchaSolver{

    private String apiKey;

    public TwoCaptchaSolver(String apiKey) {
        super(apiKey);
        this.apiKey = apiKey;
    }

    @Override
    protected String handleGCaptcha(String siteKey, String url) {
        TwoCaptcha solver = new TwoCaptcha(apiKey);
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey(siteKey);
        captcha.setUrl(url);
        captcha.setAction("verify");
        String code = null;
        do{
            try {
                solver.solve(captcha);
                code = captcha.getCode();
            } catch (Exception e) {
                log.info("Error occurred: " + e.getMessage());
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (code == null);
        return code;
    }
}
