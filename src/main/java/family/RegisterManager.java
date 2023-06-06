package family;

import java.util.HashMap;

public class RegisterManager {
    private final HashMap<Men,Woman> registerManager;
    public RegisterManager(){
        registerManager = new HashMap<>();
    }

    public void createFamily(Men men, Woman woman){
        registerManager.put(men,woman);
    }

    public void removeFamily(Men men, Woman woman){
        registerManager.remove(men,woman);
    }

    public Men getMan(Woman woman) {
        for (Men man : registerManager.keySet()) {
            if (registerManager.get(man).equals(woman)) {
                return man;
            }
        }
        return null; // якщо не знайдено чоловіка для даної жінки
    }

    public Woman getWoman(Men man) {
        return registerManager.get(man);
    }
}
