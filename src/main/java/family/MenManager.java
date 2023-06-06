package family;

import java.util.HashMap;

public class MenManager {
    private final HashMap<Integer, Men> manManagerMap;
    private final HashMap<Integer, Men> manManagerMapAfterMerited;

    public MenManager(){
        manManagerMap = new HashMap<>();
        manManagerMapAfterMerited = new HashMap<>();
        }

    public HashMap<Integer, Men> getMens(){
        return manManagerMap;
    }
    public void addMan(Men man){
        manManagerMap.put(man.getId(), man);
    }
    public Men getMan(int id){
        return manManagerMap.get(id);
    }
    public Men removeMan(int id){
        return manManagerMap.remove(id);
    }
    //////
    public HashMap<Integer, Men> getMeritedMens(){
        return manManagerMapAfterMerited;
    }
    public Men getMeritedMan(int id){
        return manManagerMapAfterMerited.get(id);
    }
    public void addManToMeritedMap(Men man){
        manManagerMapAfterMerited.put(man.getId(), man);
    }
    public Men removeManFromMeritedMap(int id){
        return manManagerMapAfterMerited.remove(id);
    }
}
