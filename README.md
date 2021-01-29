# Elarian

[ ![Download](https://api.bintray.com/packages/elarian/java/com.elarian/images/download.svg) ](https://bintray.com/elarian/java/com.elarian/_latestVersion)

>
> The SDK provides convenient access to the Elarian APIs from applications written in Kotlin, Java, and Scala.
>

## Documentation
Take a look at the [API docs here](https://docs.elarian.com).

## Install

You can depend on the [.jar](http://dl.bintray.com/elarian/java/com/elarian/java) through Maven (from `http://dl.bintray.com/elarian/java`):
```xml
<repositories>
   <repository>
      <id>elarian</id>
      <name>Elarian</name>
      <url>http://dl.bintray.com/elarian/java</url>
   </repository>
</repositories>
...
<dependency>
  <groupId>com.elarian</groupId>
  <artifactId>jvm</artifactId>
  <version>0.1.0</version>
</dependency>
```
or sbt:

```
resolvers += "elarian maven repository" at "http://dl.bintray.com/elarian/java"
// Get all services
libraryDependencies += "com.elarian" % "jvm" % "0.1.0"
```

or Gradle:
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/elarian/java"
  }
}

dependencies{
  implementation 'com.elarian:jvm:0.1.0'
  // Or if you're building for android
  // implementation 'com.elarian:android:0.1.0'
}
```

## Usage

The SDK needs to be initialized with your API key, which you get from the [dashboard](https://account.elarian.com).

```java
String appId = "test_app";
String orgId = "test_org";
String apiKey = "test_api_key";

Elarian app = Elarian.newInstance(apiKey, orgId, appId);
app.sendMessage(customerNumber, channelNumber, message)
    .subscribe(
        res -> System.out.println(res.toString()),
        err -> err.printStackTrace()
    );
```

See [examples](examples/) for more usage examples.


## Issues

If you find a bug, please file an issue on [our issue tracker on GitHub](https://github.com/ElarianLtd/kotlin-sdk/issues).