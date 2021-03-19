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
  <version>0.2.0</version>
</dependency>
```
or sbt:

```
resolvers += "elarian maven repository" at "http://dl.bintray.com/elarian/java"
// Get all services
libraryDependencies += "com.elarian" % "elarian-core" % "0.2.0"
```

or Gradle:
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/elarian/java"
  }
}

dependencies{
  implementation 'com.elarian:elarian-core:0.2.0'
  // Or if you're building for android
  // implementation 'com.elarian:elarian-android:0.2.0'
}
```

## Usage

The SDK needs to be initialized with your API key, which you get from the [dashboard](https://account.elarian.com).

```java
String appId = "test_app";
String orgId = "test_org";
String apiKey = "test_api_key";

Elarian app = new Elarian(apiKey, orgId, appId);

app.connect(new ConnectionListener() {
    @Override
    public void onPending() {
        log.info("Pending...");
    }

    @Override
    public void onConnecting() {
        log.info("Connecting...");
    }

    @Override
    public void onClosed() {
        log.info("Connection Closed");
    }

    @Override
    public void onConnected() {
        log.info("Connected!");
        Tag tag = new Tag("some-key", "some-value");
        MessagingChannel channel = new MessagingChannel("2020", MessagingChannel.Channel.SMS);
        Message message = new Message(new MessageBody("This is a test"));
        app.sendMessageByTag(tag, channel, message)
                .subscribe(
                        res -> log.info(res.description),
                        err -> err.printStackTrace()
                );
    }
    @Override
    public void onError(Throwable throwable) {
        log.warning("Failed to connect: " + throwable.getMessage());
    }
});
```

See [examples](elarian-examples/) for more usage examples.

## Development

See [SDK Spec](https://github.com/ElarianLtd/sdk-spec) for reference.

## Issues

If you find a bug, please file an issue on [our issue tracker on GitHub](https://github.com/ElarianLtd/kotlin-sdk/issues).