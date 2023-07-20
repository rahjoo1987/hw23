package command;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonCommand extends BaseCommand{
    String FirstName;
    String lastName;
    String nationalCode;
    String mobileNumber;
    String userName;
    String password;

}
