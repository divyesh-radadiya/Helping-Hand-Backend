FROM openjdk:11
EXPOSE 8081
COPY ./target/HelpingHand-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "HelpingHand-0.0.1-SNAPSHOT.jar"]