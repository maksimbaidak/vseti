package by.vseti.domain;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private Gender gender;
    private String hashId;
    private Set<MyCookie> cookies;
}
