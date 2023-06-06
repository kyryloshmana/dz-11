package tests;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Data;

import static org.testng.Assert.*;
import java.util.HashMap;

public class WomanManagerTest {
    Data menFirst;
    Data menSecond;
    Data womanFirst;
    Data womanSecond;

    private WomanManager womanManager;
    private Woman woman;

    @BeforeMethod
    public void setUp(){
        menFirst = Data.MAN1;
        menSecond = Data.MAN2;
        womanFirst = Data.WOMAN1;
        womanSecond = Data.WOMAN2;

        womanManager = new WomanManager();
        UniqueId uniqueId = new UniqueId();
        woman = new Woman(uniqueId, womanFirst.getFirstName(), womanFirst.getLastName(), womanFirst.getAge());
        womanManager.addWoman(woman);
    }
    @Test (description = "Додавання жінки")
    public void addWomanTest(){
        HashMap<Integer, Woman> women = womanManager.getWomen();
        Assert.assertEquals(womanFirst.getFirstName(), women.get(woman.getId()).getFirstName());
        Assert.assertEquals(womanFirst.getLastName(), women.get(woman.getId()).getLastName());
        Assert.assertEquals(womanFirst.getAge(), women.get(woman.getId()).getAge());
    }
    @Test(description = "Отримання жінки")
    public void getWomanTest(){
        addWomanTest();
        Assert.assertEquals(woman, womanManager.getWoman(woman.getId()));
    }
    @Test(description = "Видалення жінки")
    public void removeWomanTest(){
        addWomanTest();
        Woman removeWoman = womanManager.removeWoman(woman.getId());
        Assert.assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getWomen();
        assertEquals(0, women.size());
    }

}
