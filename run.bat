@echo off
echo Starting Smart Internship Portal...
cd /d "c:\Users\priyanka\FinalYearProject\demo"
set JAVA_HOME=
mvn clean compile exec:java -Dexec.mainClass="com.example.demo.DemoApplication"
pause