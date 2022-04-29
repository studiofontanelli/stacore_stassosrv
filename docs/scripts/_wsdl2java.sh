#!/bin/sh

source ./_env.sh

export MVN_PROFILE=_wsdl2java

java -version

COMMAND="mvn -f ../../pom.xml -s $MVN_SETTINGS -Dmaven.test.skip=true -P$MVN_PROFILE -debug clean generate-sources"

echo "$COMMAND"
exec $COMMAND












