Note:

1. This work is 100% original work by student id i23024629, without any use of AI whatsoever and in any capacity
2. This work was done with alot of hardwork without any prior knowledge in programming languages and Java

3. This program was created without the type checking of input variables, hence it is strong advised to follow the specified data type during input. Where otherwise not specified, it can be assumed that the data type required is a string.

4. This program is best used with only a single instance of Student but feel free to explore the addition of more students etc.


System model:

1. University class is the main class where the main program sits [IMPORTANT!]

2. Equivalently, University.java = Main.java
3. Student class holds information on student attributes and methods such as:
    - new student constructor
    - student details change
    - fetch student data
    - display student data

4. Course class holds information on course details with attributes and methods such as:
    - new course constructor
    - course details change
    - display course details

5. Enrolment class holder information on student enrolment in courses. This class has been interpreted to be another class in the object model and allows instantiation. Some methods available here are:
    - enrolment constructors
    - enrolment changes
    - display enrolment details

6. User class is a self defined class based on own interpretation of the system. This class provides added and secure functionality for the authorisation of users to login to the system. The instances of this class are not Students themselves but are merely accounts of students. The concept can be broken down as follows:
    - User instance is merely the account
    - Student instance is the profile of the account
