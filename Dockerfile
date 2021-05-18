FROM openjdk:8
EXPOSE 8080

ADD out/artifacts/spring_boot_security_postgresql_jar/spring-boot-security-postgresql.jar  spring-boot-security-postgresql.jar
ENTRYPOINT ["java", "-jar","spring-boot-security-postgresql.jar"]


