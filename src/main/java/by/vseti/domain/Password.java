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
@Table(name = "password")
public class Password {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private int length;
    private boolean hasUppercase;
    private boolean hasLowercase;
    private boolean hasDigitOrSymbol;
}
