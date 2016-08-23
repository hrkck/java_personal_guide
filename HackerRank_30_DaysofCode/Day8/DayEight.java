// Complete this code or write your own from scratch
import java.util.*;

class DayEight {
        public static void main(String[] argh){
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                Map<String, Integer> phoneBook = new HashMap<String, Integer>();
                for (int i = 0; i < n; i++) {
                        String name = in.next();
                        int phone = in.nextInt();
                        phoneBook.put(name, phone);
                        // Write code here
                }
                /*My debugging part:
                   System.out.println("######################");
                   System.out.println(phoneBook.values());
                 */
                while (in.hasNext()) {
                        String s = in.next();
                        if (phoneBook.get(s) == null) {
                                System.out.println("Not found");
                        } else {
                                System.out.println(s + "=" + phoneBook.get(s));
                        }
                        /* THIS WAY TAKES TOO MUCH TIME:
                         ********************************************
                           for(String test : phoneBook.keySet()){
                            if(s.equals(test)){
                                System.out.println(s + "=" + phoneBook.get(test));
                                break;
                            }else{
                                found++;
                            }
                            if(found == phoneBook.size()){
                                System.out.println("Not found");
                            }
                           }
                         ********************************************
                         */
                        // Write code here
                }
                in.close();
        }
        /*
           public static Object getKeyFromValue(Map hm, Object value) {
                for (Object o : hm.keySet()) {
                  if (hm.get(o).equals(value)) {
                    return o;
                  }
                }
                return null;
              }
         */
}
