package by.vseti.api.posts;

public class NewPostRequestParameters {

    static final String URL = "https://vseti.by/requests.php";

    static final String RAW_QUERY_PARAMETERS = "f:posts\n" +
                                                "s:insert_new_post";

    static final String RAW_HEADERS = "Accept:*/*\n" +
            "Accept-Language:ru-BY,ru;q=0.9,en-US;q=0.8,en;q=0.7,ru-RU;q=0.6,bg;q=0.5,uk;q=0.4\n" +
            "Connection:keep-alive\n" +
            "Content-Type:application/x-www-form-urlencoded; charset=UTF-8\n" +
            //"Cookie:PHPSESSID=cb897fb068f81976aad3fbd4d9abf3ec; mode=day; src=1; _ga=GA1.1.1895525521.1732103963; _ym_uid=173210396345466205; _ym_d=1732103963; cookieconsent_status=dismiss; post_privacy=0; user_id=72da35daef5892f37387fa3a6a15a6fb768463512feca5e0f9309447da66c16ba64dae82314317178808eda0dd3dec4e4df50499f2fc75e8; _ym_visorc=w; memory=1; _ym_isad=2; ad-con=%7B%26quot%3Bdate%26quot%3B%3A%26quot%3B2024-12-12%26quot%3B%2C%26quot%3Bads%26quot%3B%3A%7B%26quot%3B4%26quot%3B%3A%26quot%3B4%26quot%3B%7D%7D; _us=1734086954; _ga_EPHZDJW7WQ=GS1.1.1734000536.43.1.1734000557.0.0.0\n" +
            "Origin:https://vseti.by\n" +
            "Referer:https://vseti.by/maksimbaidak\n" +
            "Sec-Fetch-Dest:empty\n" +
            "Sec-Fetch-Mode:cors\n" +
            "Sec-Fetch-Site:same-origin\n" +
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36\n" +
            "X-Requested-With:XMLHttpRequest\n" +
            "sec-ch-ua:\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"\n" +
            "sec-ch-ua-mobile:?0\n" +
            "sec-ch-ua-platform:\"Windows\"";
}
