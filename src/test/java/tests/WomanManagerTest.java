package tests;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;
import java.util.HashMap;

public class WomanManagerTest {

    private WomanManager womanManager;
    private Woman woman;
    private Woman womanAnother;

    @BeforeMethod
    public void setUp(){
        womanManager = new WomanManager();
        UniqueId uniqueId = new UniqueId();
        woman = new Woman(uniqueId, "Margot", "Robby", 32);
        womanAnother = new Woman(uniqueId, "Angelina", "Jolie",77);
        womanManager.addWoman(woman);
    }

    @Test (description = "Перевірка створеної жінку")
    public void addWomanTest(){
        HashMap<Integer, Woman> women = womanManager.getWomen();
        assertEquals(woman, women.get(woman.getId()));

    }

    @Test(description = "Видалення жінки")
    public void removeWomanTest(){
        addWomanTest();
        Woman removeWoman = womanManager.removeWoman(woman.getId());
        assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getWomen();
        assertEquals(0, women.size());
    }

    @Test(description = "Перевірка пенсійного року у жінок")
    public void getIsRedirectWoman(){
        assertFalse(woman.isRetired(woman.getAge()));
        woman.setAge(womanAnother.getAge());
        assertTrue(woman.isRetired(woman.getAge()));
    }
}
