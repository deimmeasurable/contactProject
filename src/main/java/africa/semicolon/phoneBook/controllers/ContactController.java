package africa.semicolon.phoneBook.controllers;


import africa.semicolon.phoneBook.data.dto.FindContactResponse;
import africa.semicolon.phoneBook.data.dto.RegisterContactRequest;
import africa.semicolon.phoneBook.data.dto.RegisterContactResponse;
import africa.semicolon.phoneBook.exception.PhoneBookException;
import africa.semicolon.phoneBook.service.ContactService;
import africa.semicolon.phoneBook.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/contact")
public class ContactController {


    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisterContactRequest request){
        try {
            return  new ResponseEntity<>(contactService.register(request),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String phoneNumber){
        try{
        return new ResponseEntity<>(contactService.findUserByPhoneNumber(phoneNumber), HttpStatus.OK);
    }catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()),HttpStatus.NOT_FOUND);
        }
        }


   @DeleteMapping("/{phoneNumber}")
    public  ResponseEntity<?> DeleteByPhoneNumber(@PathVariable String phoneNumber){
        try{
        return new ResponseEntity<>(contactService.DeleteByPhoneNumber(phoneNumber),HttpStatus.OK);
   }catch (PhoneBookException ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()),HttpStatus.NOT_FOUND);
        }
}
}