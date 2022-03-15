package africa.semicolon.phoneBook.service;

import africa.semicolon.phoneBook.data.dto.FindContactResponse;
import africa.semicolon.phoneBook.data.dto.RegisterContactRequest;
import africa.semicolon.phoneBook.data.dto.RegisterContactResponse;
import africa.semicolon.phoneBook.exception.RegisterFailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
ContactService contactService;
    @BeforeEach
    void setUp() {
        contactService = new ContactServiceImpl();
    }
    @Test
    void testThatContactCanBeAddedToRepository(){
        //given
        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("williams");
        registerForm.setLastName("Dean");
        registerForm.setMobile("098674567");

        //when
        contactService.register(registerForm);
        assertEquals(1,contactService.getRepository().count());

    }
//    @Test
//    void duplicateNumber_throwExceptionTest(){
//        createRegisterForm();
//
//        assertThrows(RegisterFailureException.class, ()-> createRegisterForm());
//    }
    private RegisterContactRequest createRegisterForm(){
        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("williams");
        registerForm.setLastName("Dean");
        registerForm.setMobile("098674567");

        //when
        contactService.register(registerForm);
      return registerForm;
    }
    @Test
    void registrationReturnsCorrectResponseTest(){
        RegisterContactRequest entryForm = createRegisterForm();
//        contactService.register(entryForm);
        RegisterContactResponse response =contactService.register(entryForm);
        assertEquals("williams dean",response.getFullName());
        assertEquals("098674567",response.getMobile());

    }
    @Test
    void findRegisteredContactByPhoneNumberTest(){
        RegisterContactRequest entryForm = createRegisterForm();
         contactService.register(entryForm);

         FindContactResponse response = contactService.findUserByPhoneNumber(entryForm.getMobile());

         assertEquals("williams dean",response.getFullName());
         assertEquals("098674567",response.getMobile());

    }
    @Test
    void findContactByFirstNameTest(){
        RegisterContactRequest entryForm = createRegisterForm();
        contactService.register(entryForm);

        FindContactResponse response = contactService.findUserByFirstName(entryForm.getFirstName());
        assertEquals("williams",response.getFirstName());
        assertEquals("098674567",response.getMobile());
    }



}