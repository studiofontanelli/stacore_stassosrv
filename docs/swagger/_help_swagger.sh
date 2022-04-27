#! /bin/sh


source ./_env.sh


export YAML_FILE=staaudit-1.0.0-swagger.yaml

# CONFIGURAZIONE RESTEASY
export YAML_FILE_CONFIG_RESTEASY=swagger_config_resteasy.json
export DIR_GEN_RESTEASY=../../staaudit-api

# CONFIGURAZIONE SPRING
export YAML_FILE_CONFIG_SPRING=swagger_config_spring.json
export DIR_GEN_SPRING=../../staaudit-api-spring




#set CLI_JAR_PATH=\git_cloned_repositories\swagger-codegen\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar
#set CUSTOM_GEN_JAR_PATH=\progetti\oxygen\wkspc_swagger3\csi-java-swagger-codegen\target\csi-java-swagger-codegen-1.0.0.jar
#java -cp %CLI_JAR_PATH%;%CUSTOM_GEN_JAR_PATH% %DEBUG_OPTS% io.swagger.codegen.SwaggerCodegen generate -i ..\src\yaml\corsospa.yaml -l jaxrs-resteasy-eap-csi -o ..\tempgen --config swagger_config_java.json

#java -classpath $CLI_JAR_PATH $DEBUG_OPTS config-help -l jaxrs-resteasy-eap-csi 

java -classpath $CLI_JAR_PATH $DEBUG_OPTS 



#java -classpath $CLI_JAR_PATH:$CUSTOM_GEN_JAR_PATH $DEBUG_OPTS config-help -l jaxrs-resteasy-eap-csi 







