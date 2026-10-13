# javafx-display

Run with JDK 17 and Maven from this directory:

```bash
mvn clean javafx:run
```

The FXML file defines the interface and can be opened in Scene Builder.
The launcher loads it into a JavaFX Stage. No UI coordinates or network images are required.
Save an actual execution screenshot in an `outputs` folder before producing the lab manual.

Expected: a 600 × 400 scene titled **Text and Image Display**, the label **Hello, JavaFX!**, and the bundled landscape image in an ImageView. The declarative FXML layout can be edited visually in Scene Builder.
