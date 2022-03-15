package africa.semicolon.phoneBook.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Contact")
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor // it picks specific field in an object;
public class Contact {
    @NonNull // to pick one field when required constructor
    private String firstName;
    @NonNull
    private String lastName;
    private String middleName;
    @NonNull
    private String mobile;
    private String office;
    @Id
    private String id;






}
