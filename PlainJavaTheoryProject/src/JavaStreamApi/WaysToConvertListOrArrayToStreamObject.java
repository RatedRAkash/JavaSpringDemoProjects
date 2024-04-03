package JavaStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WaysToConvertListOrArrayToStreamObject {

    public static void main(String[] args) {
        //4 ways of Converting List, Array, Hashmap to "Stream" object]

        //1. convert "List/ArrayList" object to "Stream"
        List<String> fruitList = Arrays.asList("apple", "banana", "orange");
        Stream<String> fruitStream = fruitList.stream();

        //2. convert NORMAL "array" object to "Stream"
        String[] fruitArray = {"apple", "banana", "cherry"};
        Stream<String> fruitStreamFromArray = Arrays.stream(fruitArray);

        //3. Directly pass lists of Anytype of object to convert to "Stream"
        Stream<String> nameStream = Stream.of("Akash", "Ramos", "Goku");
        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        //4. iterate like a "For Loop"
        Stream<Integer> limit = Stream.iterate(0, n->n+1).limit(100); //here, "seed" means from which value we will start to iterate, "n->n+1" --> this means how we will Generate the NEXT Object in the List & Limit Parameter defines the Limit of the Stream Size
    }
}
