# MyAusyProject - README PIRVULESCU ALICE-MARIA 

# Employees Management
>
This project offers a solution for managing the employees of a company that is organized in departments and job categories using HTTP responses. For this application, I’ve implemented the REST operations in Spring Boot and for testing, I chose to use Postman. I’ve made a lot of practical situations as listing all active employees to reach out to them for a meeting or all managers, updating the department or job, a DTO employee model, and also intercepting and treating HTTP Errors.
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

"/ FindEmployeeById / {id}" returns the employee by Id

"/ GetAllEmployees" returns all employees

"/ AddEmployee / {id_dep} / {id_job}" adds the employee in form of a json and sets the department and id_job. If the id_dep or id_job can't be found it displays a specific message.

"/ DeleteEmployee / {id}" deletes specific employee, if id is not found lists specific error.

"/ GetEmployeeByDepartment / {id}" lists all employees of a department

"/ GetEmployeeByDepAndJob / {id_dep} / {id_job}" lists all employees with specific department and job

"/ UpdateEmployee / {id} / {id_dep} / {id_job}" updates the department and job of specific employee if id employee, job or department cannot be found displays an error with the issue.

"/ GetAllEmployeesDto" lists all employees with only the public fields.

"/ GetAllManagersDto" lists all managers with only the public fields

"/ GetAllActiveDto" lists all active employees with only the public fields

"/ GetAllOrderByFirstName / asc" lists all employees ordered by first name in ascendent order

"/ GetAllOrderByFirstName / desc" same but in descendent order

"/ GetAllOrderBySalary / asc"  lists all employees ordered by salary in ascendent order

"/ GetAllOrderBySalary / desc" same but in descendent order
