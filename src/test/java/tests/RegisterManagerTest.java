package tests;
import family.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.*;

import java.util.HashMap;

public class RegisterManagerTest {

    private RegisterManager registerManager;
    private MenManager menManager;
    private WomanManager womanManager;
    private Men man, manAnother;
    private Woman woman, womanAnother;

    @BeforeMethod
    public void setUp() {

        menManager = new MenManager();
        womanManager = new WomanManager();
        registerManager = new RegisterManager();
        UniqueId uniqueId = new UniqueId();
        man = new Men(uniqueId, "Johnny", "Deep", 55);
        manAnother = new Men(uniqueId, "Brad", "Pitt", 66);
        woman = new Woman(uniqueId, "Margot", "Robby", 32);
        womanAnother = new Woman(uniqueId, "Angelina", "Jolie", 77);
    }

    @Test (description = "Додавання чоловіка до списку одружених")
    public void testAddManToMeritedMap() {
        menManager.addManToMeritedMap(man);
        assertEquals(man, menManager.getMeritedMan(man.getId()));
    }

    @Test (description = "Додавання жінки до списку заміжніх")
    public void testAddWomanToMeritedMap() {
        womanManager.addWomanToMeritedMap(woman);
        assertEquals(woman, womanManager.getMeritedWoman(woman.getId()));

    }

    @Test (description = "Видалення чоловіка зі списку одружених")
    public void testRemoveManToMeritedMap() {
        testAddManToMeritedMap();
        Men removeMan = menManager.removeManFromMeritedMap(man.getId());
        assertEquals(man, removeMan);

        HashMap<Integer, Men> mens = menManager.getMeritedMens();
        assertEquals(0, mens.size());
    }

    @Test (description = "Видалення жінки зі списку заміжніх")
    public void testRemoveWomanToMeritedMap() {
        testAddWomanToMeritedMap();
        Woman removeWoman = womanManager.removeWomanFromMeritedMap(woman.getId());
        assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getMeritedWomen();
        assertEquals(0, women.size());
    }

    @Test (description = "Отримати одружених чоловіків")
    public void testGetMeritedMens() {
        menManager.addManToMeritedMap(man);
        menManager.addManToMeritedMap(manAnother);

        HashMap<Integer, Men> meritedMens = menManager.getMeritedMens();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(man, meritedMens.get(man.getId()));
        softAssert.assertEquals(manAnother, meritedMens.get(manAnother.getId()));
        softAssert.assertAll();
    }

    @Test(description = "Отримати заміжніх жінок")
    public void testGetMeritedWoman() {
        womanManager.addWomanToMeritedMap(woman);
        womanManager.addWomanToMeritedMap(womanAnother);

        HashMap<Integer, Woman> meritedWomen = womanManager.getMeritedWomen();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(woman, meritedWomen.get(woman.getId()));
        softAssert.assertEquals(womanAnother, meritedWomen.get(womanAnother.getId()));
        softAssert.assertAll();
    }

    @Test (description = "Створення сім'ї")
    public void testCreateFamily(){
        registerManager.createFamily(man,woman);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(man, registerManager.getMan(woman));
        softAssert.assertEquals(woman, registerManager.getWoman(man));
        softAssert.assertAll();
    }

    @Test(description = "Розлучити сім'ю")
    public void testRemoveFamily(){
        testCreateFamily();
        registerManager.removeFamily(man,woman);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNull(registerManager.getMan(woman));
        softAssert.assertNull(registerManager.getWoman(man));
        softAssert.assertAll();
    }

    @Test(description = "Створення декількох сімей")
    public void testCreateMultipleFamilies(){
        registerManager.createFamily(man,woman);
        registerManager.createFamily(manAnother,womanAnother);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(man, registerManager.getMan(woman));
        softAssert.assertEquals(woman, registerManager.getWoman(man));
        softAssert.assertEquals(manAnother, registerManager.getMan(womanAnother));
        softAssert.assertEquals(womanAnother, registerManager.getWoman(manAnother));
        softAssert.assertAll();
    }
    @Test(description = "Видалення неіснуючої сім'ї")
    public void testRemoveNotExistingFamily(){
        registerManager.createFamily(man,woman);
        registerManager.removeFamily(manAnother, womanAnother);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(man, registerManager.getMan(woman));
        softAssert.assertEquals(woman, registerManager.getWoman(man));
        softAssert.assertNull(registerManager.getMan(womanAnother));
        softAssert.assertNull(registerManager.getWoman(manAnother));
        softAssert.assertAll();
    }


}

