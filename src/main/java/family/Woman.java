package family;

public class Woman extends Person{


    public Woman(UniqueId uniqueId, String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public Boolean isRetired(int age) {
        return age > 60;
    }

}
