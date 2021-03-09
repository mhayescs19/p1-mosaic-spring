# p1-mosaic-spring: [Spring Website](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/)
Due to the AWS limit on maximum hours that the website can be run on its servers for its free tier version, we have implemented a schedule that **shuts down the website every night from 8:00pm to 8:00am on days mon-thu, but on fri-sun the server shuts down from 10:00pm to 8:00am**. Sorry for your inconvenience and thank you for your patience.

## Project Contributors
| Contributor | GitHub Link | Journal Link |
| ----------- | ----------- | ----------- | 
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Sara Beniwal | [@saraben21](https://github.com/saraben21) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)

## Runtime Guidance For "Not Synergy"
1. Click on "Not Synergy" on the bottom left hand side of the home page. <br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-Home-Page.png" height="auto" width="40%"> <br> <br>
2. You will be redirected to a login page. On the upper right corner of the page, click the "Sign Up" button to create an account.<br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-Login-Page.png" height="auto" width="40%"> <br> <br>
3. Correctly enter your name, username, password, year, and age in the resepctive input fields. Once done, click "Submit". <br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-CreateUser-Page.png" height="auto" width="40%"> <br> <br>
4. You will be redirected to a page that tells you that your login was successful. On the upper right hand corner, click the "Return to Login" button. <br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-Redirect-Page.png" height="auto" width="40%"> <br> <br>
5. Use your newly created username and password to login. If you have forgotten your username or password, you will need to create another account. After you login, you will be directed to a page with two links: "Teacher View" and "Student View". DO NOT CLICK "Teacher View". YOU DO NOT HAVE PERMISSION TO ACCESS THIS PAGE AS ALL NEW ACCOUNTS ARE GIVEN THE ROLE OF STUDENT. <br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-Link-Page.png" height="auto" width="40%"> <br> <br>
6. After clicking "Student View", you will be directed to your class schedule on "Student View". On the left hand side, there will be a navigation bar with different links for you to explore. Have fun! <br>
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/Compsci-StudentSchedule-Page.png" height="auto" width="40%"> <br> <br>

## ScrumBoard
<a href="https://github.com/mhayescs19/p1-mosaic-spring/projects/1"><img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/board-entire-button.png" width="30%" height="auto"><a/> 

## Project Idea
We  plan on making a synergy clone where teachers can view their students and give out grades and take roll call. Would also have two different views one for students another for teachers. Will be using AWS to host the website and associated databases. <br><br>

**Student View**
- Log-in system (StudentID, password)
- Side bar to access their own personal grades <br> <br>
**Gradebook:**
- Overview of all classes grades
- Click each class to view the individual grade of the class
- Table with: Date, Assignment, Score, Score Type, Points, Notes <br> <br>
**Student Info:**
- Name, grade, ID number, counselor name, GPA (specifically at a given instance)
- Static schedule <br> <br>
**School Information:**
- Name, Principal, Address, Website <br> <br> 

**Teacher View**
- Log-in system (Teacher username, password)
- Teacher modifies assignments and grades <br> <br>
**Gradebook (Teacher):**
- Create assignment categories with assignment weights
- Create assignment name and Input assignment points
- Backend code/JS to calculate percentage/letter grade and GPA
- Delete function for mistake and error correction <br> <br>
**Class Roster:**
- See students in their class (entire roster) with name, grade, ID, and high school year
- Table with: Date, Assignment, Score, Score Type, Points, Notes
- Filter with search function for students and grades <br> <br> 

## Project Plan (Rough)
**Week of 02/19:** Front End/CSS Styling/ Main Student-Teacher View Page Setup <br> 
**Week of 02/26:** BackEnd Java Code/Javascript and Connect to Database <br> 
**Week of 03/05:** Debugg/Add Other Features if Time Allows <br>

## 3/5  Weekly Project Contributions and Artifacts Log
### Week 12
### 1. [Complete Student Home Page](https://github.com/mhayescs19/p1-mosaic-spring/issues/25)
Displays a full student schedule with tester data using the class Class which holds period number, teacher name and class name attributes. Created by Michael Hayes.
* ThymeLeaf [for:each loop](https://github.com/mhayescs19/p1-mosaic-spring/blob/600c4ac64b912983e602a502cc9e0913d1957e3d/src/main/resources/templates/synergy/studentHome.html#L20-L45) used with [Class class](https://github.com/mhayescs19/p1-mosaic-spring/blob/600c4ac64b912983e602a502cc9e0913d1957e3d/src/main/java/com/example/project/MainController.java#L174-L183).
* Custom styling of table row, [note min-height/width](https://github.com/mhayescs19/p1-mosaic-spring/blob/600c4ac64b912983e602a502cc9e0913d1957e3d/src/main/resources/static/css/student-home.css#L54-L73), allows for table to uniform in height and width
<br><br>
**Runtime Guidance**
- Navigate to [/synergy/student/home](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/synergy/student/home) to view page (Note: page uses tester data so link may be deprecated and/or updated with live database data)

### 2. [Student Grades Home](https://github.com/mhayescs19/p1-mosaic-spring/issues/35)
Created a landing page hub to view all of a student's classes with grades displayed on corresponding tiles. Each tile displays period number, class and teacher name, and current grade. Created by Michael Hayes.
* Each tile is composed of multiple nested divs: 1) [wrapper](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/templates/synergy/studentGradesHome.html#L16-L29) (container for everything in tile), 2) [box](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/templates/synergy/studentGradesHome.html#L18-L20) ([styled](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/static/css/student-grades-home.css#L51-L71) to appear as main gray background), 3) [contentClassTitle](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/templates/synergy/studentGradesHome.html#L21-L24) ([styled](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/static/css/student-grades-home.css#L73-L79) lighter gray and holds class title and name), 4) [contentGrade](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/templates/synergy/studentGradesHome.html#L25-L27) ([styled](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/static/css/student-grades-home.css#L99-L104) in bottom of main gray background in tile)
* [Entire tile links](https://github.com/mhayescs19/p1-mosaic-spring/blob/40ad2c8947f729040da722281389021349c208a2/src/main/resources/templates/synergy/studentGradesHome.html#L16) to respective period detail grade view (old /synergy/student/gradeBook except now x5)
<br><br>

**Runtime Guidance**
- Navigate to [/synergy/student/grades/periodx](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/synergy/student/grades/period1) (Note: page uses tester data so link may be deprecated and/or updated with live database data)

### 3. [Teacher Info Web Scraper](https://github.com/mhayescs19/p1-mosaic-spring/issues/32)
Supports the school information page by pulling the teacher school emails from https://www.powayusd.com/en-US/Schools/HS/DNHS/Contacts/Staff-Directory. To avoid a CORS error, an API proxy was created using an HTTP Request to load the entire page from the DNHS reference to be called via AJAX on the School Information page. Created by Andrew Pegg and Michael Hayes.
* HTTP Request used to load the entire [raw reference HTML page](https://github.com/mhayescs19/p1-mosaic-spring/blob/38a7344822ca6e745b13aa16bc68297935550d10/src/main/java/com/example/project/ScraperAPI.java#L20-L24) as a String
* AJAX used inside of JavaScript which [pulls the HTML from our website](https://github.com/mhayescs19/p1-mosaic-spring/blob/38a7344822ca6e745b13aa16bc68297935550d10/src/main/resources/templates/synergy/schoolInformation.html#L34) (which holds the HTML from the DNHS teacher emails page) which is then [parsed](https://github.com/mhayescs19/p1-mosaic-spring/blob/38a7344822ca6e745b13aa16bc68297935550d10/src/main/resources/templates/synergy/schoolInformation.html#L35-L38) to only display the data inside of the table tag on the page.
* Data is injected into the [contacts-results](https://github.com/mhayescs19/p1-mosaic-spring/blob/38a7344822ca6e745b13aa16bc68297935550d10/src/main/resources/templates/synergy/schoolInformation.html#L49-L51) table on the School Information HTML page.
* Custom [styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/38a7344822ca6e745b13aa16bc68297935550d10/src/main/resources/static/css/school-information.css#L42-L66) gives the matches the table to the UI of our website. 
<br><br>

**Runtime Guidance**
- Navigate to [/synergy/student/schoolInformation](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/synergy/student/schoolInformation) to view page

## 2/26  Weekly Project Contributions and Artifacts Log
### Week 11
### 1. [Put Student](https://github.com/mhayescs19/p1-mosaic-spring/issues/27) and [Custom Login Page](https://github.com/mhayescs19/p1-mosaic-spring/issues/10)
Created a custom Spring Security Login in page which overrides default mapping. Worked with Andrew Pegg to successfully use AJAX to push student information data to an AWS database with validation through data-binding a java class. Created by Nakul Nandhakumar<br> <br>

**Contents**
* PostMapping for [putStudent](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L275) takes in passed [JSON Stringified](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L86) attributes of student from teacherView form
* [CSRF Token](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L64) allows for asynchronous post method call
* Created custom [Spring Security Login Page](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/login.html#L57) and overrided [default login page mapping](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/Security/SecurityConfig.java#L39), CSS styled the login form <br> <br>

**Runtime Guidance**
- Click "Synergy" on main navigation bar
- Login using Username: "1", Password: "test123" which gives Student access authorization
- Click "Student View"
- Explore through the different pages using the nav bar on the left hand side of the page

### 2. [Continue Student Info, Grade Detail View and Load Test Data](https://github.com/mhayescs19/p1-mosaic-spring/issues/20)
Added touch ups Student Info custom table with divs and tester static data. The Student Gradebook was created using the same ThymeLeaf for:each in which rows displayed using the Assignment class to pass the POJO to the front end. Created by Michael Hayes
<br><br>
**Contents**
* Assignments table fueled by [ArrayList of Assignments](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/java/com/example/project/MainController.java#L192-L199) that are displayed via the [TL for:each loop](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/resources/templates/synergy/studentGradebook.html#L39-L81)
* [Total grade](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/resources/templates/synergy/studentGradebook.html#L15-L22) custom [styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/resources/static/css/student-gradebook.css#L31-L49)
* [Class name](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/resources/templates/synergy/studentGradebook.html#L24-L32) custom [styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/3670fccb503e7bbfdd40ef81b134291d04702583/src/main/resources/static/css/student-gradebook.css#L50-L65)
<br><br>
**Runtime Guidance**
- Navigate to [/synergy/student/gradeBook](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/synergy/student/gradeBook) to view page (Note: page uses tester data so link may be deprecated and/or updated with live database data)

## 2/18  Weekly Project Contributions and Artifacts Log
### Week 10
### 1. [Student Contact Info Front End](https://github.com/mhayescs19/p1-mosaic-spring/issues/11)
Adaptation of a nav bar menu was combined with a custom table created using nested divs and CSS styling to create boxes for a table. Created by Michael Hayes <br> <br>
**Contents**
* Div class [studentInfo](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/static/css/student-info.css#L23) used to shift the header and table in the main content area to the right in order to fit the vertical nav bar to the left
* Nested divs used with the repeating div classes [wrapper](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/studentInfo.html#L20) and box in order to style each box the [same](https://github.com/mhayescs19/p1-mosaic-spring/blob/313d3439f6662f07ffb090a2e5b9e45bd257d1c7/src/main/resources/static/css/student-info.css#L41)
* [float: left](https://github.com/mhayescs19/p1-mosaic-spring/blob/313d3439f6662f07ffb090a2e5b9e45bd257d1c7/src/main/resources/static/css/student-info.css#L43) aligns all of the boxes to the left and prevents a margin appearing in between each box (other styling like display: inline-block caused the whitespace and prevented the boxes from lookin like a table) <br> <br>

**Runtime Guidance**
- Click "Synergy" on main navigation bar
- Click "Student View"
- Select "Student Info" in second navigation bar to view table

### 2. [Teacher View Front End](https://github.com/mhayescs19/p1-mosaic-spring/issues/12) & [Teacher View CSS Styling](https://github.com/mhayescs19/p1-mosaic-spring/issues/14)
Created form for teachers to enter student information and grade in their class for a class roster. Uses Michael's NavBar code and CSS Styling for background page styling and formatting for displaying students. Created by Nakul Nandhakumar. <br> <br>
**Contents**
* Created [Synergy Java Class File](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L53) with [Decorators](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/synergy/Synergy.java#L22-L36) from Mr. M's code for error checking and validation of attributes in form
* [Form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L49) using passed in [Thymleaf Objects](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L53) from Synergy Java Class File for validation, error message printing, and displaying entered form information
* [CSS Styling for Form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L7) using [div classes](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/synergy/teacherView.html#L33) and hover for the submit button <br> <br>

**Runtime Guidance**
- Click on "Synergy" on main navigation bar
- Click the "Teacher View" link
- Fill in form spaces and click submit to enter Student Info

### 3. [DataBase BackEnd Work](https://github.com/mhayescs19/p1-mosaic-spring/tree/master/src/main/java/Tools/DynamoDb)
This backend code will convert the return of dynmaodb to a javahashmap and convert a javahashmap into a hashmap accpetable by dynamodb<br>
seprate repo for code can be find here (https://github.com/andrewcomputsci2019/DynamoDbConverter)<br>
Demo for code can be found here (https://github.com/andrewcomputsci2019/DemoForConverter)<br>
No runtime for this as it is a service to be used by us during the project


## 2/05  Weekly Project Contributions and Artifacts Log
### Week 8
<!-- # [Tickets Video](https://drive.google.com/file/d/1hbOL0yeJWl4qi3kuO4QO8DL3UynJ-QnG/view?usp=sharing) -->
### 1. [Set Up Spring Boot Barebones Via JetBrains Tutorial + Example Nav Bar Imported](https://github.com/mhayescs19/p1-mosaic-spring/issues/1) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/#)
A basic menu was implemented. The main challenges was implementing the CSS styling. Temporary inline CSS styling was used to get the menu to function. Created by Michael Hayes <br>
**Contents** <br>
* Basic JetBrains tutorial + Mr. M example code with MainController.java was used to create a homepage with an [example menu](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/fragments/header.html) with [CSS styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/fragments/headfile.html#L14) (temporary inline CSS styling imported in headfile to header - Direct use of a .css file seems better).
* A [hyperlink list](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/menuAP.html#L54) on a page that is liked via the menu also sends the user to 4 separate pages that host some FRQs.

### 2. [Michael Display Unit 5 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/4) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/michael)
The PasswordGenerator class is implemented onto an HTML page with the corresponding inputs for a prefix and length of randomized string of characters to generate a unique password. Additionally the all of the generated passwords are also displayed via a table below the "interactable" area of the page. No CSS styling has been implemented yet. Created by Michael Hayes <br>
**Contents** <br>
* Similar [@GetParam decorators used](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/java/com/example/project/MainController.java#L65) for two separate variables in apPracticeMichael method in MainController.java
* Merged pali lab and table COVID19 api call HTML examples: used [two input fields in a single form](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L10) and [one table](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L19) (* see comments in michael.html as I shared my learning and remaining confusions about the HTML tags used)

### 3. [Nakul Display Unit 4 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/nakul)
The Unit 4 AP FRQ contained the directions for writing a class called Consecutive. There was only one part and that was to make a program in this class that takes a string, evaluates the number of times a character appears consecutively for each character in the string, and returns the character that appears the most consecutively and how many times it appeared. The input is taken and the result is displayed via an HTML page and CSS Styling was applied to make the page unique. Created by Nakul Nandhakumar <br>
**Contents** <br>
* [@GetParam Spring Command](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L65) and Thymeleaf Engine was used to receive information from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/nakul.html#L20) with user information entered
* [CSS Styling File](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) with text formatting, colors, etc. added for HTML page's paragrpahs, headers, div blocks, etc.
* [Thymeleaf Objects](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/nakul.html#L30) used to assign and display data to HTML page

### 4. [Nakul Javascript Pythagorean Lab](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/labs/Pythagorean)
Created a simple page that uses user input for the legs of a right triangle and uses the pythagorean theoream to calculate the hypotenuse of the right triangle. No CSS Styling for this page yet. Created by Nakul Nandhakumar <br>
**Contents** <br>
* [Pythagoras](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) HTML file for Pythagoreas
* [Embedded Javascript](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) using script tag that takes user input from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) for "a" and "b" values of right-triangle.
* [@GetMapping](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L75) to create root for menuLab and Pythagoras root page and added [LABS](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/fragments/header.html#L11) tab in header file to have the tab appear on the navigation bar.

### 5. [Andrew Frq1 web implementation](https://github.com/mhayescs19/p1-mosaic-spring/issues/3) - [WebPage](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/andrew)
Created a backend that able to intercept an java object using @ModelAttribute to capture the http request, with the given http request I then create the object needed to the frq1 prombelm. I then take the returns from the frq1 class and then use theymleaf to pass it back to the html page. I also used to differnt submit oppitons one one form.
**Content**<br>
* [th:object](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/Andrew/andrew.html#L63) this takes in inputs and adds it to a java object.
* [two subbmit opptions](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/Andrew/andrew.html#L69) this allows you subbmit with either a get mapping or a postmapping.
* [DTO](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/AndrewFrq1/StringStruct.java) a java class with the sole job of storing data to transfer to another class.

### 6. [Sara Display Unit 3 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/5) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/sara)
The Unit 3 AP FRQ #1 contained the directions for sending messages to an individual who is planning to attend a party. The code is meant to ask the user if they are attending the party by taking their answer in as a boolean, and if so, to enter what meal they would like to eat using integer values to represent specific items. The input is taken and the result is displayed (string/string concatenation) via an HTML page. Created by Sara Beniwal <br>
**Contents** <br>
* [@GetParam Spring Command](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L90) and Thymeleaf Engine was used to receive information from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/sara.html) with user information entered
* [Thymeleaf Objects](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/sara.html#L3) used to assign and display data to HTML page

### 7. [Implement Hangman Java Backend From Previous Project](https://github.com/mhayescs19/p1-mosaic-spring/issues/7)
Ported Hangman Model and Control code from a trimester 1 swing based project. Two interfaces were attempted: First a restricted input text field to retrieve a character and second a-z buttons which the user can interact. The latter button clicks were chosen for the final user interaction. Created by Michael Hayes <br>
**Contents**
* Button presses return a value to the backend, control code manages letter check
* Java [control object](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/java/com/example/project/MainController.java#L124) manages checking the letter and displaying the phrase. This object also hosts many other attributes, including a connection to model which is used for phrase
* Control_java is a [global scope](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/java/com/example/project/MainController.java#L18) in order to keep the phrase for multiple guesses since the @GetMapping is a function and local scope applies
* Investigating button returns led to a possible solution using JS but normal [HTML attributes](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/resources/templates/labs/hangman.html#L56) were used to return correct letter using value="" incapsulating it in a <form>
