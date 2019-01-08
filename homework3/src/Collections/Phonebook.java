package Collections;


import java.util.HashMap;


public class Phonebook {

    public static HashMap<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {


        addPhoneNumber("Ivanov", "89025475869");
        addPhoneNumber("Petrov", "89055487852");
        addPhoneNumber("Sidorov", "89512589654");


        getPhoneNumber("Ivanov");

        //System.out.println(phonebook);
    }

    public static void addPhoneNumber(String surname, String number) {
        phonebook.put(surname, number);
    }

    public static void getPhoneNumber(String surname) {
        System.out.println(phonebook.get(surname));
    }
}
