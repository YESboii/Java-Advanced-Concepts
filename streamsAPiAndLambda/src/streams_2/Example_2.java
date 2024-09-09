package streams_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example_2 {
    public static void main(String[] args) {

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );


        System.out.println(listOfLists.stream()
                .flatMap(e -> e.stream())
                        .mapToInt(e -> e)
                .sum());

//        System.out.println(listOfLists.stream().map(arr -> arr.stream().mapToInt(e -> e).sum())
//                .collect(Collectors.toList()));




    }
}
