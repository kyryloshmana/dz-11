package tests;

import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreatePersonsTest {
    Data menFirst;
    Data menSecond;
    Data womanFirst;
    Data womanSecond;
    private Men men;
    private Woman woman;
    UniqueId uniqueId;


    @BeforeMethod
    public void setUp() {

        menFirst = Data.MAN1;
        menSecond = Data.MAN2;
        womanFirst = Data.WOMAN1;
        womanSecond = Data.WOMAN2;

        uniqueId = new UniqueId();
        men = new Men(uniqueId, menFirst.getFirstName(), menFirst.getLastName(), menFirst.getAge());
        woman = new Woman(uniqueId, womanFirst.getFirstName(), womanFirst.getLastName(), womanFirst.getAge());


    }

    @Test (description = "Перевірка отриманих даних створеного чоловіка")
    public void getMenData(){
        Assert.assertEquals(menFirst.getFirstName(), men.getFirstName());
        Assert.assertEquals(menFirst.getLastName(), men.getLastName());
        Assert.assertEquals(menFirst.getAge(), men.getAge());
        }

    @Test (description = "Перевірка отриманих даних створеної жінки")
    public void getWomanData(){
        Assert.assertEquals(womanFirst.getFirstName(), woman.getFirstName());
        Assert.assertEquals(womanFirst.getLastName(), woman.getLastName());
        Assert.assertEquals(womanFirst.getAge(), woman.getAge());
    }
    @Test (description = "Перевірка запису нових даних чоловіка")
    public void setMenData(){
        men.setFirstName(menSecond.getFirstName());
        men.setLastName(menSecond.getLastName());
        men.setAge(menSecond.getAge());

        Assert.assertEquals(menSecond.getFirstName(), men.getFirstName());
        Assert.assertEquals(menSecond.getLastName(), men.getLastName());
        Assert.assertEquals(menSecond.getAge(), men.getAge());
    }

    @Test (description = "Перевірка запису нових даних жінки")
    public void setWomanData(){
        woman.setFirstName(womanSecond.getFirstName());
        woman.setLastName(womanSecond.getLastName());
        woman.setAge(womanSecond.getAge());

        Assert.assertEquals(womanSecond.getFirstName(), woman.getFirstName());
        Assert.assertEquals(womanSecond.getLastName(), woman.getLastName());
        Assert.assertEquals(womanSecond.getAge(), woman.getAge());
    }
    @Test(description = "Перевірка пенсійного року у жінок")
    public void getIsRedirectWoman(){
        assertFalse(woman.isRetired(woman.getAge()));
        woman.setAge(womanSecond.getAge());
        assertTrue(woman.isRetired(woman.getAge()));
    }
    @Test(description = "Перевірка пенсійного року у чоловіків")
    public void getIsRedirectMan(){
        assertFalse(men.isRetired(men.getAge()));
        men.setAge(menSecond.getAge());
        assertTrue(men.isRetired(men.getAge()));
    }
}
