FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin@1234 --silent
ADD target/first_ee.war /opt/jboss/wildfly/standalone/deployments/first_ee.war
EXPOSE 8080
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]