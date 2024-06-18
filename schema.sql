-- Create database
CREATE DATABASE IF NOT EXISTS sda;

-- Use the database
USE sda;

-- Create Students table
CREATE TABLE IF NOT EXISTS Students (
    Student_ID INT PRIMARY KEY,
    Student_Password VARCHAR(255),
    Student_DOB VARCHAR(255),
    Student_Batch VARCHAR(255),
    Student_Name VARCHAR(255)
);

-- Create Admin table
CREATE TABLE IF NOT EXISTS Admin (
    Admin_ID INT PRIMARY KEY,
    Admin_Password VARCHAR(255),
    Admin_DOB VARCHAR(255),
    Admin_Name VARCHAR(255)
);

-- Create Employee table
CREATE TABLE IF NOT EXISTS Employee (
    Employee_ID INT PRIMARY KEY,
    Employee_Password VARCHAR(255),
    Employee_DOB VARCHAR(255),
    Employee_YearofHiring VARCHAR(255),
    Employee_Name VARCHAR(255)
);

-- Create Harassment_cases table
CREATE TABLE IF NOT EXISTS Harassment_casses (
    ObjectID INT AUTO_INCREMENT PRIMARY KEY,
    accused_first_name VARCHAR(255),
    accused_last_name VARCHAR(255),
    victim_first_name VARCHAR(255),
    victim_last_name VARCHAR(255),
    descriptionn TEXT,
    Statuss BOOLEAN
);

-- Create LostFound table
CREATE TABLE IF NOT EXISTS LostFound (
    ObjectID INT PRIMARY KEY,
    descriptionn TEXT,
    namee VARCHAR(255),
    Statuss BOOLEAN
);

-- Create Library_Issue table
CREATE TABLE IF NOT EXISTS Library_Issue (
    IssueID INT AUTO_INCREMENT PRIMARY KEY,
    IssueDescription TEXT,
    IssueType VARCHAR(255),
    ComplainantID INT,
    ComplainantPhone VARCHAR(255),
    Resolved BOOLEAN DEFAULT FALSE
);

-- Create Cafeteria_Issue table
CREATE TABLE IF NOT EXISTS Cafeteria_Issue (
    IssueID INT AUTO_INCREMENT PRIMARY KEY,
    IssueDescription TEXT,
    IssueType VARCHAR(255),
    ComplainantID INT,
    ComplainantPhone VARCHAR(255),
    Suggestion TEXT,
    Resolved BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Academic_Issues (
    complaintID INT AUTO_INCREMENT PRIMARY KEY,
    details VARCHAR(255),
    againstteacher VARCHAR(255),
    againstcourse VARCHAR(255)
);

select * from Students;
select * from Admin;
select * from Employee;
select * from Harassment_casses;
select * from LostFound;
select * from Library_Issue;
select * from Cafeteria_Issue;
select * from Academic_Issues;

