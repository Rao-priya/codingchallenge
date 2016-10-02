I coded the project using NetBeans, so it should work when loaded up in NetBeans.

The Java doc comments in the code has all the details, assumptions made, etc.

`src/practicefusioncodingchallenge/` is the main project code.  `SimilarDoctors.java` contains the code to do the similarity processing.  `Doctor.java` is the doctor model definition.  `PracticeFusionCodingChallenge.java` is the demo program.  The test cases are in `test/practicefusioncodingchallenge/`.

Command-line instructions below work for me on my Windows 10 laptop.

The project can be built using:

```
ant
```

The project's tests can be run using:

```
ant test
```

The build step will create the file `PracticeFusionCodingChallenge.jar` in the `dist/` directory. The project's demo program can be run using:

```
java -jar "dist/PracticeFusionCodingChallenge.jar"
```

Ideas for future improvement:

Make more test cases!

Make the similarity finding function do some "fuzzy" matching - e.g. right now, when matching with the experience attribute, an exact match is used whereas someone with 25 years of experience is similar to someone with 24 or 26 years of experience.
