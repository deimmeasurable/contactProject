package africa.semicolon.phoneBook.service;

import africa.semicolon.phoneBook.data.dto.FindContactResponse;
import africa.semicolon.phoneBook.data.dto.RegisterContactRequest;
import africa.semicolon.phoneBook.data.dto.RegisterContactResponse;
import africa.semicolon.phoneBook.data.repository.ContactRepository;

public interface ContactService {

    RegisterContactResponse register(RegisterContactRequest registerForm);

    ContactRepository getRepository();

    FindContactResponse findUserByPhoneNumber(String mobile);

    FindContactResponse findUserByFirstName(String firstName);

}
