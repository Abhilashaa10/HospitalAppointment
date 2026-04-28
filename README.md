PHASE 1
 1. run directly from button 
 2.http://localhost:8080/appointments/save-test
 3.http://localhost:8080/h2-console    ----- use JDBC URL: jdbc:h2:mem:testdb ------- connect
 4. mvn clean install
mvn spring-boot:run 
   
Phase 2 
Create done
1. Postman sends JSON
2. Controller receives request
3. @RequestBody converts JSON → object
4. Controller calls Service
5. Service adds logic (status = BOOKED)
6. Repository saves to DB
7. DB returns saved object
8. Controller sends JSON response back

Phase 3
Get , Update , delete
Client sends HTTP request
1. Controller receives request
2.Controller extracts input (id / body)
3. Controller calls Service
4.Service applies business logic
5. Service calls Repository
6. Repository interacts with Database
7. Database performs operation
8. Result returns to Repository
9. Repository returns to Service
10. Service returns processed result to Controller
11. Controller sends HTTP response to Client

Generalized flow 
Client
→ Controller
→ Service
→ Repository
→ Database
→ Repository
→ Service
→ Controller
→ Client


PHASE 4 
JPA and hibernate connection 



