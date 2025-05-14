# BandWidth
A short simple Qmetry Automation Framework - QAF project 

Refer Document : https://docs.google.com/document/d/1lfE8Gg-OfOtkWQ1QOwYcGCMxNm_6K2G-/edit?usp=sharing&ouid=112131444974196636984&rtpof=true&sd=true

To execute,
Locally --> 

1. Clone and import project
2. Go to project location
3. Start selenium standalone server via command >> java -jar selenium-server-4.31.0.jar standalone --host localhost
4. Run test via command >> mvn test --Denv="LOCAL"

To execute,
Remotely -->
1. Clone and import project
2. Go to project location
3. Run test via command >> mvn test --DRemoteExecution="True"
or
4. Run test via command >> mvn test --Denv="LAMBDATEST" --DRemoteExecution="True"

To execute,
Hyper Execution -->
1. Clone and import project
2. Go to project location
3. Run test via command >> mvn test 
or
4. Run test via command >> mvn test --Denv="LAMBDATEST" 

