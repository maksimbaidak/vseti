package by.vseti.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String hashId;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @ElementCollection
    @CollectionTable(name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    private Map<String, String> cookiesMap;
}
