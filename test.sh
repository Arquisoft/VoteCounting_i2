#!/usr/bin/env bash
mvn clean
mvn install -DskipTests
mvn test
cd tests
mvn test -Dintegrate=true
