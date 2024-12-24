package by.vseti.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Email {

    private boolean hasUserName;
    private boolean hasAtSymbol;
    private boolean hasDomain;
}
