# ATM_Simulation_System
A simple and effective console-based ATM simulation project developed using Core Java, JDBC, and MySQL to replicate real-world banking operations like checking balance, depositing money with denomination selection, withdrawing money, and validating secure PINs.

Technologies Used:
-----------------
-> Java 
-> MySQL
-> JDBC (Java Database Connectivity)


Logic Overview:
------------------
-> I used PreparedStatement for secure database queries.
-> Deposit denominations help make the money flow feel more realistic.
-> A combination of PIN and user ID is utilized to avoid duplicate access to records.

Key Features:
------------
-> Secure Login: PIN-based login with a 3-attempt lockout mechanism.
-> Used PreparedStatement to prevent SQL injection.
-> Check balance.
-> Deposit money using denomination input (₹100/₹200/₹500 notes).
-> Withdraw money with sufficient balance checks.
-> Security Enhancement: By validating User ID + PIN combination.
-> Database Integration: Uses MySQL for storing and retrieving user account information.
-> JDBC Integration: Handles all backend operations securely via Java Database Connectivity.
-> Scalable Testing: Successfully tested with 1,000  different user records.
