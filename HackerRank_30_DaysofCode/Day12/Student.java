class Student extends Person {
        private int[] testScores;

        public Student(String firstName, String lastName, int identification, int[] testScores) {
                super(firstName, lastName, identification);
                this.testScores = testScores;
        }

        String calculate(){
                int Grade = 0;
                int viceversa = 0;
                for (int i = 0; i < testScores.length; i++) {
                        viceversa += testScores[i];
                }
                Grade = viceversa / testScores.length;
                /* Keep these three lines of code for debugging:
                   System.out.println(viceversa);
                   System.out.println(testScores.length);
                   System.out.println(Grade);
                 */
                if ((Grade >= 90) && (Grade <= 100)) {
                        return "O";
                } else if ((Grade >= 80) && (Grade < 90)) {
                        return "E";
                } else if ((Grade >= 70) && (Grade < 80)) {
                        return "A";
                } else if ((Grade >= 55) && (Grade < 70)) {
                        return "P";
                } else if ((Grade >= 40) && (Grade < 55)) {
                        return "D";
                } else if (Grade < 40) {
                        return "T";
                } else {
                        return "There was an error!";
                }
        }
}
