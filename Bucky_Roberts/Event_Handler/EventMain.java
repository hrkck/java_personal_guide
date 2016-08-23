import javax.swing.JFrame;

class EventMain {
        public static void main(String[] args){
                event1 thing = new event1();
                thing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thing.setSize(350, 100);
                thing.setVisible(true);
        }
}
