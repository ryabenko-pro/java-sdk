# Elarian Kotlin/JVM SDK

[ ![Download](https://api.bintray.com/packages/elarian/java/com.elarian/images/download.svg) ](https://bintray.com/elarian/java/com.elarian/_latestVersion)

>
> The SDK provides convenient access to the Elarian APIs from applications written in Kotlin, Java and Scala.
>

## Documentation
Take a look at the [API docs here](https://docs.elarian.com).

## Install

You can depend on the [.jar](http://dl.bintray.com/elarian/java/com/elarian/sdk) through Maven (from `http://dl.bintray.com/elarian/java`):
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
  <artifactId>sdk</artifactId>
  <version>0.0.0</version>
</dependency>
```
or sbt:

```
resolvers += "elarian maven repository" at "http://dl.bintray.com/elarian/java"
// Get all services
libraryDependencies += "com.elarian" % "sdk" % "0.0.0"
```

or Gradle:
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/elarian/java"
  }
}

dependencies{
  implementation 'com.elarian:sdk:0.0.0'
}
```

## Usage

The SDK needs to be initialized with your API key, which you get from the [dashboard](https://account.elarian.com).

```kotlin
// Initialize
val elarian = Elarian(apiKey = "ABCD", sandbox = true)


// Send message
val req = SendMessageReequest()
val res = elarian.SendMessage(req)

```

See [example](example/) for more usage examples.

## Methods

- `AuthToken()`: Generate auth token

- `GetCustomerState()`:
- `AdoptCustomerState()`: 

- `AddCustomerReminder()`:
- `AddCustomerReminderByTag()`:
- `CancelCustomerReminder()`:
- `CancelCustomerReminderByTag()`:
  
- `UpdateCustomerTag()`:
- `DeleteCustomerTag()`:

- `UpdateCustomerSecondaryId()`:
- `DeleteCustomerSecondaryId()`:

- `UpdateCustomerMetadata()`:
- `DeleteCustomerMetadata ()`:

- `SendMessage()`: Sending a message to your customer
- `SendMessageByTag()`: Sending a message to a group of customers using tags
- `ReplyToMessage()`: Replying to a message from your customer
- `MessagingConsent()`: Opting a customer in or out of receiving messages from your app

- `SendPayment()`:
- `CheckoutPayment()`:

- `MakeVoiceCall()`:
  
- `StreamNotifications()`:
- `SendWebhookResponse()`:


## Development

Run all tests:

```bash
$ ./gradlew test
```

## Issues

If you find a bug, please file an issue on [our issue tracker on GitHub](https://github.com/ElarianLtd/kotlin-sdk/issues).