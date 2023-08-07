public class PersonBuilder {

    private String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("age can't be negative");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("name is null");
        }
        if (surname == null) {
            throw new IllegalStateException("surname is null");
        }

        Person person = age != null ? new Person(name, surname, age) : new Person(name, surname);

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }

}
