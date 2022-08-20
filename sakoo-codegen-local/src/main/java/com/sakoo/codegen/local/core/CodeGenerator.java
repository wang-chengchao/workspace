package com.sakoo.codegen.local.core;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @Author : lixin
 * @Date : Create in 1:01 28/01/2019
 * @Description :
 * @Modified :
 */
public class CodeGenerator {
	public static void generatorCode(GeneratorCodeProperties gcProper) {
		// 代码生成器
		AutoGenerator mpgBase = constructAG(gcProper);
		mpgBase.execute();
	}

	private static AutoGenerator constructAG(GeneratorCodeProperties gcProper) {

		AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
				new GlobalConfig()
						.setOutputDir(gcProper.getBaseProjectPath() + "/src/main/java")
						.setFileOverride(true)
						.setActiveRecord(true)
						.setEnableCache(false)
						.setBaseResultMap(true)
						.setBaseColumnList(true)
						.setSwagger2(true)
						.setAuthor(gcProper.getAuthor())
						.setOpen(false)
						//全局唯一id
						.setIdType(IdType.ASSIGN_ID)
		).setDataSource(
				new DataSourceConfig()
						.setDriverName(gcProper.getDriverName())
						.setUrl(gcProper.getUrl())
						.setUsername(gcProper.getUsername())
						.setPassword(gcProper.getPassword())
						.setSchemaName(gcProper.getSchema())
						//默认使用框架自带的oracle类型转换，如果不满足，就使用自定义类型转换类
						.setTypeConvert(
								(gcProper.getDriverName().contains("oracle")) ? new OracleTypeConvert() : new MySqlTypeConvert())
				// .setTypeConvert(new MyTypeConvert())
		).setPackageInfo(
				new PackageConfig()
						.setModuleName(gcProper.getModuleName())
						.setParent(gcProper.getBasePackage())
		).setCfg(
				new InjectionConfig() {
					@Override
					public void initMap() {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
						map.put("apiPackage", gcProper.getBasePackage()+ "." + gcProper.getModuleName());
						this.setMap(map);
					}
				}.setFileOutConfigList(gdcBaseTemplet(gcProper))
		).setTemplate(
				new TemplateConfig()
						.setController("/template/controller.java")
						.setService("/template/service.java")
						.setServiceImpl("/template/serviceImpl.java")
						.setEntity(null)
                        .setMapper("/template/mapper.java")
                        .setXml("/template/mapper.xml")
		).setStrategy(
				new StrategyConfig()
						// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
						.setNaming(NamingStrategy.underline_to_camel)
						.setColumnNaming(NamingStrategy.underline_to_camel)
						.setEntityLombokModel(true)
						.setRestControllerStyle(true)
						.setInclude(gcProper.getTableNames())
						.setTableFillList(myTableFill())
						.setEntityColumnConstant(false)
						.setControllerMappingHyphenStyle(true)
						.setLogicDeleteFieldName(gcProper.getLogicDeleteFieldName())
						.setTablePrefix(gcProper.getModuleName() + "_")
		);
		mpg.setTemplateEngine(new VelocityTemplateEngine());
		return mpg;

	}

	private static List<FileOutConfig> gdcBaseTemplet(GeneratorCodeProperties gcProper) {
		String basePackagePath = gcProper.getBasePackage().replaceAll("\\.","/");
		List FileOutConfigList = new ArrayList<FileOutConfig>();

		FileOutConfigList.add(new FileOutConfig("/template/vo.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return gcProper.getBaseProjectPath() + "/src/main/java/" + basePackagePath + "/" + gcProper.getModuleName() + "/model/vo/" + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA;
			}
		});
		FileOutConfigList.add(new FileOutConfig("/template/form.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return gcProper.getBaseProjectPath() + "/src/main/java/" + basePackagePath + "/" + gcProper.getModuleName() + "/model/form/" + tableInfo.getEntityName() + "Form" + StringPool.DOT_JAVA;
			}
		});
		FileOutConfigList.add(new FileOutConfig("/template/queryForm.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return gcProper.getBaseProjectPath() + "/src/main/java/" + basePackagePath + "/" + gcProper.getModuleName() + "/model/form/" + tableInfo.getEntityName() + "QueryForm" + StringPool.DOT_JAVA;
			}
		});
		FileOutConfigList.add(new FileOutConfig("/template/entity.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return gcProper.getBaseProjectPath() + "/src/main/java/" + basePackagePath + "/" + gcProper.getModuleName() + "/entity/" + tableInfo.getEntityName() + "Entity" + StringPool.DOT_JAVA;
			}
		});
//		FileOutConfigList.add(new FileOutConfig("/template/queryParam.java.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return gcProper.getBaseProjectPath() + "/src/main/java/com/deloitte/platform/api/" + filePath + "/param/" + tableInfo.getEntityName() + "QueryParam" + StringPool.DOT_JAVA;
//			}
//		});
//		FileOutConfigList.add(new FileOutConfig("/template/client.java.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return gcProper.getBaseProjectPath() + "/src/main/java/com/deloitte/platform/api/" + filePath + "/" + tableInfo.getEntityName() + "Client" + StringPool.DOT_JAVA;
//			}
//		});
//		if (gcProper.isGeneratorSpringCloud()) {
//			FileOutConfigList.add(new FileOutConfig("/template/feign.java.vm") {
//				@Override
//				public String outputFile(TableInfo tableInfo) {
//					return gcProper.getBaseProjectPath() + "/src/main/java/com/deloitte/platform/api/" + filePath + "/feign/" + tableInfo.getEntityName() + "FeignService" + StringPool.DOT_JAVA;
//				}
//			});
//		}
		return FileOutConfigList;
	}


	private static List<TableFill> myTableFill() {
		// 自定义需要填充的字段
		List<TableFill> tableFillList = new ArrayList<TableFill>();
		TableFill createTimeField = new TableFill("create_time", FieldFill.INSERT);
		TableFill createByField = new TableFill("create_by", FieldFill.INSERT);
		TableFill updateTimeField = new TableFill("update_time", FieldFill.INSERT_UPDATE);
		TableFill updateByField = new TableFill("update_by", FieldFill.INSERT_UPDATE);
		tableFillList.add(createTimeField);
		tableFillList.add(createByField);
		tableFillList.add(updateTimeField);
		tableFillList.add(updateByField);
		return tableFillList;
	}

	public static void main(String[] args) {
		System.out.println("a.bc.dd".replaceAll("\\.", "/"));
	}

}
