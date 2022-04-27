#!/bin/sh

source ./_env.sh

java -version


mvn -f ../../pom.xml -s $MVN_SETTINGS  -Dmaven.test.skip=true -Pmacfonta clean












