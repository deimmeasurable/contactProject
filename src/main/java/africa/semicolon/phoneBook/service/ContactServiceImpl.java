package africa.semicolon.phoneBook.service;

import africa.semicolon.phoneBook.data.dto.FindContactResponse;
import africa.semicolon.phoneBook.data.dto.RegisterContactRequest;
import africa.semicolon.phoneBook.data.dto.RegisterContactResponse;
import africa.semicolon.phoneBook.data.model.Contact;
import africa.semicolon.phoneBook.data.repository.ContactRepository;
import africa.semicolon.phoneBook.data.repository.ContactRepositoryImpl;
import africa.semicolon.phoneBook.exception.PhoneBookException;
import africa.semicolon.phoneBook.exception.RegisterFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.Callable;
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private  ContactRepository contactRepository;

    @Override
    public RegisterContactResponse register(RegisterContactRequest registerForm) {
//        registerForm.setFirstName(registerForm.getFirstName().toLowerCase());
//        registerForm.setLastName(registerForm.getLastName().toLowerCase());
//        registerForm.setMobile(registerForm.getMobile());
        Contact contact = new Contact(registerForm.getFirstName(), registerForm.getLastName(), registerForm.getMobile());
        if (contactExist(contact.getMobile())) throw new RegisterFailureException("phoneNumber already exist");


        Contact savedContact = contactRepository.save(contact);

        RegisterContactResponse response = new RegisterContactResponse();
        response.setFullName((savedContact.getFirstName() + " " + savedContact.getLastName()));
        response.setMobile(savedContact.getMobile());
        response.setFirstName(savedContact.getFirstName());


        return response;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindContactResponse findUserByPhoneNumber(String mobile) {
        //create response
        if (contactRepository.findContactByMobile(mobile) == null) throw new PhoneBookException(mobile+ "customerNotFound");
        Contact contact = contactRepository.findContactByMobile(mobile);
        FindContactResponse response = new FindContactResponse();
        response.setMobile(contact.getMobile());
        response.setFullName(contact.getFirstName() + " " + contact.getLastName());
        response.setFirstName(contact.getFirstName());
        return response;
    }

    public FindContactResponse findUserByFirstName(String firstName) {
        Contact contact = contactRepository.findContactByFirstName(firstName);
        //create response
        if (contact == null) throw new IllegalArgumentException("contactNotFound");
        FindContactResponse response = new FindContactResponse();
        response.setFirstName(contact.getFirstName());
        response.setMobile(contact.getMobile());
        System.out.println(response);
        return response;

    }



   @Override
   public FindContactResponse DeleteByPhoneNumber(String phoneNumber) {
       //given we have a database
       Contact contact = contactRepository.findContactByMobile(phoneNumber);

       //check that a phoneNumber
       if (contact == null) throw new PhoneBookException("contact doesn't exist");
       if (contact.getMobile().equals(phoneNumber)) {
           contactRepository.delete(contact);
       }
//       if (!Objects.equals(contact.getMobile(), phoneNumber)) throw new PhoneBookException("contact doesn't exist");
       FindContactResponse response = new FindContactResponse();
       response.setMessage("Contact has been deleted");
       System.out.println(response);
       return response;

//       if (!Objects.equals(contact.getMobile(), phoneNumber)) throw new PhoneBookException("contact doesn't exist");
       }

       //if it exists delete that contact


    private boolean contactExist(String phoneNumber) {
        if (contactRepository.findContactByMobile(phoneNumber) != null) {
            System.out.println("here--->" + "contact exists");
            return true;
        }
        else return false;
    }
}



