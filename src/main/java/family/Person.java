package family;

public abstract class Person {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  int age;

    public Person(String firstName, String lastName, int age) {
        this.id= UniqueId.getUniqueId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public abstract Boolean isRetired(int age);

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    }
