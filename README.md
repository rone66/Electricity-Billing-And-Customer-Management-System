
# Electricity billing and customer management system

This is a windows based application by using java programming language. The idea behind project is to
manage customers' personal data, add new customer and electricity consumed data. this project is run by
database which is based on tier 1 architecture. the project is developed with some packages like Java awt ,
swing , awt.event, sql, utility, io etc

This application is partitioned with two part 

1)admin window

2)customer window

In admin window, user can create his/her profile by click on sign up button. After showing message of "account updated successfully", application  return to its previous login page. Then user put all his / her credential data which was submitted in the this page. 
Always check the accounttype every time before login and select accounttype which was given at sign up time.
After enter the main page login as Admin it shows threee tabs

1. Master
2. utility
3. Exit

and left side shows profile type and profile picture.

In Master, there are four options.

1. New customer
2. customer details
3. deposit details
4. calculate bill

// New customer --> add all details and import documents --> add meter information.

// customer details --> view all customer details (Table format).

// deposit details --> view customer electricity unit usage --> Searching by meter no. and month

// calculate bill --> fetching all details by meter no. --> create bill by specific meterno, month, unit consumption


In Utility,

1. Notepad
2. Calculator


By clicking Exit user return to the login page.


In customer window, user can create his/her profile by click on sign up button. customer can create his/her profile by meterno which is given by admin. After showing message of "account updated successfully", application  return to its previous login page. Then user put all his / her credential data which was submitted in the this page. 
Always check the accounttype every time before login and select accounttype which was given at sign up time.
After enter the main page login as customer it shows five tabs

1. user
2. Report
3. information
4. Utility
5. Exit

in user,

1.paybill
2.bill detail

//paybill --> select specific month --> click on pay--redirect to the electricity billing website.

//bill detail --> payment status monthwise(table format)

in Report

//bill generate--> select specific month ---> generate ---> create printed copy version.


information

1. view information
2. update information
3. bill calculate

//view information --> showing all details

//update information --> change pic and deails--> update--->update successfully

//bill calculate --> enter the unit,month--> bill calculated

By clicking Exit user return to the login page.
## Demo



https://drive.google.com/file/d/1TmrPxdz4Mk6zWh-_7FgJjLq5ftVZi82r/view?usp=share_link
## Features

## admin section
 1. sign up
 2. login
 3. add profile image
 4. add new customer
 5. new customer's meter type 
 6. show all registered customers
 7. print all registered customers table
 7. individual customer bill generation with meter number
 8. individual customer billing status (month wise)
 9. print customer billing status
 9. note pad
 10. calculator

## customer section
1. sign up
2. with customer unique meterno. fetch the all details which is registered by admin.
3. add profile image
4. login
5. bill status by fetching with month
6. pay bill with search by specific month
7. bill generate
8. view profile details
9. update profile details which is uploaded by admin 
10. note pad
11. calculator

// All Features are available with shortcut key.
## Deployment

To deploy this project run

```bash
  npm run deploy
  clone files
  connect to client database
  convert into jar file
  run
```

