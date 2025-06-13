# commonFuntionACE
mqsivault --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --vault-key vaultTest

mqsistart --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --vault-key vaultTest ???

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-type salesforce --credential-name nCinoSalesforce --vault-key vaultTest --auth-type basicClientId --username 'userTest' --password 'passw0rdTest' --client-id '1234567890-abc123def456.apps.googleusercontent.com' --client-secret 'GBAyfVL7YWtP6gudLIjbRZV\_N0dW4f3xETiIxqtokEAZ6FAsBtgyIq0MpU1uQ7J08xOTO2zwP0OuO3pMVAUTid'

mqsisetdbparms -w D:\Cursos\ACE12\WRK\A\TEST_SERVER -n odbc::USERDB2 -u myuserid2 -p mypassword2

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-name testdb --credential-type odbc --username test --password test

mqsicredentials --work-dir D:\Cursos\ACE12\WRK\A\TEST_SERVER --create --credential-name testdbnode --credential-type odbc --vault-key vaultTest --username user1 --password user1

# add jars to local repository
mvn install:install-file -DgroupId=com.ibm.broker -DartifactId=javacompute -Dversion=<ace version> -Dpackaging=jar -Dfile=javacompute.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ibm.broker -DartifactId=jplugin2 -Dversion=<ace version> -Dpackaging=jar -Dfile=jplugin2.jar -DgeneratePom=true

# example pom CommonUtilJava
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>CommonUtilJava</groupId>
  <artifactId>CommonUtilJava</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>CommonUtilJava</name>
  <description>ESB java functions</description>
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
  <dependencies>
  	<dependency>
  		<groupId>com.ibm.broker</groupId>
  		<artifactId>javacompute</artifactId>
  		<version>12.0.10.0</version>
  	</dependency>
  	<dependency>
  		<groupId>com.ibm.broker</groupId>
  		<artifactId>jplugin2</artifactId>
  		<version>12.0.10.0</version>
  	</dependency>
  </dependencies>
</project>
############################