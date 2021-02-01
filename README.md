# p1-mosaic-spring

## Project Contributors
| Contributor | GitHub Link | Journal Link |
| ----------- | ----------- | ----------- | 
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Sara Beniwal | [@saraben21](https://github.com/saraben21) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)

## Runtime Guidance For Entire Project
1. Clone the project repository.
2. Open the src directory, open the Main directory, open the Java directory, open the com.example.project package and open the Main.java file.
3. Run from Main.java (inside of the "Main" package) OR set up configuration to Main.
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/runtime-main-java.png" height="auto" width="40%"> <img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/runtime-config.png" width="45%" height="auto">

## ScrumBoard
<a href="https://github.com/mhayescs19/p1-mosaic-spring/projects/1"><img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/board-entire-button.png" width="30%" height="auto"><a/> 

## 1/29  Weekly Project Contributions and Artifacts Log
### Week 7
# [Tickets Video](https://drive.google.com/file/d/1hbOL0yeJWl4qi3kuO4QO8DL3UynJ-QnG/view?usp=sharing)
### 1. [Set Up Spring Boot Barebones Via JetBrains Tutorial + Example Nav Bar Imported](https://github.com/mhayescs19/p1-mosaic-spring/issues/1)
A basic menu was implemented. The main challenges was implementing the CSS styling. Temporary inline CSS styling was used to get the menu to function. Created by Michael Hayes <br>
**Contents** <br>
* Basic JetBrains tutorial + Mr. M example code with MainController.java was used to create a homepage with an [example menu](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/fragments/header.html) with [CSS styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/fragments/headfile.html#L14 (temporary inline CSS styling imported in headfile to header - Direct use of a .css file seems better).
* A [hyperlink list](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/menuAP.html#L54) on a page that is liked via the menu also sends the user to 4 separate pages that host some FRQs

### 2. [Michael Display Unit 5 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/4)
The PasswordGenerator class is implemented onto an HTML page with the corresponding inputs for a prefix and length of randomized string of characters to generate a unique password. Additionally the all of the generated passwords are also displayed via a table below the "interactable" area of the page. No CSS styling has been implemented yet. Created by Michael Hayes <br>
**Contents** <br>
* Similar [@GetParam decorators used](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/java/com/example/project/MainController.java#L65) for two separate variables in apPracticeMichael method in MainController.java
* Merged pali lab and table COVID19 api call HTML examples: used [two input fields in a single form](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L10) and [one table](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L19) (* see comments in michael.html as I shared my learning and remaining confusions about the HTML tags used)
