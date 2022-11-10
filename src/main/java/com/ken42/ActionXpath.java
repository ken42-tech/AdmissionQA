package com.ken42;

public class ActionXpath {
    static String EnterEmail="//input[@name='id' or @placeholder='Please enter your Email Id']";
    static String Verify="//button[text()='Verify']";
    static String Verifylogin="//button[text()='Verify & Log In']";
    static String Inputotp="//input[@aria-label='Please enter verification code. Digit 1']";
    static String Apply="(//button[text()='Apply Now'])[2]";
    static String ClickDropDepartment="//html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[1]/div/div/div/div";
    static String selectPost="//li[@data-value='0011y00000P7qGbAAJ']";
    static String ClickPorogrameDrop="/html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div/div/div";
    static String selectPrograme="//li[@data-value='0011y00000PkWBmAAN']";
    static String ApplyNow="//button[text()='Apply']";
    static String ClickNext="//button[text()='Next']";
    static String Selectmentor="(//*[@id='outlined-select-currency'])[1]";
    static String selectYes="//li[@data-value='Yes']";
    static String SelectCampus="//div[text()='EMBA Combination 1']";
    static String Campus="(//*[@id='outlined-select-currency'])[2]";
    static String selectSpecilization="//div[text()='EMBA Marketing']";
    static String Specilization="(//*[@id='outlined-select-currency'])[3]";

    //static String goappliaction="//p[text()='Go To Your Application']";
    //Tc-3
    static String dob="//input[@name='applicant[dateOfBirth]']";
    static String nationality="//input[@name='applicant[nationality]']";
    static String passport="//input[@name='applicant[passportNumber]']";
    //static String Gender="//input[@value='Male']";
    static String Gender="//*[text()='Male']";
    static String Mstatus="//*[text()='Single']";

    static String selectcountry="(//*[@id='outlined-select-currency'])[1]";

    static String country="li[@data-value='India']";
    static String selectstate="(//*[@id='outlined-select-currency'])[2]";
    static String State = "//input[@name='addresses[0][mailingState]' and @value='Karnataka']";
    static String selectDist="(//*[@id='outlined-select-currency'])[3]";
    static String District ="//input[@name='addresses[0][mailingDistrict]' and @value='Bangalore Rural']";
    static String street="//input[@name='addresses[0][mailingStreet]']";
    static String PostalCode="//input[@name='addresses[0][mailingPostalCode]']";
    static String currentaddress="(//*[@id='outlined-select-currency'])[4]";
    static String selectcurrentaddress="//*[text()='Yes']";
    static String clicknext="//*[text()='Next']";
    
    //Tc-4
    static String selectrelationship="(//*[@id='outlined-select-currency'])[1]";
    static String relationType="//div[text()='Sibling']";
    static String firstName="//input[@name='applicantRelations.0.firstName']";
    static String lastName="//input[@name='applicantRelations.0.lastName']";
    static String Phone="//input[@placeholder='Enter Number']";
    static String Email="//input[@name='applicantRelations.0.email']";
    static String Age="//input[@name='applicantRelations.0.age']";
    static String occupation="//input[@name='applicantRelations.0.occupation']";
    static String  annualIncome="//input[@name='applicantRelations.0.annualIncome']";
    static String SelectQualification="(//*[@id='outlined-select-currency'])[2]";
    static String Qualification="//div[text()='Undergraduate']";
    static String CurrencyTypeSelect="(//*[@id='outlined-select-currency'])[3]";
    static String currencyType="//div[text()='Indian Rupee (INR)']";
    static String address="//li[@data-value='YES']";
//tc-5
static String clickyes="(//*[text()='Yes'])[1]";
static String SelectjobType="(//*[@id='outlined-select-currency'])[1]";
static String jobType="//li[@data-value='Full Time']";
static String company="//input[@name='workExperiences.0.organisationName']";
static String IndustryType="(//*[@id='outlined-select-currency'])[2]";
static String location="//input[@name='workExperiences.0.location']";
static String designation="//input[@name='workExperiences.0.designation']";
static String role="//input[@name='workExperiences.0.roles']";
static String DateJoin="//input[@name='workExperiences.0.dateOfJoining']";
static String CurrentCompany="(//*[@id='outlined-select-currency'])[3]";
static String selectCurrentCompany="(//*[text()='Yes'])[2]";
static String Experience="//input[@name='workExperiences.0.noOfMonths']";
static String currencytype="(//*[@id='outlined-select-currency'])[4]";
static String selectcurrencytype="//li[@data-value='Indian Rupee (INR)']";
static String AnnualSalary="//input[@name='workExperiences.0.annualSalary']";
//Tc-6
    //pg
    static String pgyear="//*[@name='educationHistories[0][yearOfPassing]']";
    static String pguniversity="//*[@name='educationHistories[0][institutionName]']";
    static String pgcollege="//*[@name='educationHistories[0][placeOfStudy]']";
    static String pgpercentage="//*[@name='educationHistories[0][obtainedMarks]']";
    static String pgedttype="(//*[@id='outlined-select-currency'])[1]";
    static String pgselectedttype="//*[text()='Full time']";
    static String pgdegree="(//*[@id='outlined-select-currency'])[2]";
    static String pgselectdegree="//*[text()='Bachelor of Fine Arts (BFA)']";
    static String pgcountry="(//*[@id='outlined-select-currency'])[3]";
    static String pgselectcountry="//*[text()='India']";
    static String pgstate="(//*[@id='outlined-select-currency'])[4]";
    static String pgselectstate="//*[text()='Karnataka']";
    static String pgcity="(//*[@id='outlined-select-currency'])[5]";
    static String pgselectcity="//*[text()='Bangalore Rural']";

    //ug
    static String ugyear="//*[@name='educationHistories[1][yearOfPassing]']";
    static String uguniversity="//*[@name='educationHistories[1][institutionName]']";
    static String ugcollege="//*[@name='educationHistories[1][placeOfStudy]']";
    static String ugpercentage="//*[@name='educationHistories[1][obtainedMarks]']";
    static String ugedtype="(//*[@id='outlined-select-currency'])[6]";
    static String ugselectedtype="(//*[text()='Full time'])[2]";
    static String ugdegree="(//*[@id='outlined-select-currency'])[7]";
    static String ugselectdegree="//*[text()='Bachelor of Management Science (BMS)']";
    static String ugcountry="(//*[@id='outlined-select-currency'])[8]";
    static String ugselectcountry="//*[text()='India']";
    static String ugstate="(//*[@id='outlined-select-currency'])[9]";
    static String ugselectstate="//*[text()='Karnataka']";
    static String ugcity="(//*[@id='outlined-select-currency'])[10]";
    static String ugselectcity="//*[text()='Bangalore Rural']";
    static String ugtype="(//*[@id='outlined-select-currency'])[11]";
    static String ugselecttype="//*[text()='Year']";
    static String ugyear1="(//*[@id='outlined-select-currency'])[12]";
    static String ugselectyear1="//*[text()='Year 1']";
    static String ugmark1="//*[@name='educationHistories[1][yearwiseMarks].0.yearMarks']";
    static String ugmaxmark1="//*[@name='educationHistories[1][yearwiseMarks].0.yearMaxMarks']";
    static String ugyear2="(//*[@id='outlined-select-currency'])[13]";
    static String ugselectyear2="//*[text()='Year 2']";
    static String ugmark2="//*[@name='educationHistories[1][yearwiseMarks].1.yearMarks']";
    static String ugmaxmark2="//*[@name='educationHistories[1][yearwiseMarks].1.yearMaxMarks']";
    //12
    static String hscedtype="(//*[@id='outlined-select-currency'])[14]";
    static String hscselectedtype="(//*[text()='Full time'])[3]";
    static String hscboard="(//*[@id='outlined-select-currency'])[15]";
    static String hscselectboard="(//*[text()='KARNATAKA SECONDARY EDUCATION, EXAMINATION BOARD'])[1]";
    static String hscpercentage="//*[@name='educationHistories[2][obtainedMarks]']";
    static String hscyear="//*[@name='educationHistories[2][yearOfPassing]']";
    static String hscschool="//*[@name='educationHistories[2][placeOfStudy]']";
    static String hsccountry="(//*[@id='outlined-select-currency'])[16]";
    static String hscselectcountry="//*[text()='India']";
    static String hscstate="(//*[@id='outlined-select-currency'])[17]";
    static String hscselectstate="//*[text()='Karnataka']";
    static String hsccity="(//*[@id='outlined-select-currency'])[18]";
    static String hscselectcity="//*[text()='Bangalore Rural']";

    //10
    static String sslcedtype="(//*[@id='outlined-select-currency'])[19]";
    static String sslcselectedtype="(//*[text()='Full time'])[4]";
    static String sslcboard="(//*[@id='outlined-select-currency'])[20]";
    static String sslcselectboard="//*[@name='educationHistories[0][yearOfPassing]']";
    static String sslcgrade="(//*[@id='outlined-select-currency'])[21]";
    static String sslcselectgrade="//*[text()='CGPA']";
    static String sslcpercentage="//*[@name='educationHistories[3][obtainedMarks]']";
    static String sslcyear="//*[@name='educationHistories[3][yearOfPassing]']";
    static String sslcschool="//*[@name='educationHistories[3][placeOfStudy]']";
    static String sslccountry="(//*[@id='outlined-select-currency'])[22]";
    static String sslcselectcountry="//*[text()='India']";
    static String sslcstate="(//*[@id='outlined-select-currency'])[23]";
    static String sslcselectstate="//*[text()='Karnataka']";
    static String sslccity="(//*[@id='outlined-select-currency'])[24]";
    static String sslcselectcity="//*[text()='Bangalore Rural']";
    // static String clicknext="//*[text()='Next']";
 //Tc-7
 static String SportAchievement="//*[@name='application[sportsAchievements]']";
 static String ProfessionalAchievement="//*[@name='application[professionalAchievements]']";
 static String CurricularActivities="//*[@name='application[extraCurricularActivities]']";
 static String AcademicAchievements="//*[@name='application[exceptionalAcademicAchievements]']";
 static String fundeducation="(//*[@id='outlined-select-currency'])[1]";
 static String fundselecteducation="//*[text()='Self-funding + Bank Loan']";
 static String physicallychallenged="(//*[text()='No'])[1]";
 static String sharedetails="//*[@name='specialAbilityDetails']";
 static String Statement="//*[@name='application[statementOfPurpose]']";
 static String planmasterdegree="//*[@name='application[mastersPlan]']";
 static String sponsoredbycompany="(//*[text()='No'])[2]";
 static String Language="(//*[@id='outlined-select-currency'])[2]";
 static String SelectLanguage="//*[text()='Kannada ']";
 static String Proficiency="(//*[@id='outlined-select-currency'])[3]";
 static String SelectProficiency="//*[text()='Superior']";
 static String evaluation="(//*[@id='outlined-select-currency'])[4]";
 static String Selectevaluation="(//*[text()='No'])[3]";
 static String qualificationenglish="(//*[@id='outlined-select-currency'])[5]";
 static String selectqualificationenglish="(//*[text()='No'])[4]";
 static String latestqualificationenglish="(//*[@id='outlined-select-currency'])[6]";
 static String selectlatestqualificationenglish="(//*[text()='No'])[5]";
 static String appliedtoSPJain="(//*[text()='No'])[6]";
 static String EducationConsultant ="(//*[text()='No'])[7]";
 static String hearspjain="(//*[@id='outlined-select-currency'])[7]";
 static String selecthearspjain="//*[text()='TV / Radio']";
 static String refrence="(//*[text()='No'])[8]";
 // static String clicknext="//*[text()='Next']";

 //Tc-8
 static String clicksubmit="//*[text()='Submit']";
 static String backtohome="//*[text()='Homepage']";






}