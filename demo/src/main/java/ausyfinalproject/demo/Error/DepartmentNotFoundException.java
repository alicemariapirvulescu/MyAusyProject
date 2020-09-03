package ausyfinalproject.demo.Error;

public class DepartmentNotFoundException extends RuntimeException {
        // Atentie ca e o exceptie de RunTime(unchecked) nu de compile time(checked)

        private int id;

        public DepartmentNotFoundException(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "No Department found with id " + id;
        }
    }

