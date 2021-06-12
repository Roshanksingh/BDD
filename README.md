# README #
  
# https://www.youtube.com/watch?v=fktI3BpLI7c (Attaching report in Jenkins)  

# Pre-requisite
- Download Open Java JDK 11 http://jdk.java.net/11/ unzip file and set path to folder in environment variables
- Install Maven and set path in environment variables
- Set path to Open JDK 11 in Intellij -> open **File** -> **Project structure** -> change **JDK home path**

	
# Download webdriver
Download drivers from https://chromedriver.chromium.org/downloads and put it to src/test/resources/drivers/yourSystem 
or do it automatically:
- Open bash (linux and macOs) or powershell (windows) and go to project directory
- Go to src/test/resources/drivers/yourSystem
        - in windows run command:```./download.ps1```
        - in linux or macOS run command:```./download.sh```

# Running features from system cmd
- Execute following command in project directory to execute tests from commandline level:
     - ```mvn clean test -Dconfig.file="configs/uat.properties"``` command to run features.
     - where: 
        - ```-Dcucumber.options="-t @debug1,@debug2"``` is a tag assigned to test or feature. Remove this parameter if you want to execute all tests
        - ```-Dconfig.file="configs/uat.properties"``` is a path to environment configuration file

# Running project from IDE level

- Download and install IntelliJ IDEA
- Click on "**File** -> **New** -> **Project from Existing sources**" to import project
- Import project as Maven 
- Click "**Maven** -> **Lifecycle** -> **test**" to run project
- Click on **Run** -> **Edit configurations...**
- Click on **Add New Configuration**
- Add **TestNg** configuration
- Select "**suite**" in "**Test kind**" 
- Select **suite**: cscart-automation-qa/src/test/resources/configs/testng.xml
- Set **VM Options**: -Dcucumber.options="-t @debug1,@debug2" -Dconfig.file="configs/uat.properties"
- Click on "**apply**" and "**ok**"
- Click on **play** button
 
# Cucumber Reports:- This will generate two reports
- Cucumber Pretty (folder - "target\report\cucumber"), file - index.html
- Cucumber Advance (folder - "target\report\cucumber-html-reports"), file - "overview-features.html"
