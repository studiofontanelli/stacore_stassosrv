#! /bin/sh


export CLI_JAR_PATH=./lib/swagger-codegen-cli.jar
export CUSTOM_GEN_JAR_PATH=./lib/csi-java-swagger-codegen-1.0.0.jar


#export JAVA_HOME=/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
#export ANT_HOME=/opt/java/apache-ant-1.8.4

#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_71.jdk/Contents/Home/
export JAVA_HOME=/opt/java/jdk/jdk-11.0.2.jdk/Contents/Home
export ANT_HOME=/opt/java/apache-ant-1.10.5

#export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
export JAVA_TOOL_OPTIONS=-Dfile.encoding=ISO-8859-1





export PATH=$JAVA_HOME/bin:$ANT_HOME/bin:$PATH




