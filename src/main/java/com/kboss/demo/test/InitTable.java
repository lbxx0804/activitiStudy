package com.kboss.demo.test;

import org.activiti.engine.*;
import org.junit.jupiter.api.Test;

public class InitTable {
    @Test
    public void testInitTables(){

        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/activitistudy");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("123456");
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void testInitTables2(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
        //流程部署 ACT_GE_BYTEARRAY
        //ACT_RE_DEPLOYMENT
        //ACT_RE_MODEL
        //ACT_RE_PROCDEF
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //流程运行  ru开头到表
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();

        //查询历史记录 hi开头的
        HistoryService historyService = processEngine.getHistoryService();
        //页面表单 用得不多
        FormService formService = processEngine.getFormService();

        //对工作流用户管理操作 id
        IdentityService identityService = processEngine.getIdentityService();

        //管理器
        ManagementService managementService = processEngine.getManagementService();

    }
}
