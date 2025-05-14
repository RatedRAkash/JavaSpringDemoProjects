package CoreConcept.SameObjectBasedOnName;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice");
        Person p2 = new Person("Alice");

        System.out.println(p1.equals(p2));  // true

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);  // Will not be added, as p1 equals p2

        System.out.println(set.size());  // 1
    }
}
