package family;

public class UniqueId {
    static Integer getUniqueId(){
        int n = 100000;
        return (int) (Math.random() * (n + 1));
    }
}
