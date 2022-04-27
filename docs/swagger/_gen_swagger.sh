#! /bin/sh


source ./_env.sh


export YAML_FILE=stassosrv-1.0.0-swagger.yaml

# CONFIGURAZIONE RESTEASY
export YAML_FILE_CONFIG_RESTEASY=swagger_config_resteasy.json
#export DIR_GEN_RESTEASY=../../stassosrv-api
export DIR_GEN_RESTEASY=./



rm -rf DIR_GEN_RESTEASY

#/opt/java/projects/csi/fp/fpabil_fpabilbl/fpabilbl-web/src/main/java

#set CLI_JAR_PATH=\git_cloned_repositories\swagger-codegen\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar
#set CUSTOM_GEN_JAR_PATH=\progetti\oxygen\wkspc_swagger3\csi-java-swagger-codegen\target\csi-java-swagger-codegen-1.0.0.jar
#java -cp %CLI_JAR_PATH%;%CUSTOM_GEN_JAR_PATH% %DEBUG_OPTS% io.swagger.codegen.SwaggerCodegen generate -i ..\src\yaml\corsospa.yaml -l jaxrs-resteasy-eap-csi -o ..\tempgen --config swagger_config_java.json

java -classpath $CLI_JAR_PATH:$CUSTOM_GEN_JAR_PATH $DEBUG_OPTS \
				io.swagger.codegen.SwaggerCodegen generate \
				-i $YAML_FILE \
				-l jaxrs-resteasy-eap-csi \
				-o $DIR_GEN_RESTEASY \
				--config $YAML_FILE_CONFIG_RESTEASY

# echo
# rem pause "#### generazione documentazione html ####"

# java -jar $CLI_JAR_PATH generate -l html -i $YAML_FILE -o .







