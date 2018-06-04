import java.util.*;
import java.io.*;

public class BinaryConverter {
        public static void main(String[] args) {
                int number = 10;
                int b = integerToBinary(number);
                System.out.println(b);
        }

        public static int integerToBinary(int number){
                int remainder = 0;
                int numberAfterDivided = number;
                int binaryNumber = 0;
                ArrayList<Integer> arrayOfBinary = new ArrayList<Integer>();

                while (numberAfterDivided > 0) {
                        remainder = number % 2;
                        numberAfterDivided = number / 2;
                        arrayOfBinary.add(remainder);
                }
                int j = 0;
                for (int i = arrayOfBinary.size() - 1; i >= 0; i--) {
                        binaryNumber = 10 * j + arrayOfBinary.get(i);
                        j++;
                }

                return binaryNumber;
        }
}
