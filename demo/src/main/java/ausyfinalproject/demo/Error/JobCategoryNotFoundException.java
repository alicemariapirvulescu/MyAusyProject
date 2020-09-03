package ausyfinalproject.demo.Error;

public class JobCategoryNotFoundException extends RuntimeException {
        // Atentie ca e o exceptie de RunTime(unchecked) nu de compile time(checked)

        private int id;

        public JobCategoryNotFoundException (int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "No JobCategory found with id " + id;
        }
    }

