#!/bin/sh

source ./_env.sh


java -version


# mvn -f ../../stawapp-business/pom.xml -Dtest=TestResourceHelperTest#testResource test






mvn deploy:deploy-file -Durl=file:///opt/java/repomaven/ -Dfile=../repo/starissrv-serviziorissrvpol-client-6.4.0.jar -DgroupId=it.csi.staris.starissrv -DartifactId=serviziorissrvpol-client -Dpackaging=jar -Dversion=6.4.0


