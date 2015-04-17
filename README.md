mapUtils
===============

This library contains some utilities in order to interact with groovy maps

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/gextech/mapUtils?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This library binds Java Objects, it is aware of hibernate (GORM) entities

[![Build Status](https://travis-ci.org/gextech/mapUtils.svg?branch=master)](https://travis-ci.org/gextech/mapUtils)
[![Coverage Status](https://img.shields.io/coveralls/gextech/mapUtils.svg)](https://coveralls.io/r/gextech/mapUtils?branch=master)
[ ![Download](https://api.bintray.com/packages/gextech/oss/binding-util/images/download.svg) ](https://bintray.com/gextech/oss/mapUtils/_latestVersion)


Include Dependency
--------------------

Gradle `gex.data:mapUtils:0.0.1`


Usage
------

### putValueAt
It put a value in a map (empty or not) accordingly to given path 

```groovy
    given:
      Map emptyMap = [:]
      String path = "one.two.three"
      String value = "value"

    when:
      def result = MapUtils.putValueAt(emptyMap, path, value)

    then:
      result == [
        one : [
          two: [
            three: value
          ]
        ]
      ]
```

* It creates the necessary structure map given the path
* Overrides previous value with new value











