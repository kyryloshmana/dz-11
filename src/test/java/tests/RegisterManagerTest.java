package tests;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Data;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class RegisterManagerTest {
    Data menFirst;
    Data menSecond;
    Data womanFirst;
    Data womanSecond;

    private RegisterManager registerManager;
    private MenManager menManager;
    private WomanManager womanManager;
    private Men man, manAnother;
    private Woman woman, womanAnother;

    @BeforeMethod
    public void setUp() {
        menFirst = Data.MAN1;
        menSecond = Data.MAN2;
        womanFirst = Data.WOMAN1;
        womanSecond = Data.WOMAN2;

        menManager = new MenManager();
        womanManager = new WomanManager();
        registerManager = new RegisterManager();
        UniqueId uniqueId = new UniqueId();
        man = new Men(uniqueId, menFirst.getFirstName(), menFirst.getLastName(), menFirst.getAge());
        manAnother = new Men(uniqueId, menSecond.getFirstName(), menSecond.getLastName(), menSecond.getAge());
        woman = new Woman(uniqueId, womanFirst.getFirstName(), womanFirst.getLastName(), womanFirst.getAge());
        womanAnother = new Woman(uniqueId, womanSecond.getFirstName(), womanSecond.getLastName(), womanSecond.getAge());
        menManager.addMan(man);
        womanManager.addWoman(woman);
    }

    @Test (description = "Додавання чоловіка до списку одружених")
    public void testAddManToMeritedMap() {

        menManager.addManToMeritedMap(man);
        Assert.assertEquals(man.getFirstName(), menManager.getMeritedMan(man.getId()).getFirstName(), "First name is incorrect");
        Assert.assertEquals(man.getLastName(), menManager.getMeritedMan(man.getId()).getLastName(), "First name is incorrect");
        Assert.assertEquals(man.getAge(), menManager.getMeritedMan(man.getId()).getAge(), "Age is incorrect");
    }

    @Test (description = "Додавання жінки до списку заміжніх")
    public void testAddWomanToMeritedMap() {
        womanManager.addWomanToMeritedMap(woman);
        Assert.assertEquals(woman.getFirstName(), womanManager.getMeritedWoman(woman.getId()).getFirstName(), "First name is incorrect");
        Assert.assertEquals(woman.getLastName(), womanManager.getMeritedWoman(woman.getId()).getLastName(), "First name is incorrect");
        Assert.assertEquals(woman.getAge(), womanManager.getMeritedWoman(woman.getId()).getAge(), "Age is incorrect");
    }

    @Test (description = "Видалення чоловіка зі списку одружених")
    public void testRemoveManToMeritedMap() {
        testAddManToMeritedMap();
        Men removeMan = menManager.removeManFromMeritedMap(man.getId());
        Assert.assertEquals(man, removeMan);

        HashMap<Integer, Men> mens = menManager.getMeritedMens();
        assertEquals(0, mens.size());
    }

    @Test (description = "Видалення жінки зі списку заміжніх")
    public void testRemoveWomanToMeritedMap() {
        testAddWomanToMeritedMap();
        Woman removeWoman = womanManager.removeWomanFromMeritedMap(woman.getId());
        Assert.assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getMeritedWomen();
        assertEquals(0, women.size());
    }

    @Test (description = "Отримати одружених чоловіків")
    public void testGetMeritedMens() {
        menManager.addManToMeritedMap(man);
        menManager.addManToMeritedMap(manAnother);

        HashMap<Integer, Men> meritedMens = menManager.getMeritedMens();

        Assert.assertEquals(man, meritedMens.get(man.getId()));
        Assert.assertEquals(manAnother, meritedMens.get(manAnother.getId()));

    }

    @Test(description = "Отримати заміжніх жінок")
    public void testGetMeritedWoman() {
        womanManager.addWomanToMeritedMap(woman);
        womanManager.addWomanToMeritedMap(womanAnother);

        HashMap<Integer, Woman> meritedWomen = womanManager.getMeritedWomen();

        Assert.assertEquals(woman, meritedWomen.get(woman.getId()));
        Assert.assertEquals(womanAnother, meritedWomen.get(womanAnother.getId()));
    }

    @Test (description = "Створення сім'ї")
    public void testCreateFamily(){
        registerManager.createFamily(man,woman);
        Assert.assertEquals(man, registerManager.getMan(woman));
        Assert.assertEquals(woman, registerManager.getWoman(man));
    }

    @Test(description = "Розлучити сім'ю")
    public void testRemoveFamily(){
        testCreateFamily();
        registerManager.removeFamily(man,woman);

        assertNull(registerManager.getMan(woman));
        assertNull(registerManager.getWoman(man));
    }

    @Test(description = "Створення декількох сімей")
    public void testCreateMultipleFamilies(){
        registerManager.createFamily(man,woman);
        registerManager.createFamily(manAnother,womanAnother);

        Assert.assertEquals(man, registerManager.getMan(woman));
        Assert.assertEquals(woman, registerManager.getWoman(man));
        Assert.assertEquals(manAnother, registerManager.getMan(womanAnother));
        Assert.assertEquals(womanAnother, registerManager.getWoman(manAnother));
    }
    @Test(description = "Видалення неіснуючої сім'ї")
    public void testRemoveNotExistingFamily(){
        registerManager.createFamily(man,woman);
        registerManager.removeFamily(manAnother, womanAnother);

        Assert.assertEquals(man, registerManager.getMan(woman));
        Assert.assertEquals(woman, registerManager.getWoman(man));

        assertNull(registerManager.getMan(womanAnother));
        assertNull(registerManager.getWoman(manAnother));
    }


}

