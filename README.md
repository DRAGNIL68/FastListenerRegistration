A small lib (6kb) to register listeners with a annotation.

This was made for papermc 1.21.11 and up but it probably works for more or less any version.

This lib works by using reflection to create a new instance of the listener class after the user class the
register method
```
ListenerRegister.register(this); // put this in your onEnable method
@EventListener // put this on any event listener you wish to auto register
```

```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

<dependency>
    <groupId>com.github.DRAGNIL68</groupId>
    <artifactId>FastListenerRegistration</artifactId>
    <version>712aad3b28</version>
</dependency>
```
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

  dependencies {
        implementation 'com.github.DRAGNIL68:FastListenerRegistration:712aad3b28'
}
```
