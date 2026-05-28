import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,6,15,1);
        List<Integer> sorted = nums.stream()
        .sorted((a,b) -> b-a)
        .collect(Collectors.toList());
        System.out.println(sorted);

        Stream.of("a","b","c")
        .sorted()
        .forEach(System.out::print);

        List<Integer> nums1 = Arrays.asList(1,2,3,4);
        int sum = nums1.stream()
        .reduce(2,(a,b) -> a +b);
        System.out.println(sum);

        List<Integer> nums2 = Arrays.asList();
        int result = nums2.stream()
        .filter(n -> n > 3)
        .findFirst()
        .orElse(-1);
        System.out.println(result);

        
        
    }
}
