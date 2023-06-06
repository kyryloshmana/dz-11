package family;

public class Men extends Person{


    public Men(UniqueId uniqueId, String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public Boolean isRetired(int age) {
        return age > 65;
    }
}
