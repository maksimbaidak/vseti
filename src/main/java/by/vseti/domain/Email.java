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
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private boolean hasUserName;
    private boolean hasAtSymbol;
    private boolean hasDomain;
}
