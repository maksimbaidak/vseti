package by.vseti.api.login;

public class LoginRequestParameters {

    static final String URL = "https://vseti.by/requests.php";

    static final String RAW_QUERY_PARAMETERS = "f:login";

    static final String RAW_HEADERS = "Accept:application/json\n" +
            "Accept-Language:ru-BY,ru;q=0.9,en-US;q=0.8,en;q=0.7,ru-RU;q=0.6,bg;q=0.5,uk;q=0.4\n" +
            "Connection:keep-alive\n" +
            "Content-Type:application/x-www-form-urlencoded; charset=UTF-8\n" +
            "Origin:https://vseti.by\n" +
            "Referer:https://vseti.by/welcome\n" +
            "Sec-Fetch-Dest:empty\n" +
            "Sec-Fetch-Mode:cors\n" +
            "Sec-Fetch-Site:same-origin\n" +
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36\n" +
            "X-Requested-With:XMLHttpRequest\n" +
            "sec-ch-ua:\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"\n" +
            "sec-ch-ua-mobile:?0\n" +
            "sec-ch-ua-platform:\"Windows\"";
}
