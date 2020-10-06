# MyAusyProject - README PIRVULESCU ALICE-MARIA 

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
