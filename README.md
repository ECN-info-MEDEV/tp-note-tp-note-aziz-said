# TP Note

| Étudiants  |     
|------------|
| Aziz ABID  |     
| Ahmad SAID |     


Implementation de jeu Mastermind

[Check Game rules](https://fr.wikipedia.org/wiki/Mastermind)

## Maven

```bash
# Build jar without dependency
# Generated file to consult: TP-NOTE-MASTERMIND-1.1-SNAPSHOT.jar
mvn clean package

# Build jar with dependency
# Generated file to consult: TP-NOTE-MASTERMIND-1.1-SNAPSHOT-jar-with-dependencies.jar
mvn clean compile assembly:single


# Generate java doc 
# Generated file to consult: target/apidocs/index.html 
mvn javadoc:jar

# Generate test and coverage
# Generated file consult : target/site/jacoco/index.html
mvn -B -Pcoverage verify
```

## Ant
```bash
# build jar 
# Generate : build/jar/TP-NOTE-MASTERMIND.jar
ant build-jar

# build report
ant doc
```