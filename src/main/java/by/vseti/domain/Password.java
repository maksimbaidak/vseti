package by.vseti.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Password {

    private int length;
    private boolean hasUppercase;
    private boolean hasLowercase;
    private boolean hasDigitOrSymbol;
}
