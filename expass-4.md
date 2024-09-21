### Task 1

I had some problems with the Jpa Test. In the tutorial it was stated to make changes to a pom.xml file. These files are usually conatined in a maven project so I was quite confused by this. By looking deeper into the code i concluded that i needed to make changes to the [persistence.xml]() file.

```xml
        <class>no.hvl.dat250.jpa.tutorial.relationshipexample.Family</class>
        <class>no.hvl.dat250.jpa.tutorial.relationshipexample.Job</class>
        <class>no.hvl.dat250.jpa.tutorial.relationshipexample.Person</class>
```

Once this was set up i did not have issues with the JpaTest.

### Experiment 2

_Explain the used database and how/when it runs._

The database is H2 and is created when the program is run. In the persistence.xml file the line

```xml
    <property name="hibernate.hbm2ddl.auto"value="create" >
```

Shows that the database is created when the program is run, if the value was "update" then the database would be updated instead of created each time.

_Can you provide the SQL used to create the table Customer?_

```sql
CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
```
