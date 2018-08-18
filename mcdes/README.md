# mcdes
BehaveWithHoundify

Test Cases written with Behave-Python

Reports will be in JSON Format need to convert using Java Utility.


Run->

Find file with .feature extension
Use command behave -f allure_behave.formatter:AllureFormatter -o reports/ testhoundify.feature

OR

behave -f json -o reports/output.json testhoundify.feature

After Creation of Report Run RunHTMLReport.java Class from behave-reporting project.

You are able to see HTML reports.
