# EzBar
[![](https://jitpack.io/v/PartlySunnyDev/EzBar.svg)](https://jitpack.io/#PartlySunnyDev/EzBar)
![](https://img.shields.io/github/languages/top/PartlySunnyDev/EzBar)
![](https://img.shields.io/github/v/release/PartlySunnyDev/EzBar)
![](https://img.shields.io/github/stars/PartlySunnyDev/EzBar?style=social)

## Simple and easy to use action bar and boss bar library for Spigot and Paper
Easy way to create boss bars and action bars without having to worry about multi-versioning!

### Features
- [x] Multiversion support 1.12.2 -> 1.19.4
- [x] Simple and easy to use
- [x] Timed action bars and bossbars

### Setup
1. Add the jitpack repository to your pom.xml
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url> <!-- Add this repository -->
    </repository>
</repositories>
```

2. Add the dependency to your pom.xml (Use Spigot if you are using Spigot, not Paper)
```xml
<dependencies>
    <dependency>
        <groupId>com.github.PartlySunnyDev.EzBar</groupId>
        <artifactId>Paper</artifactId>
        <version>VERSION</version> <!-- Add this dependency -->
    </dependency>
</dependencies>
```

3. Shade the dependency into your plugin
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId> <!-- Add this plugin -->
            <version>3.2.4</version>
            <configuration>
                <relocations>
                    <relocation>
                        <pattern>me.partlysunny.ezbar</pattern>
                        <shadedPattern>your.plugin.package.ezbar</shadedPattern> <!-- Add this relocation -->
                    </relocation>
                </relocations>
            </configuration>
        </plugin>
    </plugins>
</build>
```