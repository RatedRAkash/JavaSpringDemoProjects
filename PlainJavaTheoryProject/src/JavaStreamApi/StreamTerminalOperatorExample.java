package JavaStreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperatorExample {

    public static void main(String[] args) {
        //List of Terminal Functions are:
                //        collect()
                //        reduce()
                //        anyMatch()
                //        allMatch()
                //        noneMatch()
                //        count()
                //        findAny()
                //        findFirst()
                //        forEach()
                //        min()
                //        max()
                //        toArray()

        //1) .collect(Collectors.toList()) ---> Stream Object theke "List" ee Convert Back kore dey
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 6, 11, 15, 18, 22, 51, 55, 58);
        List<Integer> filteredList = numberList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        //2) .reduce() ---> reduce all elements in the stream to a single element.
        List<String> fruitList = Arrays.asList("apple", "banana", "orange");
        Optional<String> reduced = fruitList.stream().reduce((value, combinedValue) -> {
            return combinedValue + " + " + value;
        });


        //3) . toArray() ---> starts the internal iteration of the elements in the stream and returns an array of Objects containing all the elements.
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");

        Stream<String> stream = stringList.stream();

        Object[] objects = stream.toArray();

        System.out.println(objects[0]);
        System.out.println(objects[1]);
        System.out.println(objects[2]);
        System.out.println(objects[3]);
    }
}
