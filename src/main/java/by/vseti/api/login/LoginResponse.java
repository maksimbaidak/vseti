package by.vseti.api.login;

import by.vseti.api.Response;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse implements Response {

    private int status;
    private String location;
    private String[] errors;

    public Optional<String> getError(){
        if(errors != null){
            return errors.length == 0 ? Optional.empty() : Optional.of(errors[0]);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public void setError(String string) {
        this.errors = new String[1];
        this.errors[0] = string;
    }
}
