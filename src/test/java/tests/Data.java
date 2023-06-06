package tests;

public enum Data {
   MAN1("Johnny", "Deep", 55),
   MAN2("Brad", "Pitt", 66),
   WOMAN1("Margot", "Robby", 32),
   WOMAN2("Angelina", "Jolie", 77);

    private final String firstName;
    private final String lastName;
    private final Integer age;

    Data(String firstNameMan, String lastName, Integer age) {
        this.firstName = firstNameMan;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
