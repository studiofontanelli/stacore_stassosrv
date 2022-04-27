#!/bin/sh

source ./_env.sh

export MVN_PROFILE=macfonta

java -version

COMMAND="mvn -f ../../pom.xml -s $MVN_SETTINGS -Dmaven.test.skip=true -P$MVN_PROFILE clean compile package"

echo "$COMMAND"
exec $COMMAND













