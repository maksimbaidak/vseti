package by.vseti.api.posts;

import by.vseti.api.AbstractApi;
import by.vseti.domain.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PostsApi extends AbstractApi {

    private static final String EMPTY_VALUE = "";

    public NewPostResponse createTextPost(User user, String text){
        return create(user, text, EMPTY_VALUE);
    }

    public NewPostResponse createTextPostWithColor(User user, String text){
        return create(user, text, "2");
    }

    private NewPostResponse create(User user, String text, String color){
        String body =
                        "postText=" + text +
                        "&album_name=" +
                        "&video_thumb=" +
                        "&feeling=" +
                        "&feeling_type=" +
                        "&filename=" +
                        "&answer%5B%5D=" +
                        "&answer%5B%5D=" +
                        "&postMap=" +
                        "&musiccount=" +
                        "&post_color=" + color +
                        "&postPhotos%5B%5D=" +
                        "&postVideo=" +
                        "&postFile=" +
                        "&postMusic=" +
                        "&parts=" +
                        "&hash_id=" + user.getHashId() +
                        "&postRecord=" +
                        "&postSticker=";

        Map<String,String> cookies =
                user.getCookies()
                        .stream()
                        .collect(Collectors.toMap(
                                myCookie -> myCookie.getKey(),
                                myCookie -> myCookie.getValue()));

        RequestSpecification specifications =
                new RequestSpecBuilder()
                        .setBaseUri(NewPostRequestParameters.URL)
                        .addQueryParams(parseQueryParams(NewPostRequestParameters.RAW_QUERY_PARAMETERS))
                        .addHeaders(parseHeaders(NewPostRequestParameters.RAW_HEADERS))
                        .addCookies(cookies)
                        .build();

        return (NewPostResponse)
                makeRequest(body, specifications, NewPostResponse.class);
    }
}
