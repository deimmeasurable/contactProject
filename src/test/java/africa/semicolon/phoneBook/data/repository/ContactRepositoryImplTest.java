package africa.semicolon.phoneBook.data.repository;

import africa.semicolon.phoneBook.data.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;


    @BeforeEach
    public void SetUp() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    void testThatICanSaveContact() {
        //given
        Contact contact = new Contact("tobi", "daniel", "09065432");
        //when
        contactRepository.save(contact);

        //assert
        assertEquals(1, contactRepository.count());
    }

@Test
     void testThatMoreContactCanBeUpdate(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);
    assertEquals(3,contactRepository.count());
    
}

@Test
    void testThatContactCanBeUpdated(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);

    //when we update one of the contact
    contact.setFirstName("den");
    contact.setMobile("090654732");
    contactRepository.save(contact);

assertEquals("den",contact.getFirstName());
assertEquals("090654732",contact.getMobile());
}
@Test
    void testThatContactCanBeDelete(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);

    contactRepository.delete(contact2);
    assertEquals(2,contactRepository.count());

}
@Test
void testThatContactCanBeGottenByFirstName(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);
    contact.setFirstName("den");

        Contact foundContact = contactRepository.searchContact("den");

    assertEquals("den",foundContact.getFirstName());
}
@Test()
void testThatContactCanBeGottenByLastName(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);
    contact.setMobile("090654732");
    Contact foundContactByPhoneNumber = contactRepository.searchContactByPhoneNumber("090654732");

    assertEquals("090654732",foundContactByPhoneNumber.getMobile());

}
@Test
void  testThatContactCanBeDeleteByPhoneNumber(){
    //given that we have series of contact
    Contact contact = new Contact("tobi","daniel","09065432");
    Contact contact2 = new Contact("Fish","dan","0905632412");
    Contact contact3 = new Contact("Tochi","helen","0702456");

    //when contact is saved
    contactRepository.save(contact);
    contactRepository.save(contact2);
    contactRepository.save(contact3);

    contactRepository.deleteByMobile("0905632412");
    assertEquals(2,contactRepository.count());
}



}