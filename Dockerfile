FROM azul/zulu-openjdk:17
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/defam-0.0.1-SNAPSHOT.jar defamspring.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar defamspring.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar defamspring.jar
