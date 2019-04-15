# Logging Tools

## Overview

This is a generic Java/Kotlin library that enables creating feature-full loggers for any context.

These tools come equipped with useful capabilities like logging at different levels (that you define), counters, timers, outputting data to a table, and JSON/XML output.

## Setup

#### Gradle

`implementation 'me.levansmith.logdog:logging:0.2.1'`

#### Maven
```
<dependency>
    <groupId>me.levansmith.logdog</groupId>
    <artifactId>logdog</artifactId>
    <version>0.2.1</version>
</dependency>
```

## Sample Usage

```kotlin
// Some included methods
LoggerImpl.log("Some message") // Auto tagged
LoggerImpl.e.log("SOME_TAG", "Some error message") // Error level message
LoggerImpl.count("sample_counter") // Increment "sample_counter"
LoggerImpl.table(listOf(1,2,3)) // Outputs a table with that data (with indexes)
LoggerImpl.hide.log("This is a hidden message!") // Handy for quick changes

// Some configurations
LogDogConfig.disableLogs = true
LoggerImpl.log("Will not be displayed")
LoggerImpl.log("Nor this")
LoggerImpl.force.log("Will always show, no matter what") // Definitely will show ;)
LogDogConfig.disableLogs = false

LogDogConfig.logThreshold = LogProviderImpl.ERROR
LoggerImpl.log("Defaults to minimum level") // Won't show in this case
LoggerImpl.e.log("Error level message") // Will show
```

## Developed By

* LeVan Smith

&nbsp;&nbsp;&nbsp;**Email** - levictorsmith@gmail.com

&nbsp;&nbsp;&nbsp;**Website** - http://levansmith.me

## Acknowledgments


