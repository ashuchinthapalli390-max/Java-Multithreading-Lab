# javafx-tip

Run with JDK 17 and Maven from this directory:

```bash
mvn clean javafx:run
```

The FXML file defines the interface and can be opened in Scene Builder.
The launcher loads it into a JavaFX Stage. No UI coordinates or network images are required.
Save an actual execution screenshot in an `outputs` folder before producing the lab manual.

Enter bill 100 and percentage 15: Tip Amount must be 15.00 and Total Amount 115.00. Check Reset, empty input, invalid input, and negative values. Money is rounded to two decimal places using HALF_UP.
