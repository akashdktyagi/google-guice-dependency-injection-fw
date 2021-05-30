# google-guice-dependency-injection-fw
A example cucumber-guice project to demo the use of Google Guice Dependency Injection in Test Automation Framework

> Author: Akash
> 
> Date: 30-May-2021
---
* If you are completely new to Dependency Injection in cucumber please go through below links. 
  * It will give quite good understanding on what are we achieving by implimenting DI in cucumber and what DI in-itself is. 
  * Link: https://cucumber.io/docs/cucumber/state/
  * Link: http://www.thinkcode.se/blog/2017/08/16/sharing-state-between-steps-in-cucumberjvm-using-guice
    
* This FW demos how to use Google Guice Cucumber Library to inject Test Context and Page Object Model files.
* It gives you a starting point for introducing Dependency Injection in your Test Automation Framework.
* Alternate to Google Guice is Pico Container; which is relatively simpler to implement. However, provides with less customization.
* To inject new Page object model file as well as Test Context use @Inject keyword is being used in this fw.
* Check the respective Step Def files to see how the object state is being shared across multiple step def and hooks file.

```java

    @Inject
    TestContext testContext;

    @Inject
    LoginPageObjects loginPageObjects;

    @Inject
    CommonPageObjects commonPageObjects;

    @Inject
    OpenNewAccountPageObjects openNewAccountPageObjects;
```

* Required to add below dependencies in maven pom (along with Cucumber dependency)
```xml

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-guice</artifactId>
            <version>6.8.1</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.inject/guice -->
        <dependency>
            <groupId>com.google.inject</groupId>
            <artifactId>guice</artifactId>
            <version>5.0.1</version>
        </dependency>

```

* Also, using Lombok, so make sure you have pom as well as lombok plugin in your IDE (eclipse or IntelliJ)

* Extent report cucumber adapter 6 has been implemented in this FW to generate extent report. Check the ref here: https://grasshopper.tech/2098/