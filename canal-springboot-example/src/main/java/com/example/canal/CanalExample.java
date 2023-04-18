/*
package com.example.canal;

import org.springframework.stereotype.Service;

*/
/**
 * @author kermit
 * @since 2023/4/18 12:17
 *//*

@Service
public class CanalExample {

    */
/**
     * 必须在类上 使用 EnableCanalListener 注解才能开启 canal listener
     *
     * 目前 Listener 方法的参数必须为 com.duxinglangzi.canal.starter.mode.CanalMessage
     * 程序在启动过程中会做检查
     *//*


    */
/**
     * 监控更新操作
     * 支持动态参数配置，配置项需在 yml 或 properties 进行配置
     * 目标是 ${prod.example} 的  ${prod.database} 库  users表
     *//*

    @CanalUpdateListener(destination = "${prod.example}", database = "${prod.database}", table = {"users"})
    public void listenerExampleBooksUsers(CanalMessage message) {
        printChange("listenerExampleBooksUsers", message);
    }

    */
/**
     * 监控更新操作 ，目标是 example的  books库  users表
     *//*

    @CanalInsertListener(destination = "example", database = "books", table = {"users"})
    public void listenerExampleBooksUser(CanalMessage message) {
        printChange("listenerExampleBooksUsers", message);
    }

    */
/**
     * 监控更新操作 ，目标是 example的  books库  books表
     *//*

    @CanalUpdateListener(destination = "example", database = "books", table = {"books"})
    public void listenerExampleBooksBooks(CanalMessage message) {
        printChange("listenerExampleBooksBooks", message);
    }

    */
/**
     * 监控更新操作 ，目标是 example的  books库的所有表
     *//*

    @CanalListener(destination = "example", database = "books", eventType = CanalEntry.EventType.UPDATE)
    public void listenerExampleBooksAll(CanalMessage message) {
        printChange("listenerExampleBooksAll", message);
    }

    */
/**
     * 监控更新操作 ，目标是 example的  所有库的所有表
     *//*

    @CanalListener(destination = "example", eventType = CanalEntry.EventType.UPDATE)
    public void listenerExampleAll(CanalMessage message) {
        printChange("listenerExampleAll", message);
    }

    */
/**
     * 监控更新、删除、新增操作 ，所有配置的目标下的所有库的所有表
     *//*

    @CanalListener(eventType = {CanalEntry.EventType.UPDATE, CanalEntry.EventType.INSERT, CanalEntry.EventType.DELETE})
    public void listenerAllDml(CanalMessage message) {
        printChange("listenerAllDml", message);
    }

    public void printChange(String method, CanalMessage message) {
        CanalEntry.EventType eventType = message.getEventType();
        CanalEntry.RowData rowData = message.getRowData();


        System.out.println(" >>>>>>>>>>>>>[当前数据库: " + message.getDataBaseName() + " ," + "数据库表名: " + message.getTableName() + " , " + "方法: " + method);

        if (eventType == CanalEntry.EventType.DELETE) {
            rowData.getBeforeColumnsList().stream().collect(Collectors.toList()).forEach(ele -> {
                System.out.println("[方法: " + method + " ,  delete 语句 ] --->> 字段名: " + ele.getName() + ", 删除的值为: " + ele.getValue());
            });
        }

        if (eventType == CanalEntry.EventType.INSERT) {
            rowData.getAfterColumnsList().stream().collect(Collectors.toList()).forEach(ele -> {
                System.out.println("[方法: " + method + " ,insert 语句 ] --->> 字段名: " + ele.getName() + ", 新增的值为: " + ele.getValue());
            });
        }

        if (eventType == CanalEntry.EventType.UPDATE) {
            for (int i = 0; i < rowData.getAfterColumnsList().size(); i++) {
                CanalEntry.Column afterColumn = rowData.getAfterColumnsList().get(i);
                CanalEntry.Column beforeColumn = rowData.getBeforeColumnsList().get(i);
                System.out.println("[方法: " + method + " , update 语句 ] -->> 字段名," + afterColumn.getName() + " , 是否修改: " + afterColumn.getUpdated() + " , 修改前的值: " + beforeColumn.getValue() + " , 修改后的值: " + afterColumn.getValue());
            }
        }
    }


}

*/
