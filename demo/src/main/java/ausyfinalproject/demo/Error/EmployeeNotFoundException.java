package ausyfinalproject.demo.Error;

public class EmployeeNotFoundException extends RuntimeException {
    // Atentie ca e o exceptie de RunTime(unchecked) nu de compile time(checked)

    private int id;

    public EmployeeNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "No Employee found with id " + id;
    }
}
