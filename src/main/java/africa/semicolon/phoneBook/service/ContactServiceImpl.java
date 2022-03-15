package africa.semicolon.phoneBook.service;

import africa.semicolon.phoneBook.data.dto.FindContactResponse;
import africa.semicolon.phoneBook.data.dto.RegisterContactRequest;
import africa.semicolon.phoneBook.data.dto.RegisterContactResponse;
import africa.semicolon.phoneBook.data.model.Contact;
import africa.semicolon.phoneBook.data.repository.ContactRepository;
import africa.semicolon.phoneBook.data.repository.ContactRepositoryImpl;
import africa.semicolon.phoneBook.exception.RegisterFailureException;

public class ContactServiceImpl implements ContactService{
private final ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public RegisterContactResponse register(RegisterContactRequest registerForm) {
        registerForm.setFirstName(registerForm.getFirstName().toLowerCase());
        registerForm.setLastName(registerForm.getLastName().toLowerCase());
        registerForm.setMobile(registerForm.getMobile());

        if(contactExist(registerForm.getMobile())) throw  new RegisterFailureException("phoneNumber already exist");
        Contact contact = new Contact(registerForm.getFirstName(),registerForm.getLastName(),registerForm.getMobile());

//        contactRepository.save(contact);

        Contact savedContact = contactRepository.save(contact);

        RegisterContactResponse response = new RegisterContactResponse();
        response.setFullName((savedContact.getFirstName()+" "+savedContact.getLastName()));
        response.setMobile(savedContact.getMobile());
        response.setMobile(savedContact.getFirstName());


return response;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindContactResponse findUserByPhoneNumber(String mobile) {
        Contact contact = contactRepository.searchContactByPhoneNumber(mobile);
        //create response
        if(contact==null)throw new IllegalArgumentException(mobile+"customerNotFound");
        FindContactResponse response = new FindContactResponse();
        response.setMobile(contact.getMobile());
        response.setFullName(contact.getFirstName()+" "+contact.getLastName());
        response.setFirstName(contact.getFirstName());
        return response;
    }

    @Override
    public FindContactResponse findUserByFirstName(String firstName) {
      Contact contact = contactRepository.searchContact(firstName);
      //create response
        if(contact==null) throw new IllegalArgumentException("contactNotFound");
        FindContactResponse response = new FindContactResponse();
        response.setFirstName(contact.getFirstName());
        response.setMobile(contact.getMobile());
        System.out.println(response);
        return response;

    }

    private boolean contactExist(String phoneNumber) {
        Contact contact = contactRepository.searchContactByPhoneNumber(phoneNumber);
        return contact != null;


    }
}
