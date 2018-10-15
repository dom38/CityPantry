# CityPantry Sample Challenge

Java Implementation of: https://github.com/CityPantry/backend-coding-exercise-php

Sample console java app that takes arguments and compares to an example file to provide information back based on filters.

For quick setup, see docker repo here: https://hub.docker.com/r/dom38/citypantry/

# Build

To build the application, check out the code into a fresh directory:

`git clone https://github.com/dom38/CityPantry.git`

Either package the application using MVN, Gradle, Java or an IDE, or drop the jar into `{projectRoot}/out/artifacts/CityPantry_jar/CityPantry.jar`

If the jar exists elsewhere, update its location on line 7 of the Dockerfile.

At this point the jar can be run using:

`java -jar {path/to/jar} {path/to/example/file} {date} {time} {postcode} {covers}`

Or, for more fun, can be loaded into a docker image by running:

`docker build -t city-pantry:java .`

Additional example files can be added in the dockerfile.
