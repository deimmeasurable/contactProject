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
    void testThatContactCanBeAddedToRepository() {
        //given
        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("williams");
        registerForm.setLastName("Dean");
        registerForm.setMobile("098674567");

        //when
        contactService.register(registerForm);
        assertEquals(1, contactService.getRepository().count());

    }

    @Test
    void duplicateNumber_throwExceptionTest() {
        createRegisterForm();

        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("williams");
        registerForm.setLastName("Dean");
        registerForm.setMobile("098674567");
        contactService.register(registerForm);
        assertThrows(RegisterFailureException.class, () -> contactService.register(registerForm));
    }

    private RegisterContactRequest createRegisterForm() {
        RegisterContactRequest registerForm = new RegisterContactRequest();
        registerForm.setFirstName("williams");
        registerForm.setLastName("Dean");
        registerForm.setMobile("098674567");

        //when
//        contactService.register(registerForm);
        return registerForm;
    }

    @Test
    void registrationReturnsCorrectResponseTest() {
        RegisterContactRequest registerForm = createRegisterForm();
//        contactService.register(entryForm);
        RegisterContactResponse response = contactService.register(registerForm);
        assertEquals("williams Dean", response.getFullName());
        assertEquals("098674567", response.getMobile());

    }

    @Test
    void findRegisteredContactByPhoneNumberTest() {
        RegisterContactRequest entryForm1 = createRegisterForm();
        entryForm1.setFirstName("John");
        entryForm1.setLastName("Doe");
        entryForm1.setMobile("0876543");
        RegisterContactResponse registerResponse = contactService.register(entryForm1);

        FindContactResponse findUserResponse = contactService.findUserByPhoneNumber(registerResponse.getMobile());

        assertEquals("John Doe", findUserResponse.getFullName());
        assertEquals("0876543", findUserResponse.getMobile());

    }

    @Test
    void findContactByFirstNameTest() {
        RegisterContactRequest entryForm = createRegisterForm();
        contactService.register(entryForm);

        FindContactResponse response = contactService.findUserByFirstName(entryForm.getFirstName());
        assertEquals("williams", response.getFirstName());
        assertEquals("098674567", response.getMobile());
    }

//    @Test
//    void DeleteByContactTest() {
//        RegisterContactRequest entryForm= createRegisterForm();
//         contactService.register(entryForm);
//
//        FindContactResponse message = contactService.DeleteByPhoneNumber("098674567");
//
//assertEquals("098674567",entryForm.getMobile());
//        assertEquals("Contact has been deleted", message.getMessage());
//
//    }
}



