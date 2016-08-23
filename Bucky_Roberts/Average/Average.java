public class Average {
        public static void main(String[] args) {
                System.out.print(average(1, 2, 3));
        }

        public static int average(int...numbers){
                int total = 0;
                for (int x : numbers) {
                        total += x;
                }
                return total / numbers.length;
        }
}
