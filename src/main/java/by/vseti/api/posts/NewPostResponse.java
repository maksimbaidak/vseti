package by.vseti.api.posts;

import by.vseti.api.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostResponse implements Response {

    private int status;
    private String errors;

    public NewPostResponse(String str){
        errors = str;
    }

    @Override
    public Optional<String> getError() {
        return errors == null ? Optional.empty() : Optional.of(errors);
    }
}
