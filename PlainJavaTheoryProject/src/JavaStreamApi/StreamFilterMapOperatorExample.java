package JavaStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterMapOperatorExample {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 6, 11, 15, 18, 22, 51, 55, 58);
        List<Integer> filteredList = numberList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10) //.map() --> takes Java8 "Function" as an Argument, here it takes "x" as input & gives "x*10" as Output
                .collect(Collectors.toList());

        System.out.println(filteredList);
    }
}
