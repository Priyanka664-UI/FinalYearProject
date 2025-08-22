# Quick Start Guide - Smart Internship Portal

## Issue Resolution

You're experiencing Java version conflicts. Here are the solutions:

### Option 1: Use Your IDE (Recommended)
1. Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Right-click on `DemoApplication.java`
3. Select "Run DemoApplication"
4. The application will start on `http://localhost:8081`

### Option 2: Set JAVA_HOME
1. Find your Java 21 installation path
2. Set JAVA_HOME environment variable:
   ```cmd
   set JAVA_HOME=C:\Program Files\Java\jdk-21
   set PATH=%JAVA_HOME%\bin;%PATH%
   ```
3. Run: `mvn clean spring-boot:run`

### Option 3: Direct Java Execution
1. Compile manually:
   ```cmd
   javac -cp "target\classes;%USERPROFILE%\.m2\repository\org\springframework\boot\spring-boot-starter-web\3.5.4\*" src\main\java\com\example\demo\*.java
   ```
2. Run:
   ```cmd
   java -cp "target\classes;%USERPROFILE%\.m2\repository\*" com.example.demo.DemoApplication
   ```

## Test the Application

Once running, visit:
- **Home Page**: http://localhost:8081
- **API Test**: http://localhost:8081/api/users
- **Database Console**: http://localhost:8081/h2-console

## Sample API Calls

### 1. Register a User
```bash
curl -X POST http://localhost:8081/api/users/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@example.com","password":"test123","role":"STUDENT"}'
```

### 2. Get All Internships
```bash
curl http://localhost:8081/api/internships
```

### 3. Get Dashboard Stats
```bash
curl http://localhost:8081/api/dashboard/stats
```

## Troubleshooting

If you still see issues:
1. Ensure you have JDK 21 (not just JRE)
2. Check `java -version` and `javac -version` match
3. Use your IDE's built-in run functionality
4. Check if port 8081 is available

The backend is fully functional with all required APIs for the Smart Internship Portal!