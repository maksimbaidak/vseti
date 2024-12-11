package by.vseti.api.login;

import by.vseti.api.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponce implements Response {

    private int status;
    private String location;
    private String[] errors;

    public LoginResponce(String str){
        this.errors[0] = str;
    }

    public String getError(){
        return errors.length == 0 ? "" : errors[0];
    }
}
