I coded the project using NetBeans, so it should work when loaded up in NetBeans.

The Java doc comments in the code has all the details, assumptions made, etc.

`src/practicefusioncodingchallenge/` is the main project code.  `SimilarDoctors.java` contains the code to do the similarity processing.  `Doctor.java` is the doctor model definition.  `PracticeFusionCodingChallenge.java` is the demo program.  The test cases are in `test/practicefusioncodingchallenge/`.

If Netbeans is unavailable, the project can be built at the command-line as follows (assuming ant is available):

```
git clone https://github.com/Rao-priya/codingchallenge.git
cd codingchallenge/PracticeFusionCodingChallenge
ant
```

While in the same directory, the project's tests can be run using:

```
ant test
```

The build step will create the file `PracticeFusionCodingChallenge.jar` in the `dist/` directory, which is the demo program. It can be run using:

```
java -jar dist/PracticeFusionCodingChallenge.jar
```

Documentation can be generated using:

```
ant javadoc
```

This command will create all the documentation files in `dist/javadoc` directory.

Ideas for future improvement:

Make more test cases!

Make the similarity finding function do some "fuzzy" matching - e.g. right now, when matching with the experience attribute, an exact match is used whereas someone with 25 years of experience is similar to someone with 24 or 26 years of experience.
