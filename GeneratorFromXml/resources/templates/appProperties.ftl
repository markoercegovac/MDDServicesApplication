server.port=9090

#H2 DATABASE
spring.datasource.url = jdbc:h2:file:~/Mbrs;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;

spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

spring.jpa.hibernate.ddl-auto =update
#Spring security
spring.security.user.password=password
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration

