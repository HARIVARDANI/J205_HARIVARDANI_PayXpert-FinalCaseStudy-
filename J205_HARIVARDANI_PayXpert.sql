create database PayXpert;
use PayXpert;
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(50),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(50),
    Address VARCHAR(255),
    Position VARCHAR(100),
    JoiningDate DATE,
    TerminalDate DATE NULL
);

create table Payroll(
PayrollID int primary key,
EmployeeID int,
Foreign key(EmployeeID) REFERENCES Employee(EmployeeID),
PayPeriodStartDate date,
PayPeriodEndDate date,
BasicSalary decimal(10,2),
OvertimePay decimal(10,2),
Deductions decimal(10,2),
NetSalary decimal(10,2)
);

create table Tax(
TaxID int AUTO_INCREMENT primary key,
EmployeeID int,
Foreign key(EmployeeID) REFERENCES Employee(EmployeeID),
TaxYear int,
TaxableIncome decimal(10,2),
TaxAmount decimal(10,2)
);

create table FinancialRecord(
RecordID int primary key,
EmployeeID int,
Foreign key(EmployeeID) REFERENCES Employee(EmployeeID),
RecordDate date,
Description varchar(255),
Amount decimal(10,2),
RecordType varchar(100)
);

INSERT INTO Employee (EmployeeID, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminalDate)
VALUES 
(101, 'Hari', 'Vardani', '2002-08-06', 'Female', 'hari@gmail.com', '6381234347', 'Velrampet,pdy', 'Trainee', '2023-01-01', NULL),
(102, 'Ram', 'Kumar', '1995-08-20', 'Male', 'ram@gmail.com', '9876543210', 'lawspet,pdy', 'Developer', '2019-03-15', null),
(103, 'Neha', 'Kapoor', '1988-12-10', 'Female', 'neha@gmail.com', '9568752289', 'AnnaNagar,pdy', 'Accountant', '2018-07-10', Null);

INSERT INTO Payroll (PayrollID, EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary)
VALUES 
(1, 101, '2024-03-01', '2024-03-15', 3000.00, 100.00, 250.00, 2850.00),
(2, 102, '2024-03-01', '2024-03-15', 2500.00, 0.00, 100.00, 2400.00),
(3, 103, '2024-03-01', '2024-03-15', 2800.00, 200.00, 300.00, 2700.00);

INSERT INTO Tax (EmployeeID, TaxYear, TaxableIncome, TaxAmount)
VALUES 
(101, 2024, 35000.00, 10500.00),
(102, 2024, 30000.00, 9000.00),
(103, 2024, 38000.00, 11400.00);

INSERT INTO FinancialRecord (RecordID, EmployeeID, RecordDate, Description, Amount, RecordType)
VALUES 
(1, 101, '2024-03-15', 'BonusPayment', 500.00, 'Income'),
(2, 102, '2024-03-20', 'MedicalInsuranceDeduction', -50.00, 'Deduction'),
(3, 103, '2024-03-31', 'TravelAllowance', 100.00, 'Income');



select * from employee;
select * from payroll;
select * from tax;
select * from FinancialRecord;


select * from employee where employeeId=101;
select * from payroll where employeeId =101;

   


