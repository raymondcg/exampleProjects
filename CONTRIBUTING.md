1. Install java JDK
2. Install Maven
3. Configure Environment Variables (update folder locations to the locations installed to in steps 1 and 2.)
```
JAVA_HOME=c:\Program Files\Java\jdk1.8.0_91
MAVEN_HOME=c:\apache\apache-maven-3.3.9
M2_HOME=c:\apache\apache-maven-3.3.9
JAVA_OPTS=-Xms512m -Xmx4096m -XX:MaxMetaspaceSize=512m
MAVEN_OPTS=-Xms512m -Xmx4096m -XX:MaxMetaspaceSize=512m
```

4. Update Path, prepend to front of path
```
%JAVA_HOME%/bin;%M2_HOME%/bin;$PATH
```

5. Verify Java and Maven Versions
```bash
java -version
javac -version
mvn --version
```

6. Install Eclipse
    1. Download Eclipse
    2. Update settings Eclipse
        1. Update JRE
        2. Update Maven
    3. Update Save Actions
    4. Import Code formatter
    5. Install Eclipse Plugins
        1. Color Theme - http://eclipse-color-theme.github.io/update/
        2. Cucumber - http://cucumber.github.com/cucumber-eclipse/update-site/
        3. Drools
            1. Get latest update site from: http://tools.jboss.org/downloads/jbosstools/neon/4.4.0.Final.html
            2. Follow rules plugin instructions: http://tools.jboss.org/blog/integration-stack-4.3.0.Final.html
            3. "The easiest way to install the integration Stack components is to first install "JBoss Tools" and then select the Software/Update tab in the JBoss Central view. Select the "Enable Early Access" checkbox."
 		4. Gradle Buildship Plugin - http://download.eclipse.org/buildship/updates/e44/releases/1.0
7. Java Profiling Tool in %java_home5/bin/jvisualvm (jdk only)
    1. Add visual gc and threads inspector