import java.util.*;

public class Collects {
        public static void main(String[] args) {
                String[] things = {"eggs", "lasers", "hats", "pie"};
                List<String> list1 = new ArrayList<String>();


                // add array items to the list1
                for (String x : things) {
                        list1.add(x);
                }

                String[] morethings = {"hats", "lasers"};
                List<String> list2 = new ArrayList<String>();

                // add array items to the list2
                for (String y : morethings) {
                        list2.add(y);
                }

                for (int i = 0; i < list1.size(); i++) {
                        System.out.printf("%s ", list1.get(i));
                }

                editlist(list1, list2);
                System.out.println();

                for (int i = 0; i < list2.size(); i++) {
                        System.out.printf("%s ", list2.get(i));
                }
        }

        public static void editlist(Collection<String> l1, Collection<String> l2){
                Iterator<String> it = l1.iterator();
                while (it.hasNext()) {
                        if (l2.contains(it.next())) {
                                it.remove();
                        }
                }
        }
}
