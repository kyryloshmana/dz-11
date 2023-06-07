package tests;

import family.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreatePersonsTest {
    private Person person;
    private Person personAnother;
    UniqueId uniqueId;

    @BeforeMethod
    public void setUp() {
        uniqueId = new UniqueId();
        person = new Men(uniqueId, "Johnny", "Depp", 55);
        personAnother = new Woman(uniqueId, "Margot", "Robby", 77);
       }

    @Test (description = "Перевірка отриманих даних створеного особи")
    public void getPersonData(){
        assertEquals("Johnny", person.getFirstName());
        assertEquals("Depp", person.getLastName());
        assertEquals(55, person.getAge());
        }

    @Test (description = "Перевірка перезапису даних особи")
    public void setPersonData(){
        person.setFirstName(personAnother.getFirstName());
        person.setLastName(personAnother.getLastName());
        person.setAge(personAnother.getAge());

        assertEquals(person.getFirstName(), personAnother.getFirstName());
        assertEquals(person.getLastName(), personAnother.getLastName());
        assertEquals(person.getAge(), personAnother.getAge());
    }

}
