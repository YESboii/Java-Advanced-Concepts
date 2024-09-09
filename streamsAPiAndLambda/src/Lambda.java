import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        Functionall functionall = ()-> System.out.println("smthg");
        functionall.doSmth();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer>newL =  list.stream().map(
                (e) ->  e*2
        ).collect(Collectors.toList());
        System.out.println(newL);

    }
}
@FunctionalInterface
abstract interface Functionall{

     void doSmth();
}