package com.ken42;

public class ActionXpath {
    static String EnterEmail="//input[@name='id' or @placeholder='Please enter your Email Id']";
    static String Verify="//button[text()='Verify']";
    static String Verifylogin="//button[text()='Verify & Log In']";
    static String Inputotp="//input[@aria-label='Please enter verification code. Digit 1']/.././..";
    static String Apply="(//button[text()='Apply Now'])[2]";
    static String ClickDropDepartment="//html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[1]/div/div/div/div";
    static String selectPost="//li[@data-value='0011y00000P7qGbAAJ']";
    static String ClickPorogrameDrop="/html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div/div/div";
    static String selectPrograme="//li[@data-value='0011y00000PkWBmAAN']";
    static String ApplyNow="//button[text()='Apply']";
    static String ClickNext="//button[text()='Next']";
    static String Selectmentor="(//*[@id='outlined-select-currency'])[1]";
    static String selectYes="//li[@data-value='Yes']";
    static String Specilization="//div[text()='MBAG-Technology Management']";
    //Tc-3
    static String dob="//input[@name='applicant[dateOfBirth]']";
    static String nationality="//input[@name='applicant[nationality]']";
    static String passport="//input[@name='applicant[passportNumber]']";
    static String Gender="(//input[@name='applicant[gender]'])[1]";
    static String Mstatus="(//input[@name='applicant[martialStatus]'])[1]";
    static String country="li[@data-value='India']";
    static String State = "//input[@name='addresses[0][mailingState]' and @value='Karnataka']";
    static String District ="//input[@name='addresses[0][mailingDistrict]' and @value='Bangalore Rural']";
    static String street="input[@name='addresses[0][mailingStreet]']";
    static String PostalCode="input[@name='addresses[0][mailingPostalCode]']";
    //Tc-4
    static String relationType="//input[@name='applicantRelations.0.relationshipType' and @value='Father']";
    static String firstName="//input[@name='applicantRelations.0.firstName']";
    static String lastName="//input[@name='applicantRelations.0.lastName']";
    static String Phone="//input[@placeholder='Enter Number']";
    static String Email="//input[@name='applicantRelations.0.email']";
    static String Age="//input[@name='applicantRelations.0.age']";
    static String occupation="//input[@name='applicantRelations.0.occupation']";
    static String  annualIncome="//input[@name='applicantRelations.0.annualIncome']";
    static String address="//li[@data-value='YES']";







}
