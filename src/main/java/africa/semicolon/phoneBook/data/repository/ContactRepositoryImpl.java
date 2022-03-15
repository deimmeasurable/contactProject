package africa.semicolon.phoneBook.data.repository;

import africa.semicolon.phoneBook.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private List<Contact> db = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        db.add(contact);
//        System.out.println(contact);
return contact;
    }

    @Override
    public int count() {
        return db.size();
    }

    @Override
    public void delete(Contact contact) {
    db.remove(contact);
    }

    @Override
    public Contact searchContact(String firstName) {
        for (Contact contact:db){
            if(firstName.equalsIgnoreCase(contact.getFirstName())){
                return contact;
            }
            else {
              throw new IllegalArgumentException("name doestN't exist ");
            }

        }

        return null;
    }

    @Override
    public Contact searchContactByPhoneNumber(String phoneNumber) {
        for (Contact contact:db) {
            if(phoneNumber.equals(contact.getMobile())){
                return contact;
            }

        }
        return null;
    }

    @Override
    public void deleteByMobile(String phoneNumber) {
        for (Contact contact:db) {
            if(phoneNumber.equals(contact.getMobile())){
                db.remove(contact);
                break;
            }

        }
    }


}
