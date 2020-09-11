# Login-API
This is an example program that can be used to implement the login feature

# Import API
Download the .jar file or import using link: https://github.com/Indoriajs/Login-API.git

# Important notes

This is an example program to demonstrate the functioning of a login API, however it is possible to have your own database integrated into it for  
normal application use.  

## Custom Database
To use custom database, convert the existing usernames and passwords to a map<String, String> where the Strings take password and username respectively.  
Map<username, password>

## Creating Objects
In-order to objects for login and signup classes we have to use the getInstance method.  

It is possible to use a custom Map<String, String> for a custom database  
getInstance() can be overloaded with one more argument (Map<String, String>)  

## Log-In 
Check Log-In using login(String username, String password) method.  
It can be overloaded with login(int phone_number, String password).  
throws IncorrectKeyException and UserNotFoundException  

## Sign-Up
Create user using createUser(String username, String password) method.  
It can be overloaded with createUser(int phone_number, String password).  
throws UserExistsException  


## Exceptions
This API throws the following exceptions :  
    IncorrectKeyException  
    UserNotFoundException  
    UserExistsException  
