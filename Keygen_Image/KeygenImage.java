import java.util.*;

public class KeygenImage {
public static void main(String[] args){
        String upper = "-----------------";
        String[] bullShit = {"!", "@", "#", "$", "%", "&", "*"};
        Random random = new Random();
        int forindex;
        int charindex;

        for (int i = 0; i <= 10; i++) {
                if ((i == 0) || (i == 10)) {
                        System.out.println(upper);
                } else {
                        forindex = random.nextInt(bullShit.length);
                        System.out.print("|\t");

                        for (int j = 0; j <= forindex; j++) {
                                charindex = random.nextInt(bullShit.length);
                                System.out.print(bullShit[charindex]);
                        }
                        System.out.print("\t\t|");
                        System.out.println();
                }
        }
}
}
