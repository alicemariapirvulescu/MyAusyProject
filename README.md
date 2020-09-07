# MyAusyProject - README PIRVULESCU ALICE-MARIA 

"/api/users" mapping necesar pentru toate functiile aplicatiei

DEPARTMENT ENTITY

"/addDepartment"
Primeste un departament in forma de json, ii da un id auto incrementat 
unic si verifica ca numele departamentului sa nu fie gol.

CAZURI AFISARE MESAJE EROARE :
-in cazul in care numele este gol va aparea un mesaj cu status BAD_REQUEST

REZULTAT PENTRU INPUT OKAY: 
-departamentul este adaugat in baza de date si afisat sub forma de json


"/findAllDepartments"
Returneaza lista de departamente existenta in baza de date.

"/deleteDepartment/{id}"
Primeste un id de departament ca o variabila de cale, id pe care il cauta in 
departamente.

CAZURI AFISARE MESAJE EROARE:
- Atunci cand nu exista departamentul cu id-ul
cautat va aparea un mesaj de tip http cu status NOT_FOUND si mesajul 
"Department with this id doesn't exist" alaturi de id-ul cautat.

REZULTAT PENTRU INPUT OKAY:
-Se va sterge departamentul cu id-ul dorit.


JOB CATEGORIES:

"/addJobCategory" primeste o categorie de job in forma de json, ii da un id auto incrementat 
unic si verifica ca numele categoriei sa nu fie gol.

CAZURI AFISARE MESAJE EROARE :
-in cazul in care numele este gol va aparea un mesaj cu status NO_CONTENT

REZULTAT PENTRU INPUT OKAY: 
-Categoria de job este este adaugata in baza de date si afisat sub forma de json

"/getAllJobCategories"
Returneaza lista de categorii de job din baza de date.

"/deleteJobCategory/{id}"
Primeste un id de job category ca o variabila de cale, id pe care il cauta in 
categoriile de joburi.

CAZURI AFISARE MESAJE EROARE:
- Atunci cand nu exista categoria de job cu id-ul
cautat va aparea un mesaj de tip http cu status NOT_FOUND si mesajul 
"Job category whith this id doesn't exist " + id.

REZULTAT PENTRU INPUT OKAY:
-Se va sterge categoria de job cu id-ul dorit.




EMPLOYEES:

"/addEmployee"

"/findEmployeeById/{id}"

"/getAllEmployees"

"/addEmployee/{id_dep}/{id_job}"

"/deleteEmployee/{id}"

"/getEmployeeByDepartment/{id}"

"/getEmployeeByDepAndJob/{id_dep}/{id_job}"

"/updateEmployee/{id}/{id_dep}/{id_job}"

"/getAllEmployeesDto"

"/getAllManagersDto"

"/getAllActiveDto"

"/getAllOrderByFirstName/asc"

"/getAllOrderByFirstName/desc"

"/getAllOrderBySalary/asc"

"/getAllOrderBySalary/desc"
