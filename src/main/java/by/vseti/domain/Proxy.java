package by.vseti.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "proxy")
public class Proxy {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String address;
    private int port;
    private String login;
    private String password;
}
