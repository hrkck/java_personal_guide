import java.util.*;
import java.util.List;

public class SortMethods {
        public static void main(String[] args) {
                String[] crap = {"apples", "lemons", "geese", " bacon"};
                List<String> l1 = Arrays.asList(crap);

                Collections.sort(l1);
                System.out.printf("%s\n", l1);
        }
}
