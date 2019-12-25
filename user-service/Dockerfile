FROM java:8-jre

ENV username=""
ENV password=""
ENV url=""
ENV discovery="localhost"

ADD ./target/registry-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/user-service-0.0.1-SNAPSHOT.jar",
"--spring.datasource.url=$url", "--spring.datasource.username=$username",
"--spring.datasource.password=$password", "--discovery-center=$discovery"]

EXPOSE 8888