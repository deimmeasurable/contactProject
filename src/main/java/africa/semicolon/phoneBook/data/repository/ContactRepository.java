package africa.semicolon.phoneBook.data.repository;

import africa.semicolon.phoneBook.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact,String> {
   Contact findContactByFirstNameAndAndLastName(String firstName,String lastName);
Contact findContactByMobile(String mobile);
Contact findContactByFirstName(String firstName);
Contact deleteContactByMobile(String mobile);
//    Contact save(Contact contact);
//
//    int count();
//
//
//
//
//    Contact searchContact(String firstName);
//
//    Contact searchContactByPhoneNumber(String PhoneNumber);
//
//    void deleteByMobile(String phoneNumber);
//
//    void delete(Contact contact2);
//}
}