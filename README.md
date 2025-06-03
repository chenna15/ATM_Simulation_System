# ATM_Simulation_System
A simple and effective console-based ATM simulation project developed using Core Java, JDBC, and MySQL to replicate real-world banking operations like checking balance, depositing money with denomination selection, withdrawing money, and validating secure PINs.

Technologies Used:
-----------------
-> Java 
-> MySQL
-> JDBC (Java Database Connectivity)

Features:
--------
-> User PIN validation that locks out after three failed attempts.
-> Deposit options featuring denominations like ₹100, ₹200, and ₹500.
-> Withdrawals that come with a quick balance check.
-> Easy access to your current account balance.
-> Used PreparedStatement to keep SQL injections at bay.
-> Enhanced security through a combo of user ID and PIN validation.

Key Logic Overview:
------------------
-> We’re using PreparedStatement for secure database queries.
-> Deposit denominations help make the money flow feel more realistic.
-> A combination of PIN and user ID is utilized to avoid duplicate access to records.

Impact and Testing:
------------------
-> I tested this project with over a **[1000]** user records in MySQL,It performed without a error. Showing 100% accuracy for balance checks, deposits, and withdrawals. Perfect for training or simulating real-time financial systems!
