package africa.semicolon.phoneBook.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindContactResponse {
    private String mobile;
    private  String fullName;
    private   String firstName;
    private String message;



}
