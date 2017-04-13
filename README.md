# AutomationAssignment
Contributor: Hardik Ranjan

The project is based on TestNG framework using Selenium WebDriver and  has got functionality of choosing of browser and test suit to test opening of browser, and opening Url and navigate to sign up page to successfully sign Up with a valid new email id and already registered emailId. The project actually provides a framework for handling of PageObjects, Checkers, Exception Handling, TestCases, Utils.

The Project Runs for two browsers Chrome(Chrome Driver) and Firefox(gecko driver). The Global dependencies as is defined in the maven pom.xml file for the project. 


Project Contains Packages Structure

src/main/java
---->Checkers(Checker classes)
---->Exception(UserDefined Exceptions)
---->Pages(Page Objects)
---->Utils(Util class,Listener)

-src/test/java
---->VerifyLinkText


In VerifyLinkText contains TestNG executable Test Class to be executed containing % Test Cases and are executed in order.

How To Run:- 
1. Open VerifyLinkText.java file and run through TestNG
2. Directly run testng.xml file

Flow Of Project:- 
The Project navigate from Opening Browser-> Opening Appdirect HomePage -> AppDirect Login Page-> Appdirect SignUp Page -> Enter EmaidId -> Activation Mail Send(If emaid id already registered then gives a Error Message)
