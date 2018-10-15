FROM openjdk:8-jre
WORKDIR /
ADD /src/test/resources/exampleInput exampleInput
# Other example files can be added as such:
# ADD /path/to/your/example example
# And they will be available on the root
ADD out/artifacts/CityPantry_jar/CityPantry.jar CityPantry.jar

