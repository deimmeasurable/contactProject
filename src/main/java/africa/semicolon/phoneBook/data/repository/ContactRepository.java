package africa.semicolon.phoneBook.data.repository;

import africa.semicolon.phoneBook.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact,String> {
    Contact save(Contact contact);

//    int count();
//
//
//    void delete(Contact contact);
//
//    Contact searchContact(String firstName);
//
//    Contact searchContactByPhoneNumber(String PhoneNumber);
//
//    void deleteByMobile(String phoneNumber);
}
