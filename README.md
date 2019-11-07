# spring-boot-application-11-30
maven
------
building the project
dependencies(jar)
pom.xml

group id 
artifact id


package
com.companyname.projectname
com.companyname.projectname.util
com.companyname.projectname.controller

jersey(framework for develop rest full applications)
JAX rs

Jersey quickstart webapp


clean 
install

https://howtodoinjava.com/eclipse/how-to-import-maven-remote-archetype-catalogs-in-eclipse/




http://localhost:2222/sample-maven-demo/webapi/myresource

http://localhost:2222/sample-maven-demo/webapi/home


default packages(layers)
-------------------
com.trianing.sample_maven_demo.cotroller(all the endpoints)/layer
crud (create--read--update--delete)

com.trianing.sample_maven_demo.dao(database congigura)/database

com.trianing.sample_maven_demo.models(pojo classes)
Student
-----------
public class StudentModel{
private int id;

getterts(meant for reading values from properties)
setters(for setting the values to properties)


}

Student
-------
Id  Name   Address City

com.trianing.sample_maven_demo.entities(tables related to any database)


orm frameworks(object relation mapping framewroks)



com.trianing.sample_maven_demo.service/manager(business logic)
business logic

convert the pogo class object to entity related class



com.trianing.sample_maven_demo.exceptions(custom exception)
Class InvalidUsernameException extends Rutime/Exception{

}
throw new Exception("fdxghjk",2345);

throw new InvalidUsernameException("fdxghjk",2345);



12
e2
efw
ew
webapi/homefe
fe
fdxghjkef
fe

try
catch
finally
throws
throw



com.trianing.sample_maven_demo.util(mislineus)




flow
----

controller------>service/manager layer----->dao------>try to map to entities(if exists)------>db---->perform operation

controller<------service/manager layer<-----dao<------try to map to entities(if exists)<------db<----perform operation


file-->new-->maven-->maven project




http://repo1.maven.org/maven2/archetype-catalog.xml



-------------------------

service/url/edpoint/api
rest api


CRUD
C--Create ---POST
R--Read--GET
U--Update--PUT
D--Delte--DELTE

controller
------------

root path & method level path


localst:9090/myresource/1




www.xyz.com/jddsj
b ccbajbja/bkashddsd

@Path("providibg the url")

mention the type of operation

@GET/@POST/@DELETE/@PUT








GET operation(selection of data)
---------------------------------

@Path("url");
@GET
//@Consumes(type of format)
@Prodcues(mention the format)
XML/HTML/JSON/TEXT PLAIN
JSON FORMAT

eg:

Student {

name;
city;


}

map map = ne map();
map.put("key",value)

for single object-------
-------------------------
{
"city":"retdryftugyihuoji",
"nmae":"retdryftugyihuoji"
}

--------------------------------

[
{
"city":"retdryftugyihuoji",
"nmae":"retdryftugyihuoji"
},
{
"city":"retdryftugyihuoji",
"nmae":"retdryftugyihuoji"
},
{
"city":"retdryftugyihuoji",
"nmae":"retdryftugyihuoji"
}
]


for insertion of creation operation
-------------------

@Path("/registration");
@POST
@Consumes(aPPLication/JSON)
@Produces(menton the format)


------------------------------


for update of update operation
-------------------

@Path("/registration");
@PUT
@Consumes(aPPLication/JSON)
@Produces(menton the format)


for delete of delete operation
-------------------

@Path("/registration");
@DELETE
@Consumes(aPPLication/JSON)
@Produces(menton the format)


-----------------------------

browser
--------
GEt oprations
-------

https://mvnrepository.com


postman(soap ui)


GET

localhost:8888/schools/students/list

endpoint/url/api/service /controller api

output
----------
[
{
"name":"hgfj",
"city":"hyd"
},
{
"name":"hgfj",
"city":"hyd"
},
{
"name":"hgfj",
"city":"hyd"
},
{
"name":"hgfj",
"city":"hyd"
}
]


@Path("/schools/students/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsList() {

		return studentList;
	}
	
	
	-------------------------------------------------------
	
give me 5 min

spring /spring boot
m(model)(data layer/data packages)(hibernate/jpa)/jdbc/mybatis
v(view)(user interface)--html/java script/angular/react and son
c(controller)(rest full services)

tomcat(open source)

no need of external tomcat

database(mysql/oracle/mongo/cassandra)

no need of even database
(h2 database)

mvn repository


test (junit/mockito)


deployment

git

different environmnets(Si/QA/dev/UAT/Prod)


cloud servers(AWS/azure/google cloud)


swagger configuration


configuration files(profiles)


security basic authetication

composite services

producers and consumers

A--rest api a

B-----rest api b


controller---service-----dao----------entities(totall relted to db tables)-----custom exception-----models----------db
controller-----service-----dao(dummy)-----db(dummy)


spring.io



-----------------------------------------------

apis

urls for generating the project --

https://start.spring.io/

jars to be added 


Spring webapi(restful services)

h2 (database)

dev tools(automatic loading/updation of project)

spring data jpa(integrating hibernate/jpa)



------------
h2-console----> for accessing the db


security
-----------

basic authentication


APIGEE(product of google)


creation of proxoies/apigeee endpoints(network)

default use : user
password: 5b3b5d61-6bae-49f9-a682-92076e8297d5

oauth





--------------------------

swagger url

swagger-ui.html

http://localhost:1111/swagger-ui.html


Jdbc Template

Entity Manager



--------------------------------------------

Jdbc Template

---------------------------------------------
entity manager



@SqlResultSetMapping(name = "mapppinNativeQuery", // same as resultSetMapping
													// above in NativeQuery
classes = { @ConstructorResult(targetClass = com.javatraining0.application.entities.Student.class, columns = {
		@ColumnResult(name = "student_id", type = Integer.class),
		@ColumnResult(name = "student_name", type = String.class),
		@ColumnResult(name = "student_dept", type = String.class),
		@ColumnResult(name = "student_address", type = String.class)

}) })


error : no entity found/ appropriate constructor not found





---------------------
on top of class add the annotation

eg : class A{
m1(){
}
}


class ATest{

@InjectMocks
StudentService service;

@Mock
	StudentDAO studentDAO;

@Mock
dependent classes

public void m1Test(){

List<Student> students = (List<Student>) studentDAO.findAll();

List<Student> students = new ArrayList();

Mockito.when(studentDAO.findAll()).thenRetuen(students);
Mockito.when(studentDAO.findAll()).thenRetuen(students);
Mockito.when(studentDAO.findAll()).thenRetuen(students);
Mockito.when(studentDAO.findAll()).thenRetuen(students);

service.getStudents();

}


}








