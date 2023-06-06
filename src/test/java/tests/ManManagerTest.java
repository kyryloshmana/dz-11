package tests;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Data;

import static org.testng.Assert.*;
import java.util.HashMap;

public class ManManagerTest {
    Data menFirst;
    Data menSecond;
    Data womanFirst;
    Data womanSecond;

    private MenManager menManager;
    private Men men;

    @BeforeMethod
    public void setUp(){
        menFirst = Data.MAN1;
        menSecond = Data.MAN2;
        womanFirst = Data.WOMAN1;
        womanSecond = Data.WOMAN2;

        menManager = new MenManager();
        UniqueId uniqueId = new UniqueId();
        men = new Men(uniqueId, menFirst.getFirstName(),menFirst.getLastName(),menFirst.getAge());
        menManager.addMan(men);
        }

    @Test(description = "Створення чоловіка")
    public void addManTest(){
        HashMap<Integer, Men> man = menManager.getMens();
        Assert.assertEquals(menFirst.getFirstName(), man.get(men.getId()).getFirstName());
        Assert.assertEquals(menFirst.getLastName(), man.get(men.getId()).getLastName());
        Assert.assertEquals(menFirst.getAge(), man.get(men.getId()).getAge());
    }
    @Test(description = "Отримання чоловіка")
    public void getManTest(){
        addManTest();
        Assert.assertEquals(men,menManager.getMan(men.getId()));

    }
    @Test(description = "Видалення чоловіка")
    public void removeManTest(){
        addManTest();
        Men removeMan = menManager.removeMan(men.getId());
        Assert.assertEquals(men, removeMan);

        HashMap<Integer, Men> mens = menManager.getMens();
        assertEquals(0, mens.size());
    }

}
