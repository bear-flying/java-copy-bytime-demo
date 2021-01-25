#!/bin/bash
chmod u+x ../../jdk1.7/bin/java
JAVA_HOME=../../jdk1.7
LIB_HOME=../lib
JAVA_LIB=../conf:${JAVA_HOME}/lib/tools.jar:${JAVA_HOME}/lib/dt.jar:${JAVA_HOME}/jre/lib/rt.jar:${JAVA_HOME}/jre/lib/jce.jar
COMMONS_LIB=${LIB_HOME}/cglib-nodep-2.2.jar:${LIB_HOME}/commons-beanutils-1.8.3.jar:${LIB_HOME}/commons-codec-1.3.jar:${LIB_HOME}/commons-collections-3.1.jar:${LIB_HOME}/commons-dbutils-1.2.jar:${LIB_HOME}/commons-digester-2.0.jar:${LIB_HOME}/commons-discovery-0.2.jar:${LIB_HOME}/commons-io-1.4.jar:${LIB_HOME}/commons-lang-2.4.jar:${LIB_HOME}/commons-logging-1.1.jar:${LIB_HOME}/commons-pool-1.5.2.jar:${LIB_HOME}/log4j-1.2.9.jar:${LIB_HOME}/mchange-commons-java-0.2.9.jar:${LIB_HOME}/org.springframework.aop-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.asm-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.aspects-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.beans-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.context.support-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.context-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.core-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.expression-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.jdbc-3.1.2.RELEASE.jar:${LIB_HOME}/org.springframework.transaction-3.1.2.RELEASE.jar:${LIB_HOME}/quartz-2.0.2.jar:${LIB_HOME}/xbean-spring-3.7.jar:${LIB_HOME}/transinfo-1.1-RELEASE.jar
LOCALCLASSPATH=.:${JAVA_LIB}:${COMMONS_LIB}
${JAVA_HOME}/bin/java -Xms1024m -Xmx1024m -Xmn128m -XX:PermSize=128m -XX:MaxPermSize=512m -classpath ${LOCALCLASSPATH} com.founder.TransInfomation
