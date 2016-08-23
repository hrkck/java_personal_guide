public class Reverse_Sentence {
        public static void main(String[] args){
                reverse_sentence(args.length - 1, args);
        }

        public static int reverse_sentence(int x, String[] args){
                System.out.print(args[x] + " ");
                if (x == 0) {
                        return x;
                }
                x--;
                return senreverser(x, args);
        }
}
