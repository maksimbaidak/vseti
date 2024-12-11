package by.vseti.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Proxy {

    private String address;
    private int port;
    private String login;
    private String password;
}
