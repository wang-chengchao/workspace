package com.sakoo.codegen.local.core;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : kermit
 * @Date : Create in 10:47 24/01/2019
 * @Description :
 * @Modified :
 */
@Data
@NoArgsConstructor
public class GeneratorCodeProperties {

    private String driverName;

    private String url;

    private String username;

    private String password;

    private String baseProjectPath;

    private String moduleName;

    private String serviceName;

    private String basePackage;

    private String logicDeleteFieldName;

	private String schema;

    public String getSericeName(){
        if(serviceName == null || "".equals(serviceName)){
            return moduleName + "-service";
        }else{
            return serviceName;
        }
    }

    private boolean publicApi = false;

    private String apiPackage="com.sakoo.api";

    private String packageMsg="com.sakoo.services";

    private String[] tableNames;

    private String author;

    //只生成POJO对象
    private boolean onlyGeneratorPOJO=true;

    //生成SpringCloud Feign客户端
    private boolean generatorSpringCloud=false;

    //生成Vue页面组件
    private boolean generatorVue=false;
}
