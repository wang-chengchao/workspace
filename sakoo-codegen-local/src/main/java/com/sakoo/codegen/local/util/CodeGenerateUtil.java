package com.sakoo.codegen.local.util;

import com.sakoo.codegen.local.core.CodeGenerator;
import com.sakoo.codegen.local.core.GeneratorCodeProperties;

public class CodeGenerateUtil {

    public static void main(String[] args) {
        GeneratorCodeProperties properties = new GeneratorCodeProperties();
        properties.setDriverName("com.mysql.jdbc.Driver");
        properties.setUrl("jdbc:mysql://localhost:8306/activitidb?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true");
        properties.setUsername("root");
        properties.setPassword("123456");

        properties.setBaseProjectPath("C:\\codeGen");
        properties.setBasePackage("top.moonlee");
        properties.setModuleName("ss"); //moduleNmae不能包含.
        properties.setTableNames(new String[]{"sys_user"});
        properties.setAuthor("lixin");
        properties.setLogicDeleteFieldName("del_flag");
        properties.setGeneratorSpringCloud(false);
        properties.setOnlyGeneratorPOJO(true);
        CodeGenerator.generatorCode(properties);
    }

}
