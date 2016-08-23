import java.util.*;
import java.util.LinkedList;

public class ConverterListToArray {
        public static void main(String[] args) {
                String[] stuff = {"babies", "watermelon", "melons", "fudge"};
                LinkedList<String> thelist = new LinkedList<String>(Arrays.asList(stuff));

                thelist.add("ThisOneIsAdded");
                thelist.addFirst("theFIRSTthing");

                // Convert back to array
                stuff = thelist.toArray(new String[thelist.size()]);

                for (String x : stuff) {
                        System.out.printf("%s, ", x);
                }
        }
}
