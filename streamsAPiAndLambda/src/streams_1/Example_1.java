package streams_1;

import java.util.List;
import java.util.stream.Stream;

//Source, intermediate & Terminal Operation()
public class Example_1 {
    public static void main(String[] args) {
//        List<Integer> integers = List.of(1,2,3,4,5,6,7,8);
//        integers.stream()
//                .filter(n -> n % 2 == 0)
//                .map(n -> n * 2)
//                .limit(3)
//                .forEach(x -> System.out.println(x));

//        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
//        names.stream()
//                .filter(s -> s.startsWith("A"))
//                .map(String::toUpperCase)
//                .forEach( System.out::println);

//        Stream<Integer> stream = Stream.iterate(1, i -> i <= 10, i -> ++i);
//        stream.limit(10)
//                .forEach(System.out::println);


        List<Integer> integers = List.of(1,2,3,4,5,6,7,8);
        System.out.println(
                integers.stream()
                        .allMatch(x -> x==5));
    }
}
