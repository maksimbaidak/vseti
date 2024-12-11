package by.vseti.api.registration;

import by.vseti.api.Response;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse implements Response {

    private String errors;

    @Override
    public Optional<String> getError() {
        return errors == null ? Optional.empty() : Optional.of(errors);
    }
}
