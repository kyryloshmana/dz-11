package tests;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;
import java.util.HashMap;

public class ManManagerTest {

    private MenManager menManager;
    private Men men;
    private Men menAnother;


    @BeforeMethod
    public void setUp(){

        menManager = new MenManager();
        UniqueId uniqueId = new UniqueId();
        men = new Men(uniqueId, "Johnny","Deep",55);
        menAnother = new Men(uniqueId, "Brad","Pitt",66);
        menManager.addMan(men);
        }


    @Test(description = "Перевірка створеного чоловіка")
    public void addManTest(){
        HashMap<Integer, Men> man = menManager.getMens();
        assertEquals(men, man.get(men.getId()));

    }


    @Test(description = "Видалення чоловіка")
    public void removeManTest(){
        addManTest();
        Men removeMan = menManager.removeMan(men.getId());
        Assert.assertEquals(men, removeMan);

        HashMap<Integer, Men> mens = menManager.getMens();
        assertEquals(0, mens.size());
    }

    @Test(description = "Перевірка пенсійного року у чоловіків")
    public void getIsRedirectMan(){
        assertFalse(men.isRetired(men.getAge()));
        men.setAge(menAnother.getAge());
        assertTrue(men.isRetired(men.getAge()));
    }
}
