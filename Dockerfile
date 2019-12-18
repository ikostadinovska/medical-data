FROM fabric8/java-alpine-openjdk8-jre

RUN mkdir -p /opt/data
RUN mkdir -p /opt/data/input
RUN mkdir -p /opt/data/output
RUN mkdir -p /opt/data/error

COPY target/medical-data-0.0.1-SNAPSHOT.jar /opt/medical-data-0.0.1-SNAPSHOT.jar

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/opt/medical-data-0.0.1-SNAPSHOT.jar"]