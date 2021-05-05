$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/urbanFindr/features/StoreAdmin.feature");
formatter.feature({
  "name": "Store Admin",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@storeAdmin"
    }
  ]
});
formatter.scenario({
  "name": "checking Menu page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@storeAdmin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is present on \"store Admin\" site",
  "keyword": "Given "
});
formatter.match({
  "location": "com.urbanFindr.stepDefinitions.CommonSteps.userIsPresentOnSite(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logged in with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.urbanFindr.stepDefinitions.storeAdmin.LoginWindowSteps.userLoggedInWithValidCredentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User will see menu page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.urbanFindr.stepDefinitions.storeAdmin.HomeWindowSteps.userWillSeeMenuPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "verify fm admin login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@storeAdmin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User go to \"fm admin\" site",
  "keyword": "Given "
});
formatter.match({
  "location": "com.urbanFindr.stepDefinitions.CommonSteps.userGoToSite(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "verify customer page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@storeAdmin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User go to \"customer\" site",
  "keyword": "Given "
});
formatter.match({
  "location": "com.urbanFindr.stepDefinitions.CommonSteps.userGoToSite(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});