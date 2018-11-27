package com.kboss.demo.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;

public class DeployProcess {

    //得到流程引擎
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义
     */
    @Test
    public void deployProcess(){
        //得到流程部署service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("请假流程")
                .addClasspathResource("HelloWorld.bpmn")//bpm文件
                .addClasspathResource("HelloWorld.png")//png文件
                .deploy();//部署
        System.out.println("部署成功！流程部署ID: "+deploy.getId());

    }
}
