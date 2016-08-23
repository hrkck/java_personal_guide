import java.util.Random;


public class FrequencyCounter {
        public static void main(String[] args) {
                Random rand = new Random();
                int freq[] = new int[10];

                for (int i = 0; i < 1000; i++) {
                        freq[rand.nextInt(10)]++;
                }

                System.out.println("Indexes\tValues");

                for (int x = 0; x < 10; x++) {
                        System.out.println(x + "\t" + freq[x]);
                }
        }
}
