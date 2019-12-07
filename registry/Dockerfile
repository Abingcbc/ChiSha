FROM java:8-jre

ADD ./target/registry-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-0.0.1-SNAPSHOT.jar"]

EXPOSE 8888