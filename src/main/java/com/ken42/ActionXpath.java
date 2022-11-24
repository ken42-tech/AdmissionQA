package com.ken42;

public class ActionXpath {
    static String EnterEmail = "//input[@name='id' or @placeholder='Please enter your Email Id']";
    static String Verify = "//button[text()='Verify']";
    static String Verifylogin = "//button[text()='Verify & Log In']";
    static String Inputotp = "//input[@aria-label='Please enter verification code. Digit 1']";
    static String Apply = "(//button[text()='Apply Now'])[2]";
    static String ClickDropDepartment = "//html/body/div/div/div/div/main/div[1]/div[3]/div[1]/div/div/div/div[1]/div/div/div/div";
    static String selectPost = "(//div[text()='All Departments'])[2]";
    static String ClickPorogrameDrop = "(//div[@aria-haspopup='listbox'])[2]";
    static String selectPrograme = "//li[@role='option']";
    static String ApplyNow = "//button[text()='Apply']";
    static String ClickNext = "//button[text()='Next']";
    static String Selectmentor = "(//*[@id='outlined-select-currency'])[1]";
    static String selectYes = "//li[@data-value='Yes'] | //li[@data-value='true']";
    static String SelectCampus = "//div[text()='EMBA Combination 1']";
    static String Campus = "(//*[@id='outlined-select-currency'])[2]";
    static String selectSpecilization = "//div[text()='EMBA Marketing']";
    static String Specilization = "(//*[@id='outlined-select-currency'])[3]";

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
    static String pgedttype = "(//*[@id='outlined-select-currency'])[1]";
    static String pgselectedttype = "//*[text()='Full time']";
    static String pgdegree = "(//*[@id='outlined-select-currency'])[2]";
    static String pgselectdegree = "//*[text()='Bachelor of Fine Arts (BFA)']";
    static String pgcountry = "(//*[@id='outlined-select-currency'])[3]";
    static String pgselectcountry = "//*[text()='India']";
    static String pgstate = "(//*[@id='outlined-select-currency'])[4]";
    static String pgselectstate = "//*[text()='Karnataka']";
    static String pgcity = "(//*[@id='outlined-select-currency'])[5]";
    static String pgselectcity = "//*[text()='Bangalore Rural']";

    // ug
    static String EducationType = "(//*[@id='outlined-select-currency'])[4]";
    static String country3 = "(//*[@id='outlined-select-currency'])[6]";

    static String ugyear = "//*[@name='educationHistories[1][yearOfPassing]']";
    static String uguniversity = "//*[@name='educationHistories[1][institutionName]']";
    static String ugcollege = "//*[@name='educationHistories[1][placeOfStudy]']";
    static String ugpercentage = "//*[@name='educationHistories[1][obtainedMarks]']";
    static String ugedtype = "(//*[@id='outlined-select-currency'])[6]";
    static String ugselectedtype = "(//*[text()='Full time'])[2]";
    static String ugdegree = "(//*[@id='outlined-select-currency'])[7]";
    static String ugselectdegree = "//*[text()='Bachelor of Management Science (BMS)']";
    static String ugcountry = "(//*[@id='outlined-select-currency'])[8]";
    static String ugselectcountry = "//*[text()='India']";
    static String ugstate = "(//*[@id='outlined-select-currency'])[9]";
    static String ugselectstate = "//*[text()='Karnataka']";
    static String ugcity = "(//*[@id='outlined-select-currency'])[10]";
    static String ugselectcity = "//*[text()='Bangalore Rural']";
    static String ugtype = "(//*[@id='outlined-select-currency'])[11]";
    static String ugselecttype = "//*[text()='Year']";
    static String ugyear1 = "(//*[@id='outlined-select-currency'])[12]/../../../..//*[local-name()='svg']";
    static String ugselectyear1 = "//*[text()='Year 1']";
    static String ugmark1 = "//*[@name='educationHistories[1][yearwiseMarks].0.yearMarks']";
    static String ugmaxmark1 = "//*[@name='educationHistories[1][yearwiseMarks].0.yearMaxMarks']";
    static String ugyear2 = "(//*[@id='outlined-select-currency'])[13]";
    static String ugselectyear2 = "//*[text()='Year 2']";
    static String ugmark2 = "//*[@name='educationHistories[1][yearwiseMarks].1.yearMarks']";
    static String ugmaxmark2 = "//*[@name='educationHistories[1][yearwiseMarks].1.yearMaxMarks']";
    // 12
    static String hscedtype = "(//*[@id='outlined-select-currency'])[14]";
    static String hscselectedtype = "(//*[text()='Full time'])[3]";
    static String hscboard = "(//*[@id='outlined-select-currency'])[15]";
    static String gradeType="(//*[@id='outlined-select-currency'])[16]";
    static String hscselectboard = "(//*[text()='KARNATAKA SECONDARY EDUCATION, EXAMINATION BOARD'])[1]";
    static String hscgrade = "(//*[@id='outlined-select-currency'])[16]";
    static String hscgradeselect = "(//*[text()='Grade'])[1]";
    static String hscpercentage = "//*[@name='educationHistories[2][obtainedMarks]']";
    static String hscyear = "//*[@name='educationHistories[2][yearOfPassing]']";
    static String hscschool = "//*[@name='educationHistories[2][placeOfStudy]']";
    static String hsccountry = "(//*[@id='outlined-select-currency'])[17]";
    static String hscselectcountry = "//*[text()='India']";
    static String hscstate = "(//*[@id='outlined-select-currency'])[18]";
    static String hscselectstate = "//*[text()='Karnataka']";
    static String hsccity = "(//*[@id='outlined-select-currency'])[19]";
    static String hscselectcity = "//*[text()='Bangalore Rural']";

    // 10
    static String sslcedtype = "(//*[@id='outlined-select-currency'])[20]";
    static String sslcselectedtype = "(//*[text()='Full time'])[4]";
    static String sslcboard = "(//*[@id='outlined-select-currency'])[21]";
    static String sslcselectboard = "//*[@name='educationHistories[0][yearOfPassing]']";
    static String sslcgrade = "(//*[@id='outlined-select-currency'])[22]";
    static String sslcselectgrade = "//*[text()='CGPA']";
    static String sslcpercentage = "//*[@name='educationHistories[3][obtainedMarks]']";
    static String sslcyear = "//*[@name='educationHistories[3][yearOfPassing]']";
    static String sslcschool = "//*[@name='educationHistories[3][placeOfStudy]']";
    static String sslccountry = "(//*[@id='outlined-select-currency'])[23]";
    static String sslcselectcountry = "//*[text()='India']";
    static String sslcstate = "(//*[@id='outlined-select-currency'])[24]";
    static String sslcselectstate = "//*[text()='Karnataka']";
    static String sslccity = "(//*[@id='outlined-select-currency'])[25]";
    static String sslcselectcity = "//*[text()='Bangalore Rural']";
    // static String clicknext="//*[text()='Next']";
    // Tc-7
    static String SportAchievement = "//*[@name='application[sportsAchievements]']";
    static String ProfessionalAchievement = "//*[@name='application[professionalAchievements]']";
    static String CurricularActivities = "//*[@name='application[extraCurricularActivities]']";
    static String AcademicAchievements = "//*[@name='application[exceptionalAcademicAchievements]']";
    static String fundeducation = "(//*[@id='outlined-select-currency'])[1]";
    static String fundselecteducation = "//*[text()='Self-funding + Bank Loan']";
    static String physicallychallenged = "(//input[@name='applicant[isDifferentlyAbled]'])[2]";
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
    static String selecthearspjain = "//*[text()='TV / Radio']";
    static String refrence = "(//*[text()='No'])[8]";
    static String hscgradeselect = "(//*[text()='Grade'])[1]";
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
    static String erroroccupation1 = "//p[text()='This field cannot be more than 80 characters'] | //p[text()='This field cannot be more than 20 characters']";
    static String erroroccupation2 = "//p[text()='Please Input a valid value']";
    static String errorincome1 = "//p[text()='Please Input a correct Income']";
    static String errorincome2 = "//p[text()='This field cannot be more than 18 characters']";
    static String errorcompany1 = "//p[text()='This field cannot be more than 100 characters']";
    static String errorcompany2 = "//p[text()='Please input a correct value.']";
    static String errordestination1 = "//p[text()='This field cannot be more than 80 characters']";
    static String errordestination2 = "//p[text()='Please input a correct value.']";
    static String errorroles1 = "//p[text()='This field cannot be more than 80 characters']";
    static String errorroles2 = "//p[text()='Please input a correct value.']";
    static String errormonths1 = "//p[text()='This field cannot be more than 3 characters']";
    static String errormonths2 = "//p[text()='Please input a correct value.']";
    static String errrosalary1 = "//p[text()='This field cannot be more than 18 characters']";
    static String errrosalary2 = "//p[text()='Please input a correct value.']";
    static String errorUniversity = "//p[text()='Please Input a correct value.']";
    static String error40charUniverisy = "//p[text()='This field cannot be more than 40 characters']";
    static String errorCollege = "//p[text()='Please Input a correct value.']";
    static String error40charCollege = "//p[text()='This field cannot be more than 40 characters']";

    static String errorSpecailCharPercentage = "//p[text()='Please Input a correct value.']";
    static String error80CharPercentage = "//p[text()='This field cannot be more than 7 characters']";
    static String errorSchool = "//p[text()='Please Input a correct value.']";

    // sf check
    static String clickcontacts = "//*[text()='Contacts']";
    static String contacts="//b[text()='Contacts']";
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
<<<<<<< HEAD
    static String clickondrop="//a[@role='button'  and @title='Show 2 more actions']";
    static String delete="//a[@title='Delete']";
    static String Delete2="//span[text()='Delete']";
    static String viewAll="//span[text()='View All']";
=======
    static String clickondrop = "//a[@role='button'  and @title='Show 2 more actions']";
    static String delete = "//div[text()='Delete']";
    static String viewAll = "//span[text()='View All']";

    // documents
    static String clickdocument = "//*[text()='Documents']";
    static String selectdocumnentdropdown = "//*[@id='panel1a-header']";
    static String mark10sheetupload = "(//input[@type='file'])[1]";
    static String mark10view = "(//*[text()='Std 10th Mark sheet']/../..//*[local-name()='svg'])[2]";
    static String mark10download = "(//*[text()='Std 10th Mark sheet']/../..//*[local-name()='svg'])[1]";
    static String degreemarkupload = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[3]";
    static String degreemarkview = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[2]";
    static String degreemarkdownload = "(//*[text()='Marksheet of all years of Graduate Degree']/../..//*[local-name()='svg'])[1]";
    static String photoupload = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[3]";
    static String photoview = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[2]";
    static String photodownload = "(//*[text()='Passport Size Photo']/../..//*[local-name()='svg'])[1]";
>>>>>>> a2531575168a601d76981983f0997d0500b251fe
}