
This project is the shell for the cash-register implementation.

This is rather a quick and dirty implementation to try out the new spring-shell v2 project.

This implements the command line interface as outlined in the HelloChange-Rocketmiles document.

This project uses the cash-register project as a dependency:
 ~~~
        <dependency>
            <groupId>com.ocr</groupId>
            <artifactId>cash-register</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
~~~

Building

$> mvn clean install

(The unit test will hang as it tries to take over the console and conflicts with maven. So,
it is @Ignored)

Running:
$> java -jar ./target/cash-register-shell-0.0.1-SNAPSHOT.jar