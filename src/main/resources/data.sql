create database lms_application;
use lms_application;


-------->History Table queries <------------                 
                
create table history_table(
                HISTORY_ID INT NOT NULL,
                REGISTER_ID INT ,
                FILE_ID INT,
                EMP_ID VARCHAR(400),
                NAME VARCHAR(200),
                DEPARTMENT VARCHAR(200),
                EXPERIENCE INT,
                CREATED_DATE DATE,
                LEAVE_TYPE VARCHAR(200),
                REASON_FOR_APPLY VARCHAR(200),
                FROM_DATE DATE,
                TO_DATE DATE,
                N0_OF_DAYS FLOAT(3,1),
                LOCATION  VARCHAR(200),
                STATUS VARCHAR (200),
                CASUAL_LEAVE FLOAT(3,1),
                SICK_LEAVE FLOAT(3,1),
                PRIVILEGE_LEAVE FLOAT(3,1),
                BEREAVEMENT_LEAVE FLOAT(3,1),
                MATERNITY_LEAVE FLOAT(3,1),
                LOP_DAYS FLOAT(3,1),
                CREATED_BY VARCHAR(255),
                APPROVED_BY VARCHAR(255),
                APPROVED_DATE VARCHAR(255),
                DESIGNATION VARCHAR(255),
                MANAGER_NAME VARCHAR(255),
                MANAGER_EMAIL VARCHAR(255),
                CONSTRAINT PK_HID primary key (HISTORY_ID),
                CONSTRAINT FK_RID foreign key (REGISTER_ID) references register_table(REGISTER_ID));
                

-------->Leave Details Table queries <------------ 
                
create table leave_details (
                L_ID INT NOT NUL ,
                EXPERIENCE  INT,
                CASUAL_LEAVE FLOAT(3,1),
                SICK_LEAVE FLOAT(3,1),
                PRIVILAGE_LEAVE FLOAT(3,1),
                MATERNITY_LEAVE FLOAT(3,1),
                BEREAVEMENT_LEAVE FLOAT(3,1),
                CONSTRAINT PK_LID PRIMARY KEY(L_ID));
                
-------->LeaveTrack Table queries <------------                 
                
create table leavetrack_table(
                LEAVETRACK_ID INT NOT NULL,
                EMPID VARCHAR(200),
                YEAR INT,
                CASUAL_LEAVE FLOAT(3,1),
                CARRYFORWARD_LEAVE FLOAT(3,1),
                SICK_LEAVE FLOAT(3,1),
                PRIVILEGE_LEAVE FLOAT(3,1),
                BEREAVEMENT_LEAVE FLOAT(3,1),
                MATERNITY_LEAVE FLOAT(3,1),
                CONSTRAINT PK_LEAVETRACK_ID PRIMARY KEY(LEAVETRACK_ID));
                
               

               


               




