public class Bike {
        private int levels;
        private String name;

        public Bike(int levels, String name){
                this.setLevels(levels);
                this.setName(name);
        }

        /**
         * @return the levels
         */
        public int getLevels() {
                return levels;
        }

        /**
         * @param levels the levels to set
         */
        public void setLevels(int levels) {
                if ((levels > 18) || (levels < 0)) {
                        System.out.println("level cannot be set to " + levels + ". So it remains as " + this.levels);
                } else {
                        this.levels = levels;
                }
        }

        /**
         * @return the name
         */
        public String getName() {
                return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
                this.name = name;
        }
}
