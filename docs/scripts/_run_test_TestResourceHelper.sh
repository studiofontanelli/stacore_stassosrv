#!/bin/sh

source ./_env.sh


java -version


mvn -f ../../stawapp-business/pom.xml -Dtest=TestResourceHelperTest#testResource test









