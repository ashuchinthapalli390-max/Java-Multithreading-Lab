# jdbc-select

Requires JDK 17, MySQL and the official MySQL Connector/J driver on the classpath.
Use a separate fresh lab database per exercise: the SELECT lab uses `username`,
while the INSERT lab uses `name`, matching the different LMS specifications.
Run setup.sql in MySQL before running the Java program.

Keep database credentials out of GitHub. Set DB_PASSWORD, and optionally DB_USER
and DB_URL, in your local environment. Default URL is jdbc:mysql://localhost:3306/mydatabase.

Linux/macOS:

```bash
javac DatabaseConnection.java
java -cp ".:mysql-connector-j.jar" DatabaseConnection
```

Windows PowerShell (replace the JAR name with your downloaded driver filename):

```powershell
javac DatabaseConnection.java
java -cp ".;mysql-connector-j.jar" DatabaseConnection
```

The source has been compiled locally. A live MySQL execution and its screenshot
are still required to document database output. No successful database output is fabricated.
