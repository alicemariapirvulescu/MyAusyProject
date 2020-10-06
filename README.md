# MyAusyProject - README PIRVULESCU ALICE-MARIA 

# Employees Management
>
This project is an application that it is supposed to offer a solution for managing the employees of a company that are organised in departments and job categories. Using Docker I created a container that holds a data base of type PostgreSQL and I implemented the CRUD (Create, Read, Update, Delete) operations in Spring Boot, as for testing I chose to use Postman. I made a lot of practical situation that my project would be helpful as listing all active employees to reach out to them for a meeting or all managers, updating the department or job of an employee and also I made a DTO model as when there are public lists to avoid posting confidential info. Also, all the errors are displayed for example if the date of birth of am employee is before the 1900 or the format is wrong it will display a specific message. For this project I also used the JPA concepts with Hibernate and SQL for testing and working with the data.
<hr>

HOW TO USE MY EMPLOYEES SPRING APPLICATION: You should choose any of those paths

"/ api / users" mapping required for all application functions

ENTITY DEPARTMENT

"/ addDepartment" Receives a json-shaped department, gives it a unique incremental car id (primary key for departments), and verifies that the department name is not empty.

CASES OF DISPLAYING ERROR MESSAGES: -if the name is empty a message with BAD_REQUEST status will appear

RESULT FOR INPUT OKAY: -department is added to the database and displayed as json

"/ findAllDepartments" Returns the list of existing departments in the database.

"/ deleteDepartment / {id}" Receives a department id as a path variable, an id it searches for in departments.

CASES OF DISPLAYING ERROR MESSAGES:

When the department with the searched id does not exist, an http message with the status NOT_FOUND will appear and the message "Department with this id doesn't exist" will appear next to the searched id.
RESULT FOR OKAY INPUT: -The department with the desired id will be deleted.

JOB CATEGORIES:

"/ addJobCategory" receives a job category in the form of a json, gives it a unique incremental auto id (primary key for jobs) and checks that the category name is not empty.

CASES OF DISPLAYING ERROR MESSAGES: -if the name is empty a message with NO_CONTENT status will appear

RESULT FOR OKAY INPUT: -The job category is added to the database and displayed as json

"/ getAllJobCategories" Returns the list of job categories in the database.

"/ deleteJobCategory / {id}" Gets a job category id as a path variable, an id it looks for in job categories.

CASES OF DISPLAYING ERROR MESSAGES:

When there is no job category with the searched id, an http message with the status NOT_FOUND will appear and the message "Job category whith this id doesn't exist" + id.
RESULT FOR OKAY INPUT: -The job category will be deleted with the desired id.

EMPLOYEES:

"/ AddEmployee" receives an employee in the form of a json with next fields: id(auto incremented, primary ley), firstName, lastName, jobCategoryId(Foregin key), departmentId(Foregin key), an boolean isManager, startDate and EndDate, birthday (all dates), active (boolean), address, CP, telephone, email, noChildren, salary(double), studies(text), socialSecurityNumber and hasDrivingLicense(boolean).

"/ FindEmployeeById / {id}" returns the 

"/ GetAllEmployees"

"/ AddEmployee / {id_dep} / {id_job}" adds the employee in form of a json and sets the department and id_job. If the id_dep or id_job can't be found it displays a specific message.

"/ DeleteEmployee / {id}"

"/ GetEmployeeByDepartment / {id}"

"/ GetEmployeeByDepAndJob / {id_dep} / {id_job}"

"/ UpdateEmployee / {id} / {id_dep} / {id_job}"

"/ GetAllEmployeesDto"

"/ GetAllManagersDto"

"/ GetAllActiveDto"

"/ GetAllOrderByFirstName / asc"

"/ GetAllOrderByFirstName / desc"

"/ GetAllOrderBySalary / asc"

"/ GetAllOrderBySalary / desc"
