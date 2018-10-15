FROM openjdk:8-jre
WORKDIR /
ADD /src/test/resources/exampleInput exampleInput
ADD out/artifacts/CityPantry_jar/CityPantry.jar CityPantry.jar

