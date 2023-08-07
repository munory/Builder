import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected Optional<String> address = Optional.empty();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address.isPresent();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address.orElse("unknown");
    }

    public void setAddress(String address) {
        this.address = Optional.of(address);
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        } else {
            throw new IllegalStateException("age is unknown");
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname);
        // а какой должен быть заполненный возраст у ребенка?
        personBuilder.setAge(1);
        if (address.isPresent()) {
            personBuilder.setAddress(this.getAddress());
        }
        return personBuilder;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent() ? age.getAsInt() : "unknown") +
                ", address=" + address.orElse("unknown") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age.orElse(0), address.orElse(""));
    }
}
