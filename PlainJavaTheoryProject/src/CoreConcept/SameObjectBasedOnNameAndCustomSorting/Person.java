package CoreConcept.SameObjectBasedOnNameAndCustomSorting;

import java.util.Objects;

// it Must implement "Comparable" to do Custom Sorting while doing "Collections.sort(list);"
public class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Override equals() to compare based on 'name'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    // it Must implement "Comparable" to do Custom Sorting while doing "Collections.sort(list);"
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);  // Sort by name
    }

    // Override hashCode() to match equals()
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
