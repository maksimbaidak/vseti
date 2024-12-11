package by.vseti.api.registration;

import by.vseti.api.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse implements Response {

    private String errors;

    @Override
    public String getError() {
        return getErrors();
    }
}
