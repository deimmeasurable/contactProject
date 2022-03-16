package africa.semicolon.phoneBook.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    public boolean isSuccessFul;
    private String message;



}
