import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList {
        public static void main(String[] args) {
                String[] things1 = {"apples", "noobs", "pinge", "bacon"};
                List<String> list1 = new ArrayList<String>();

                for (String x : things1) {
                        list1.add(x);
                }

                String[] things2 = {"sausage", "bacon", "bacon", "goats"};
                List<String> list2 = new ArrayList<String>();

                for (String y : things2) {
                        list2.add(y);
                }

                list1.addAll(list2);
                list2 = null;

                printMe(list1);
                removeStuff(list1, 2, 5);
                printMe(list1);
                reverseMe(list1);
        }

        public static void printMe(List<String> l){
                for (String x : l) {
                        System.out.printf("%s ", x);
                }
                System.out.println();
        }
        public static void removeStuff(List<String> l, int from, int to){
                l.subList(from, to).clear();
        }
        public static void reverseMe(List<String> l){
                ListIterator<String> bobby = l.listIterator(l.size());
                while (bobby.hasPrevious()) {
                        System.out.printf("%s ", bobby.previous());
                }
        }
}
