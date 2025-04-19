FROM eclipse-temurin:17-jdk
LABEL authors="antarabhavsar"
WORKDIR /home

COPY ./target/Diner-PancakeHouse-Merge-0.0.1-SNAPSHOT.jar dinerMerge.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "dinerMerge.jar"]