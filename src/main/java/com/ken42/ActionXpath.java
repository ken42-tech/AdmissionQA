package com.ken42;

public class ActionXpath {
    static String EnterEmail = "//input[@name='id' or @placeholder='Please enter your Email Id']";
    static String Verify = "//button[text()='Verify']";
    static String Verifylogin = "//button[text()='Verify & Log In']";
    static String Inputotp = "//input[@aria-label='Please enter verification code. Digit 1']";
    static String searchthecourse = "//input[@placeholder='Search...']";

    static String Apply = "(//button[text()='Apply Now'])[2]";
    static String ClickDropDepartment = "//html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[1]/div/div/div/div";
    static String selectPost = "(//div[text()='All Departments'])[2]";
    static String ClickPorogrameDrop = "(//div[@aria-haspopup='listbox'])[2]";
    static String selectPrograme = "//li[@role='option']";
    static String ApplyNow = "//button[text()='Apply']";
    static String ClickNext = "//button[text()='Next']";
    static String Selectmentor = "(//*[@id='outlined-select-currency'])[1]";
    static String selectYes = "//li[@data-value='Yes'] | //li[@data-value='true']";
    // static String SelectCampus = "//div[text()='EMBA Combination 1']";
    // static String Campus = "(//*[@id='outlined-select-currency'])[2]";
    static String campus = "//*[text()='Campus Format']/../../../..//*[local-name()='svg']/../..";
    // static String selectSpecilization = "//div[text()='EMBA Marketing']";
    // static String Specilization = "(//*[@id='outlined-select-currency'])[3]";
    static String Specilization = "//*[text()='Specialization']/../../../..//*[local-name()='svg']/../..";

    // static String goappliaction="//p[text()='Go To Your Application']";
    // Tc-3
    static String dob = "//input[@name='applicant[dateOfBirth]']";
    static String Nationaliydrop = "(//*[@id='outlined-select-currency'])[1]";
    static String selectnationality = "//div[text()='Indian']";
    static String nationality = "//input[@name='applicant[nationality]']";
    static String passport = "//input[@name='applicant[passportNumber]']";
    // static String Gender="//input[@value='Male']";
    static String Gender = "//*[text()='Male']";
    static String Mstatus = "//*[text()='Single']";

    static String selectcountry = "(//*[@id='outlined-select-currency'])[2]";

    static String country = "li[@data-value='India']";
    static String selectstate = "(//*[@id='outlined-select-currency'])[3]";
    static String State = "//input[@name='addresses[0][mailingState]' and @value='Karnataka']";
    static String selectDist = "(//*[@id='outlined-select-currency'])[4]";
    static String District = "//input[@name='addresses[0][mailingDistrict]' and @value='Bangalore Rural']";
    static String street = "//input[@name='addresses[0][mailingStreet]']";
    static String PostalCode = "//input[@name='addresses[0][mailingPostalCode]']";
    static String currentaddress = "(//*[@id='outlined-select-currency'])[5]";
    static String selectcurrentaddress = "//*[text()='Yes']";
    static String clicknext = "//*[text()='Next']";

    // Tc-4
    static String selectrelationship = "(//*[@id='outlined-select-currency'])[1]";
    static String relationType = "//div[text()='Sibling']";
    static String firstName = "//input[@name='applicantRelations.0.firstName']";
    static String lastName = "//input[@name='applicantRelations.0.lastName']";
    static String Phone = "//input[@placeholder='Enter Number']";
    static String Email = "//input[@name='applicantRelations.0.email']";
    static String Age = "//input[@name='applicantRelations.0.age']";
    static String occupation = "//input[@name='applicantRelations.0.occupation']";
    static String annualIncome = "//input[@name='applicantRelations.0.annualIncome']";
    static String SelectQualification = "(//*[@id='outlined-select-currency'])[2]";
    static String Qualification = "//div[text()='Undergraduate']";
    static String CurrencyTypeSelect = "(//*[@id='outlined-select-currency'])[3]";
    static String currencyType = "//div[text()='Indian Rupee (INR)']";
    static String address = "//li[@data-value='YES']";
    // tc-5
    static String clickyes = "(//*[text()='Yes'])[1]";
    static String SelectjobType = "(//*[@id='outlined-select-currency'])[1]";
    static String jobType = "//li[@data-value='Full Time']";
    static String company = "//input[@name='workExperiences.0.organisationName']";
    static String IndustryType = "(//*[@id='outlined-select-currency'])[2]";
    static String Country = "(//*[@id='outlined-select-currency'])[3]";
    static String state = "(//*[@id='outlined-select-currency'])[4]";
    static String city = "(//*[@id='outlined-select-currency'])[5]";
    static String location = "//input[@name='workExperiences.0.location']";
    static String designation = "//input[@name='workExperiences.0.designation']";
    static String role = "//input[@name='workExperiences.0.roles']";
    static String DateJoin = "//input[@name='workExperiences.0.dateOfJoining']";
    static String CurrentCompany = "(//*[@id='outlined-select-currency'])[6]";
    static String selectCurrentCompany = "(//*[text()='Yes'])[2]";
    static String Experience = "//input[@name='workExperiences.0.noOfMonths']";
    static String currencytype = "(//*[@id='outlined-select-currency'])[7]";
    static String selectcurrencytype = "//li[@data-value='Indian Rupee (INR)']";
    static String AnnualSalary = "//input[@name='workExperiences.0.annualSalary']";
    // Tc-6
    // pg
    static String pgyear = "//*[@name='educationHistories[0][yearOfPassing]']";
    static String pguniversity = "//*[@name='educationHistories[0][institutionName]']";
    static String pgcollege = "//*[@name='educationHistories[0][placeOfStudy]']";
    static String pgpercentage = "//*[@name='educationHistories[0][obtainedMarks]']";
    // static String pgedttype = "(//*[@id='outlined-select-currency'])[1]";
    static String pgedttype = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[1]/../..";
    static String pgselectedttype = "//*[text()='Full time']";
    // static String pgdegree = "(//*[@id='outlined-select-currency'])[2]";
    static String pgdegree = "(//*[text()='Degree']/../../../..//*[local-name()='svg'])[1]/../..";
    static String pgselectdegree = "//*[text()='Bachelor of Fine Arts (BFA)']";
    // static String pgevaluation = "(//*[@id='outlined-select-currency'])[3]";
    static String pgevaluation = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[1]/../..";
    static String pgevaluationselect = "//*[text()='Percentage']";
    // static String pgcountry = "(//*[@id='outlined-select-currency'])[4]";
    static String pgcountry = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[1]/../..";
    // static String pgselectcountry = "//*[text()='India']";
    // static String pgstate = "(//*[@id='outlined-select-currency'])[5]";
    static String pgstate = "(//*[text()='State']/../../../..//*[local-name()='svg'])[1]/../..";
    static String pgselectstate = "//*[text()='Karnataka']";
    static String pgcity = "(//*[text()='City']/../../../..//*[local-name()='svg'])[1]/../..";
    // static String pgcity = "(//*[@id='outlined-select-currency'])[6]";
    static String pgselectcity = "//*[text()='Bangalore Rural']";

    // ug
    static String ugyear = "//*[@name='educationHistories[1][yearOfPassing]']";
    static String uguniversity = "//*[@name='educationHistories[1][institutionName]']";
    static String ugcollege = "//*[@name='educationHistories[1][placeOfStudy]']";
    static String ugpercentage = "//*[@name='educationHistories[1][obtainedMarks]']";
    // static String ugedtype = "(//*[@id='outlined-select-currency'])[6]";
    static String ugedtype = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectedtype = "(//*[text()='Full time'])[2]";
    // static String ugdegree = "(//*[@id='outlined-select-currency'])[7]";
    static String ugdegree = "(//*[text()='Degree']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectdegree = "//*[text()='Bachelor of Management Science (BMS)']";
    // static String ugevaluation = "(//*[@id='outlined-select-currency'])[8]";
    static String ugevaluation = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugevaluationselect = "//*[text()='Points']";
    // static String ugcountry = "(//*[@id='outlined-select-currency'])[9]";
    static String ugcountry = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectcountry = "//*[text()='India']";
    // static String ugstate = "(//*[@id='outlined-select-currency'])[10]";
    static String ugstate = "(//*[text()='State']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectstate = "//*[text()='Karnataka']";
    // static String ugcity = "(//*[@id='outlined-select-currency'])[11]";
    static String ugcity = "(//*[text()='City']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectcity = "//*[text()='Bangalore Rural']";
    // static String ugtype = "(//*[@id='outlined-select-currency'])[12]";
    static String ugtype = "(//*[text()='Type']/../../../..//*[local-name()='svg'])[1]/../..";
    static String ugselecttype = "//*[text()='Year']";
    // static String ugyear1 = "(//*[@id='outlined-select-currency'])[13]";
    static String ugyear1 = "(//*[text()='Select Year']/../../../..//*[local-name()='svg'])[1]/../..";
    static String ugselectyear1 = "//*[text()='Year 1']";
    static String ugmark1 = "//*[@name='educationHistories[1][yearwiseMarks].0.yearMarks']";
    static String ugmaxmark1 = "//*[@name='educationHistories[1][yearwiseMarks].0.yearMaxMarks']";
    // static String ugyear2 = "(//*[@id='outlined-select-currency'])[14]";
    static String ugyear2 = "(//*[text()='Select Year']/../../../..//*[local-name()='svg'])[2]/../..";
    static String ugselectyear2 = "//*[text()='Year 2']";
    static String ugmark2 = "//*[@name='educationHistories[1][yearwiseMarks].1.yearMarks']";
    static String ugmaxmark2 = "//*[@name='educationHistories[1][yearwiseMarks].1.yearMaxMarks']";
    // 12
    // static String hscedtype = "(//*[@id='outlined-select-currency'])[15]";
    static String hscedtype = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[3]/../..";
    static String hscedtype_1 = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[1]/../..";
    static String hscselectedtype = "(//*[text()='Full time'])[3]";
    static String hscselectedtype_1 = "(//*[text()='Full time'])[1]";

    // static String hscboard = "(//*[@id='outlined-select-currency'])[17]";
    static String hscboard = "(//*[text()='Board']/../../../..//*[local-name()='svg'])[1]/../..";
    // static String gradeType = "(//*[@id='outlined-select-currency'])[18]";
    static String gradeType = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[3]/../..";
    static String gradeType_1 = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[1]/../..";

    static String hscgradeType = "(//*[text()='Grade Type']/../../../..//*[local-name()='svg'])[1]/../..";

    static String hscselectboard = "(//*[text()='KARNATAKA SECONDARY EDUCATION, EXAMINATION BOARD'])[1]";
    static String hscgrade = "(//*[@id='outlined-select-currency'])[18]";
    static String hscgradeselect = "(//*[text()='Grade'])[1]";
    static String hscpercentage = "//*[@name='educationHistories[2][obtainedMarks]']";
    static String hscpercentage_1 = "//*[@name='educationHistories[0][obtainedMarks]']";

    static String hscyear = "//*[@name='educationHistories[2][yearOfPassing]']";
    static String hscyear_1 = "//*[@name='educationHistories[0][yearOfPassing]']";

    static String hscschool = "//*[@name='educationHistories[2][placeOfStudy]']";
    static String hscschool_1 = "//*[@name='educationHistories[0][placeOfStudy]']";

    // static String hsccountry = "(//*[@id='outlined-select-currency'])[19]";
    static String hsccountry = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[3]/../..";
    static String hsccountry_1 = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[1]/../..";

    static String hscselectcountry = "//*[text()='India']";
    // static String hscstate = "(//*[@id='outlined-select-currency'])[20]";
    static String hscstate = "(//*[text()='State']/../../../..//*[local-name()='svg'])[3]/../..";
    static String hscstate_1 = "(//*[text()='State']/../../../..//*[local-name()='svg'])[1]/../..";

    static String hscselectstate = "//*[text()='Karnataka']";
    // static String hsccity = "(//*[@id='outlined-select-currency'])[21]";
    static String hsccity = "(//*[text()='City']/../../../..//*[local-name()='svg'])[3]/../..";
    static String hsccity_1 = "(//*[text()='City']/../../../..//*[local-name()='svg'])[1]/../..";

    static String hscselectcity = "//*[text()='Bangalore Rural']";

    // 10
    // static String sslcedtype = "(//*[@id='outlined-select-currency'])[22]";
    static String sslcedtype = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[4]/../..";
    static String sslcedtype_1 = "(//*[text()='Education Type']/../../../..//*[local-name()='svg'])[2]/../..";

    static String sslcselectedtype = "(//*[text()='Full time'])[4]";
    static String sslcselectedtype_1 = "(//*[text()='Full time'])[2]";

    // static String sslcboard = "(//*[@id='outlined-select-currency'])[23]";
    static String sslcboard = "(//*[text()='Board']/../../../..//*[local-name()='svg'])[2]/../..";
    static String sslcselectboard = "//*[@name='educationHistories[0][yearOfPassing]']";
    static String sslcgrade = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[4]/../..";
    static String sslcgrade_1 = "(//*[text()='Evaluation Type']/../../../..//*[local-name()='svg'])[2]/../..";

    // static String sslcgrade = "(//*[@id='outlined-select-currency'])[24]";
    static String sslcgradeType = "(//*[text()='Grade Type']/../../../..//*[local-name()='svg'])[2]/../..";

    static String sslcselectgrade = "//*[text()='CGPA']";
    static String sslcpercentage = "//*[@name='educationHistories[3][obtainedMarks]']";
    static String sslcpercentage_1 = "//*[@name='educationHistories[1][obtainedMarks]']";

    static String sslcyear = "//*[@name='educationHistories[3][yearOfPassing]']";
    static String sslcyear_1 = "//*[@name='educationHistories[1][yearOfPassing]']";

    static String sslcschool = "//*[@name='educationHistories[3][placeOfStudy]']";
    static String sslcschool_1 = "//*[@name='educationHistories[1][placeOfStudy]']";

    // static String sslccountry = "(//*[@id='outlined-select-currency'])[25]";
    static String sslccountry = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[4]/../..";
    static String sslccountry_1 = "(//*[text()='Country']/../../../..//*[local-name()='svg'])[2]/../..";

    static String sslcselectcountry = "//*[text()='India']";
    // static String sslcstate = "(//*[@id='outlined-select-currency'])[26]";
    static String sslcstate = "(//*[text()='State']/../../../..//*[local-name()='svg'])[4]/../..";
    static String sslcstate_1 = "(//*[text()='State']/../../../..//*[local-name()='svg'])[2]/../..";

    static String sslcselectstate = "//*[text()='Karnataka']";
    // static String sslccity = "(//*[@id='outlined-select-currency'])[27]";
    static String sslccity = "(//*[text()='City']/../../../..//*[local-name()='svg'])[4]/../..";
    static String sslccity_1 = "(//*[text()='City']/../../../..//*[local-name()='svg'])[2]/../..";

    static String sslcselectcity = "//*[text()='Bangalore Rural']";
    // static String clicknext="//*[text()='Next']";
    // Tc-7
    static String SportAchievement = "//*[@name='application[sportsAchievements]']";
    static String ProfessionalAchievement = "//*[@name='application[professionalAchievements]']";
    static String CurricularActivities = "//*[@name='application[extraCurricularActivities]']";
    static String AcademicAchievements = "//*[@name='application[exceptionalAcademicAchievements]']";
    static String fundeducation = "(//*[@id='outlined-select-currency'])[1]";
    static String fundselecteducation = "//*[text()='Self-funding + Bank Loan']";
    // static String physicallychallenged =
    // "(//input[@name='applicant[isDifferentlyAbled]'])[2]";
    static String physicallychallenged = "(//*[text()='No'])[1]";

    static String sharedetails = "//*[@name='specialAbilityDetails']";
    static String Statement = "//*[@name='application[statementOfPurpose]']";
    static String planmasterdegree = "//*[@name='application[mastersPlan]']";
    static String sponsoredbycompany = "(//*[text()='No'])[2]";
    static String Language = "(//*[@id='outlined-select-currency'])[2]";
    static String SelectLanguage = "//*[text()='Kannada ']";
    static String Proficiency = "(//*[@id='outlined-select-currency'])[3]";
    static String SelectProficiency = "//*[text()='Superior']";
    static String evaluation = "(//*[@id='outlined-select-currency'])[4]";
    static String Selectevaluation = "(//*[text()='No'])[3]";
    static String qualificationenglish = "(//*[@id='outlined-select-currency'])[5]";
    static String selectqualificationenglish = "(//*[text()='No'])[4]";
    static String latestqualificationenglish = "(//*[@id='outlined-select-currency'])[6]";
    static String selectlatestqualificationenglish = "(//*[text()='No'])[5]";
    static String appliedtoSPJain = "(//*[text()='No'])[6]";
    static String EducationConsultant = "(//*[text()='No'])[7]";
    static String hearspjain = "(//*[@id='outlined-select-currency'])[7]";
    static String selecthearspjain = "//*[text()='Social Media']";
    static String refrence = "(//*[text()='No'])[8]";
    // static String hscgradeselect = "(//*[text()='Grade'])[1]";
    // static String clicknext="//*[text()='Next']";

    // Tc-8
    static String clicksubmit = "//*[text()='Submit']";
    static String backtohome = "//*[text()='Homepage']";

    // tc -9
    static String SalesforceEmail = "//input[@type='email']";
    static String SalesforcePassword = "//input[@type='password']";
    static String loginSalesforce = "//input[@type='submit']";
    static String applauncher = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/div/div/div/one-app-launcher-header";
    static String search = "//*[@placeholder='Search apps and items...']";
    // static String clickcontacts = "(//*[text()='Contacts'])[2]";
    static String listsearch = "//*[@placeholder='Search this list...']";
    static String clickstudent = "(//*[text()='test Student'])[1]";
    static String clickappname = "(//*[text()='Application Name']/../../../../../../../..//*[@class='slds-truncate'])[5]";
    static String clickappview = "//*[text()='Application View']";

    static String acadYear2022 = "(//*[text()='2022']/.././../..//*[@class='slds-cell-edit cellContainer'])[5]";
    static String acadYear2023 = "(//*[text()='2023']/.././../..//*[@class='slds-cell-edit cellContainer'])[5]";
    static String acadYear2024 = "(//*[text()='2024']/.././../..//*[@class='slds-cell-edit cellContainer'])[5]";

    static String ClickApplication = "//span[text()='Applications']";
    static String SearchForAppliacant = "(//input[@type='search'])[2]";
    static String clickTheApplicanetName = "//a[@title='test Student']";
    static String clickonAppliations = "//a[@data-label='Applications']";
    static String clickApplicationView = "//a[text()='Application View']";
    static String clickApplicatioID = "//span[text()='APP-1714']";
    static String clickDelete = "(//button[text()='Delete'])[2]";
    static String ClickProfileForLogout = "//span[@data-aura-rendered-by='6:519;a']";
    static String ClickLOgout = "//a[text()='Log Out']";
    // workbench
    static String clickEnvronment = "//select[@id='oauth_env']";
    static String selectSandbox = "//option[@value='test.salesforce.com']";
    static String checkBox = "//input[@id='termsAccepted']";
    static String LoginSalesforce = "//input[@id='loginBtn']";
    static String entertheURL = "//input[@id='urlInput']";
    static String clickExecute = "//input[@id='execBtn']";
    static String clickapplicant = "//li[text()='applicant']";
    static String getEmail = "//li[text()='alternateEmail: ']";
    static String getFirstName = "//li[text()='firstName: ']";
    static String getMiddlName = "//li[text()='middleName: ']";
    static String getLastName = "//li[text()='lastName: ']";

    // error xpath
    static String errorpassport1 = "//p[text()='Please Input a valid Passport Number']";
    static String errorpassport2 = "//p[text()='This field cannot be more than 12 characters']";
    static String errorstreet1 = "//p[text()='This field cannot be more than 200 characters']";
    static String errorstreet2 = "//p[text()='Please input a correct value']";
    static String errorzipcode1 = "//p[text()='Please Input a valid Zipcode']";
    static String errorzipcode2 = "//p[text()='This field cannot be more than 10 characters']";
    static String errorfname1 = "//p[text()='This field cannot be more than 40 characters']";
    static String errorfname2 = "//p[text()='Please Input a valid First Name']";
    static String errorlname1 = "//p[text()='This field cannot be more than 40 characters']";
    static String errorlname2 = "//p[text()='Please Input a valid Last Name']";
    static String errorage1 = "//p[text()='This field cannot be more than 3 digits']";
    static String errorage2 = "//p[text()='Please Input a valid Age']";
    static String erroremail1 = "//p[text()='Please Input a valid Email']";
    static String erroroccupation1 = "//p[text()='This field cannot be more than 80 characters'] | //p[text()='This field cannot be more than 20 characters'] | //p[text()='Please Input a valid value']";

    static String erroroccupation2 = "//p[text()='Please Input a valid value']";
    static String errorincome1 = "//p[text()='Please Input a correct Income']";
    static String errorincome2 = "//p[text()='This field cannot be more than 15 characters']";
    static String errorcompany1 = "//p[text()='This field cannot be more than 100 characters']";
    static String errorcompany2 = "//p[text()='Please input a correct value.']";
    static String errordestination1 = "//p[text()='This field cannot be more than 80 characters']";
    static String errordestination2 = "//p[text()='Please input a correct value.']";
    static String errorroles1 = "//p[text()='This field cannot be more than 80 characters']";
    static String errorroles2 = "//p[text()='Please input a correct value.']";
    static String errormonths1 = "//p[text()='This field cannot be more than 3 characters']";
    static String errormonths2 = "//p[text()='Please input a correct value.'] | //p[text()='This field cannot be more than 3 characters']";
    static String errrosalary1 = "//p[text()='This field cannot be more than 15 characters']";
    static String errrosalary2 = "//p[text()='Please input a correct value'] | //p[text()='This field cannot be more than 3 characters'] | //p[text()='This field cannot be more than 15 characters']";
    static String errorUniversity = "//p[text()='Please Input a correct value.'] | //p[text()='This field cannot be more than 5 characters']";
    static String error40charUniverisy = "//p[text()='This field cannot be more than 40 characters'] | //p[text()='This field cannot be more than 80 characters'] | //p[text()='This field cannot be more than 5 characters']";
    static String errorCollege = "//p[text()='Please Input a correct value.']";
    static String error40charCollege = "//p[text()='This field cannot be more than 40 characters'] | //p[text()='This field cannot be more than 80 characters'] | //p[text()='This field cannot be more than 5 characters']";

    static String errorSpecailCharPercentage = "//p[text()='Please Input a correct value'] | //p[text()='This field cannot be more than 5 characters'] ";
    static String error80CharPercentage = "//p[text()='This field cannot be more than 7 characters'] | //p[text()='This field cannot be more than 5 characters']";
    static String errorSchool = "//p[text()='Please input a correct value'] | //p[text()='This field cannot be more than 80 characters']";

    // sf check
    static String clickcontacts = "//*[text()='Contacts']";
    static String contacts = "//b[text()='Contacts']";
    static String ClickApplicationtab = "//a[text()='Applications']";
    static String ClickEdit = "(//button[@type='button' and text()='Edit'])[3]";
    static String passportcheck = "(//lightning-formatted-text[@slot='outputField'])[9]";

    // static String passportcheck = "//*[text()='Passport
    // Number']/..//*[@type='text']";
    static String Nationalitycheck = "(//lightning-formatted-text[@slot='outputField'])[16]";
    static String emailcheck = "(//input[@class='slds-input'])[24]";
    static String dobcheck = "(//input[@class='slds-input'])[9]";

    static String citycheck = "(//lightning-formatted-text[@slot='outputField'])[57]";

    static String fnamecheck = "(//input[@class='slds-input'])[21]";
    static String agecheck = "(//input[@class='slds-input'])[25]";
    static String incomecheck = "(//input[@class='slds-input'])[28]";
    static String pgpercentagecheck = "(//*[text()='Percentage/CGPA']/..//*[@type='text'])[1]";
    static String hscpercentagecheck = "(//*[text()='Final CGPA/GPA/Grade/Percentage']/..//*[@type='text'])[1]";
    static String sslcpercentagecheck = "(//*[text()='Final CGPA/GPA/Grade/Percentage']/..//*[@type='text'])[2]";
    static String extraactivitiescheck = "//*[text()='Extra Curricular Activities(Social/Political/Personal etc)']/..//*[@type='text']";
    static String bdcountry = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String pgdegreeselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String pgcountryselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String pgstateselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String pgcityselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String ugdegreeselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String ugcountryselect = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String selectxpath = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li//div//div";
    static String clickondrop = "//a[@role='button'  and @title='Show 2 more actions']";
    static String delete = "//a[@title='Delete']";
    static String Delete2 = "//span[text()='Delete']";
    static String viewAll = "//span[text()='View All']";
    static String sfviewall = "(//span[text()='View All'])[1]";
    // documents
    static String clickdocument = "//*[text()='Documents']";
    static String selectdocumnentdropdown = "//*[@id='panel1a-header']";
    static String mark12view = "(//*[text()='Std 12th Mark sheet']/../..//*[local-name()='svg'])[2]";
    static String mark12download = "(//*[text()='Std 12th Mark sheet']/../..//*[local-name()='svg'])[1]";

    static String mark10sheetupload = "(//input[@type='file'])[1]";
    static String mark10view = "(//*[text()='Std 10th Mark sheet']/../..//*[local-name()='svg'])[2]";
    static String mark10download = "(//*[text()='Std 10th Mark sheet']/../..//*[local-name()='svg'])[1]";
    static String degreemarkupload = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[3]";
    static String degreemarkview = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[2]";
    static String degreemarkdownload = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[1]";
    static String photoupload = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[3]";
    static String photoview = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[2]";
    static String photodownload = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[1]";

    // error
    static String passporterror = "//*[text()='Passport Number']/../../../..//P";
    static String addresserror = "(//*[text()='Permanent Address']/../../../..//P)[3]";
    static String pincodeerror = "//*[text()='PIN / PO BOX/ ZIP']/../../../..//P";
    static String fnameerror = "//*[text()='First Name']/../../../..//P";
    static String lnameerror = "//*[text()='Last Name']/../../../..//P";
    static String emailerror = "//*[text()='Email']/../../../..//P";
    static String ageerror = "//*[text()='Age']/../../../..//P";
    static String occupationerror = "//*[text()='Occupation']/../../../..//P";
    static String incomeerror = "//*[text()='Annual Income']/../../../..//P";
    static String companyerror = "//*[text()='Company']/../../../..//P";
    static String designationerror = "//*[text()='Designation']/../../../..//P";
    static String roleserror = "//*[text()='Roles/ KRA']/../../../..//P";
    static String monthserror = "//*[text()='Experience in Months']/../../../..//P";
    static String annualerror = "//*[text()='Annual Salary']/../../../..//P";
    static String pguniversityerror = "//*[text()='University']/../../../..//P";
    static String pgcollegeerror = "//*[text()='College']/../../../..//P";
    static String pgpercentageerror = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";

    static String uguniversityerror = "//*[text()='University']/../../../..//P";
    static String ugcollegeerror = "//*[text()='College']/../../../..//P";
    static String ugpercentageerror = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String ugmark1error = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String ugmarktotalmark1error = "//*[text()='Maximum CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String ugmark2error = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String ugmarktotalmark2error = "//*[text()='Maximum CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String hscpercentageerror = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String hscschoolerror = "//*[text()='School Name']/../../../..//P";
    static String sslcpercentageerror = "//*[text()='Final CGPA/GPA/Grade/Percentage/Points']/../../../..//P";
    static String sslcschoolerror = "//*[text()='School Name']/../../../..//P";
    static String sportsaccivemeterror = "//*[text()='Sport Achievement']/../../../..//P";
    static String professsionalerror = "//*[text()='Professional Achievement']/../../../..//P";
    static String Extracurricularerror = "//*[text()='Extra Curricular Activities (social, political, personal etc)']/../../../..//P";
    static String Exceptionalerror = "//*[text()='Exceptional Academic Achievements']/../../../..//P";
    static String statementerror = "//*[text()='Statement of purpose (Max 2000)']/../../../..//P";
    static String masterdegreeerror = "//*[text()='What do you plan to do after finishing a master’s degree at S P Jain?']/../../../..//P";

    // static String deletesf =
    // "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div//table/tbody/tr";
    static String deletecount = "(//*[@class='countSortedByFilteredBy'])[2]";
    static String deletecount1 = "//*[@class='countSortedByFilteredBy']";

    static String deletesf = "(//*[text()='2023']/../../..//*[local-name()='svg']/../../..)[1]";
    static String delete2022 = "(//*[text()='2022'])[1]";
    static String delete2023 = "(//*[text()='2023'])[1]";
    // static String table =
    // "//*[@id='brandBand_2']/div/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody";

    static String deletesf1 = "(//*[text()='2022']/../../..//*[local-name()='svg']/../../..)[1]";

    static String admissionportal = "//input[@name='id']";
    static String submitbutton = "//button[@type='submit']";
    static String fees = "//span[.='Fee Payments']";
    static String pay = "//button[@label='Pay Now']";
    static String paynow = "//button[@data-testid='button']";
    static String next = "//span[.='Next']";
    static String trusty = "//h3[.='trustly test']/../../../..//button";
    static String email = "//input[@id='sender_email']";
    static String fname = "//input[@id='sender_first_name']";

    static String familyname = "//input[@id='sender_last_name']";

    static String address1 = "//input[@id='sender_address1']";

    static String city1 = "//input[@id='sender_city']";

    static String phno = "//input[@id='sender_phone']";

    static String terms = "//input[@id='terms-conditions']";

    static String dob1 = "//input[@id='student_date_of_birth']";

    static String pay2btn = "//span[.='Pay']";
    static String divhsbcuk = "(//div[@class='sc-gXfVKN iaWjVc'])[2]";
    static String continuex = "//span[text()='Continue']";
    static String loginid = "//input[@name='loginid']";
    static String otpcapture = "//h3[@class='sc-dlnjwi dRMjYq']";

    static String password = "//input[@type='password']";

    static String continuebutton = "//button[@data-testid='continue-button']";

    static String returnhome = "//button[@data-testid='returnCallToActionButton']";

    // static String EnterEmail = "//input[@name='id' or @placeholder='Please enter
    // your Email Id']";
    // static String Verify = "//button[text()='Verify']";
    // static String Verifylogin = "//button[text()='Verify & Log In']";
    // static String Inputotp = "//input[@aria-label='Please enter verification
    // code. Digit 1']";

    //// ....................................salesforce
    //// backend......................................................////

    static String salesusername = "//input[@id='username']";

    static String salespassword = "//input[@type='password']";

    static String saleslogin = "//input[@id='Login']";

    // static String gradeType = "(//[text()='Evaluation
    // Type']/../../../..//[local-name()='svg'])[3]/../..";
    static String gradeType1 = "(//div[@id='outlined-select-currency'])[16]";
    // static String sslcgrade = "(//[text()='Evaluation
    // Type']/../../../..//[local-name()='svg'])[4]/../..";
    static String sslcgrade1 = "(//div[@aria-labelledby='outlined-select-currency'])[22]";

    static String deletesf_1 = "(//*[. and contains(text(), '202')])[3]";
    static String clickondots = "//div[@class='slds-icon-waffle']";
    static String spadmin = "//p[.='SP Jain Admissions']";
    static String offer = "//span[@title='Offer letter accepted']";

    static String application = "(//a[.='Applications'])[2]";
    static String window = "(//div[@class='slds-truncate'])[3]";
    static String dobfe = "//input[@id='student_date_of_birth']";

    //// .........................bmjalnagar basic details
    //// xpath.................................................////

    static String childfirstName = "//input[@name='applicant[firstName]']";
    static String childMiddleName = "//input[@name='applicant[middleName]']";
    static String childlastName = "//input[@name='applicant[lastName]']";

    static String placeofbirth = "//input[@name='applicant[birthPlace]']";
    static String mothertongue = "//input[@name='applicant[motherTongue]']";
    static String numberOfSiblingsInSchool = "//input[@name='applicant[numberOfSiblingsInSchool]']";
    static String childaadharNumber = "//input[@name='applicant[aadharNumber]']";
    static String satsNumber = "//input[@name='applicant[satsNumber]']";

    static String clickonbloodgroup = "(//div[@id='outlined-select-currency'])[1]";
    static String Selectbloodgroup = "//li[@data-value='B+']";

    static String clickonTransport = "(//div[@id='outlined-select-currency'])[2]";
    static String selecttransport = "//li[@data-value='Yes']";

    static String clickonTrip = "(//div[@id='outlined-select-currency'])[3]";
    static String selecttrip = "//li[@data-value='One Way']";
    static String pickuppoint = "//input[@name='applicant[pickupPoint]']";

    static String clickonnationality = "(//div[@id='outlined-select-currency'])[4]";
    static String selectnationality1 = "//li[@data-value='Indian']";

    static String clickonreligion = "(//div[@id='outlined-select-currency'])[5]";
    static String selectreligion = "//li[@data-value='Buddhist']";

    static String clickoncategory = "(//div[@id='outlined-select-currency'])[6]";
    static String selectcategory = "//li[@data-value='OBC']";

    static String childcaste = "//input[@name='applicant[caste]']";
    static String childsubcaste = "//input[@name='applicant[subcaste]']";

    static String clickonsubmit = "//button[@type='submit']";

    /// ........................family details
    /// bmjalnagara..................................////

    static String parentclickonrelationship = "(//*[@id='outlined-select-currency'])[1]";
    static String parentsselectrelationship = "//li[@data-value='Father']";
    static String parentfirstName = "//input[@id='mui-17']";
    static String parentlastName = "//input[@id='mui-19']";
    static String Parentmiddlename = "//input[@id='mui-18']";

    static String familyphone = "//input[@placeholder='Enter Number']";

    static String familyemail = "//input[@id='mui-20']";
    static String familyaadhara = "//input[@id='mui-21']";

    static String clickonQualification = "(//*[@id='outlined-select-currency'])[2]";
    static String Selecteducation = "//li[@data-value='Under Graduate']";
    static String mnameerror = "//*[text()='Middle Name']/../../../..//P";
    static String childdob = "//input [@name='applicant[dateOfBirth]']";
    static String clickonoccuption = "(//*[@id='outlined-select-currency'])[3]";
    static String Selectoccuption = "//li[@data-value='Salaried']";

    static String familyannualincome = "//input[@id='mui-22']";

    /////////////// ......................course details xpath
    /////////////// jalnagara............................////////

    static String clickoncoursecountry = "(//*[@id='outlined-select-currency'])[1]";
    static String selectcoursecountry = "//li[@data-value='India']";

    static String clickoncoursestate = "(//*[@id='outlined-select-currency'])[2]";
    static String selectcoursestate = "//li[@data-value='Manipur']";

    static String clickoncoursecity = "(//*[@id='outlined-select-currency'])[3]";
    static String selectcoursecity = "//li[@data-value='Kakching']";

    static String coursepincode = "//input[@name='addresses[0][mailingPostalCode]']";

    static String clickoncourseaddress = "(//*[@id='outlined-select-currency'])[4]";
    static String selectcourseaddress = "//li[@data-value='true']";

    //// ..........................education
    //// jalnangar..................................////

    static String clickoneducationclass = "(//*[@id='outlined-select-currency'])[1]";
    static String selectclass = "//li[@data-value='UKG']";

    static String eduschool = "//input[@name='applicant[previousSchool]']";

    static String clickonmedium = "(//*[@id='outlined-select-currency'])[2]";
    static String selectmedium = "//li[@data-value='Kannada']";

    static String clickonflanguage = "(//*[@id='outlined-select-currency'])[3]";
    static String selectflanguage = "//li[@data-value='Sanskrit']";

    static String clickonslanguage = "(//*[@id='outlined-select-currency'])[4]";
    static String selectslanguage = "//li[@data-value='English']";

    static String clickonsTlanguage = "(//*[@id='outlined-select-currency'])[5]";
    static String selectTlanguage = "//li[@data-value='Telugu']";

    //// .............................document upload xpath
    //// bmpjalnagara...............................////

    static String passportupload = "(//input[@type='file'])[1]";
    static String stdupload = "(//input[@type='file'])[2]";
    static String sbmpdot = "//p[.='Admissions Jalnagar']";

    //// ................................summary and
    //// declaration......................................./////

    //// ..............................ltpct
    //// xpath....................................................../////

    static String firstname = "//input[@name='firstName']";
    static String middlename = "//input[@name='middleName']";
    static String lastName2 = "//input[@name='lastName']";
    static String email2 = "//input[@name='email']";
    static String mobile = "//input[@name='mobile']";
    static String mobilePhone = "//input[@name='mobilePhone']";
    static String dob2 = "//input[@name='dob']";
    static String clickonstate = "//div[@aria-labelledby='mui-component-select-state']";
    // static String selectstate = "//li[.='Goa']";
    static String state2 = "Goa";
    static String stateselect = "//li[@data-value='Goa']";

    static String clickoncity = "//div[@aria-labelledby='mui-component-select-city']";
    static String selectcity = "//li[.='North Goa']";
    static String taluku = "//div[@aria-labelledby='mui-component-select-tehsil']";

    static String gramPanchayat = "//div[@aria-labelledby='mui-component-select-gramPanchayat']";
    static String village = "//input[@name='village']";
    static String hamlet = "//input[@name='hamlet']";
    static String referalname = "//input[@name='referralName']";
    static String clickonqualification = "//div[@aria-labelledby='mui-component-select-qualifications']|//div[@aria-labelledby='mui-component-select-educationQualification']";
    static String selectqualification = "//li[.='10th Pass']|//li[.='12th']";

    static String clickonApplyto = "//div[@aria-labelledby='mui-component-select-courseList']";
    static String selectapply = "//li[.='Welder']";

    static String clickonreferral = "//div[@aria-labelledby='mui-component-select-referralList']";
    static String selectreferral = "//li[.='Local Leader']";

    static String clickonmobiliser = "//div[@aria-labelledby='mui-component-select-mobiliser']";
    static String selectmobiliser = "//li[.='Dhrumin Thakorbhai Dhangar']";

    static String clickonreligion2 = "//div[@aria-labelledby='mui-component-select-religion']";
    static String selectreligion2 = "//li[.='Hindu']";

    static String clickoncaste = "//div[@aria-labelledby='mui-component-select-caste']";
    static String selectcaste = "//li[.='OBC']";

    static String clickoncheckbox = "//input[@type='checkbox']";

    static String clickonsybmit = "//span[.='Submit']";

    ///////////// ....................salesforce..................................//////

    static String username = "//input[@name='username']";
    static String password2 = "//input[@name='pw']";
    static String logintosalesforce = "//input[@name='Login']";
    static String clickondropdown = "//button[@title='Select a List View']";
    static String clickonrequiredselect = "//select[@class='stepAction required-field select']";

    ///// ................................Application.........................................///

    static String religion = "//input[@name='Religion']";

    static String age = "//input[@name='Age']|//input[@name='age']";

    static String Village = "//input[@name='Village']";

    public static String addphone = "//input[@name='phone']";

    static String getotp = "//span[.='Get OTP']";

    static String enterotp = "//input[@name='userOTP']";
    static String clickongo = "//span[.='Go']";

    static String clickonnewapplication = "//span[.='New Application']";

    static String clickonapply = "//div[.='Office Assistant']/../..//button";

    static String clickonyes = "//span[.='Yes']";

    // static String firstname1 = "//input[@name='firstName']";
    static String surename = "//input[@name='surName']";

    static String enterfathername = "//input[@name='fatherName']";

    static String clickoncaste1 = "//div[@id='mui-component-select-Caste']";
    static String selectcaste1 = "//li[.='OBC']";

    static String enterdob = "//input[@name='dob']";

    static String presentoccupation = "//input[@name='presentOccupation']";
    static String gramPanchayat1 = "//input[@name='Gram_Panchayat']";
    static String entermothername = "//input[@name='Mother_Name']";
    static String enterguardianname = "//input[@name='Guardian_Name']";

    static String Hamlet = "//input[@name='Hamlet']";

    static String enterhobbies = "//input[@name=' Hobbies_Special_Interest']";

    static String clickonbloodgroup2 = "//div[@id='mui-component-select-bloodGroup']";
    static String selectbloodgroup = "//li[.='A+']";

    static String clickonmale = "//span[.='Male']";

    static String clickonnext = "//span[.='Next']";

    static String noOfFamilymembers = "//input[@name='noOfFamilymembers']";
    static String noOfFamilymembersAdults = "//input[@name='noOfFamilymembersAdults']";

    static String noOfFamilymembersChildren = "//input[@name='noOfFamilymembersChildren']";
    static String workingMembers = "//input[@name='workingMembers']";

    static String nonWorkingMembers = " //input[@name='nonWorkingMembers']";
    static String familyIncome = "//input[@name='familyIncome']";

    static String clickonmaritalstatus = "//div[@id='mui-component-select-maritalStatus']";
    static String selectmaritalstatus = "//li[.='Single']";

    static String clickonanyImpInformation = "//div[@id='mui-component-select-anyImpInformation']";
    static String selectanyImpInformation = "//li[.='Single parent']";

    static String clickon2ndnext = "//span[.='Next']";

    static String address2 = "//input[@name='addresses[0].MailingStreet']";
    static String pincode = "//input[@name='addresses[0].MailingPostalCode']";

    static String clcikonaddresscheckbox = "//input[@name='addressFlag']";

    static String clickon3rdnext = "//span[.='Next']";

    static String startingdate = "(//input[@placeholder='MM/DD/YYYY'])[1]";
    static String joiningdate = "(//input[@placeholder='MM/DD/YYYY'])[2]";

    static String enddate = "(//input[@placeholder='MM/DD/YYYY'])[3]";
    static String iwanttojoin = "//input[@name=\"educations[0]['joinCourse']\"]";
    static String aftercompletion = "//input[@name=\"educations[0]['afterCompletion']\"]";

    static String clickon4thnext = "//span[.='Next']";

    static String uploadpassport = "(//input[@type='file'])[1]";

    static String uploadaddhar = "(//input[@type='file'])[3]";
    static String uploadschoolleaving = "(//input[@type='file'])[4]";

    static String clickon5thnext = "//span[.='Next']";

    static String clickoncheckbox1 = "//input[@type='checkbox']";
    static String clickon6thnext = "//span[.='Next']";

    static String clickonsubmit2 = "//span[.='Submit']";

    static String addcity = "//input[@name='addresses[0].MailingCity']";

    static String clickoncountry = "(//div[@id='country'])[1]";
    static String selectcountry2 = "//li[.='Barbados']";

    static String clickoncountry1 = "(//div[@id='country'])[2]";
    static String selectcountry1 = "//li[.='Barbados']";

    static String clickonstate1 = "(//div[@id='state'])[1]";
    static String selectstate1 = "//li[.='Saint James']";

    static String clickonsignout = "//span[.='Sign out']";

    static String clickonbatch = "//div[@id=\"mui-component-select-educations[0]['Batch']\"]";
    static String selectbatch = "//li[.='June']";

    static String qualification = "//input[@name=\"educations[0]['Qualification']\"]";

    static String finicial = "//input[@name=\"educations[0]['FinancialYear']\"]";

    /// ............................ upload file xpath.........................///

    static String passport2 = "//input[@type='file']";
    static String addhar = "(//input[@type='file'])[3]";
    static String school = "(//input[@type='file'])[4]";
    //// ..................................nsome
    //// xpath................................................../////

    static String course = "//div[@id='mui-component-select-academicPrograms']";

    //// ...................................essci
    //// xpath................................................////

    static String trainingcenter = "//div[@id='mui-component-select-college']";
    static String selecttrainingcenter = "//li[.='NSIC, Delhi']";

    static String aadhar = "//input[@name='adharCardNumber']";
    static String course1 = "//div[@id='mui-component-select-course']";
    static String selectcourse = "//li[.='Big Data']";
    static String qualif = "//div[@id='mui-component-select-educationQualification']";
    static String selectqualif = "//li[.='Big Data']";

    static String ageselect = "//input[@name='age']";

    static String enquiry = "//input[@name='pleaseStateYourRequest']";

    static String clickoncheckox = "//span[@component-root='[object Object]']";

    //// ...........................new add elements xpath in
    //// ltpct.......................................////

    static String bankholder = "//input[@name='bankAccountHolder']";
    static String bankname = "//input[@name='bankName']";

    static String branchname = "//input[@name='branchName']";

    static String ifsccode = "//input[@name='ifscCode']";

    static String selectstate2 = "(//div[@aria-labelledby='state'])[1]";

    //// ............................validation
    //// xpath..........................................................////

    static String erorxpath = "//span[@style='color: rgb(185, 37, 0);']";

    //// .................................bmp-jhamkandi......................................................./////

    static String registration = "//p[.='Already Registered? Sign In']";
    static String apply = "(//span[.='Apply Now'])[1]";
    static String clickongo1 = "//span[.='Go']";
    static String clickonyes1 = "//span[.='Yes']";

}