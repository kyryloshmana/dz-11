package family;

import java.util.HashMap;

public class WomanManager {
    private final HashMap<Integer, Woman> womanManagerMap;
    private final HashMap<Integer, Woman> womanManagerMapAfterMerited;
    private final HashMap<Integer, String> womenLastNameManagerMap;

    public WomanManager(){
        womanManagerMap = new HashMap<>();
        womanManagerMapAfterMerited = new HashMap<>();
        womenLastNameManagerMap = new HashMap<>();
    }
    public HashMap<Integer, Woman> getWomen(){
        return womanManagerMap;
    }
    public void addWoman(Woman woman){
        womanManagerMap.put(woman.getId(), woman);
    }
    public Woman getWoman(int id){
        return womanManagerMap.get(id);
    }
    public Woman removeWoman(int id){
        return womanManagerMap.remove(id);
    }
    /////
    public HashMap<Integer, Woman> getMeritedWomen(){
        return womanManagerMapAfterMerited;
    }
    public Woman getMeritedWoman(int id){
        return womanManagerMapAfterMerited.get(id);
    }
    public void addWomanToMeritedMap(Woman woman){
        womanManagerMapAfterMerited.put(woman.getId(), woman);
    }
    public Woman removeWomanFromMeritedMap(int id){
        return womanManagerMapAfterMerited.remove(id);
    }

}
