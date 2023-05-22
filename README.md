# user-management



Requirements ,tools and technology used
=======================================
IDE: Spring Tool Suite(STS)


Database: Mysql

Technology: 
-Java(Spring boot), 
-Thymeleaf,
-Hibernate,

-Java Mail Api

Functionality:
-------------
1. Create Account
2. Login to Account
3. Password Reset(reset link via email)
4. Account Verification

Steps to Run this projects
---------------------------
1. Go to the file named application.properties  in src/main/resources folder and chande database configuration(Password)
2. open mysql and create the database as it is(login-system)
3. then run the main class(of the project in the first package).
4. after go to your browser enter(http://localhost:8080/)  you will be taken to login page
5. create an account with real email, so that in case you want to resent you can receive reset link via email
6. after login you click on Verify Account Button, enter valid email, then upload image
