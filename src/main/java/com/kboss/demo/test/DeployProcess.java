package com.kboss.demo.test;


import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeployProcess {

    //得到流程引擎
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义
     */
    @Test
    public void deployProcess() {
        //得到流程部署service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("请假流程")
                .addClasspathResource("HelloWorld.bpmn")//bpm文件
                .addClasspathResource("HelloWorld.png")//png文件
                .deploy();//部署
        System.out.println("部署成功！流程部署ID: " + deploy.getId());

    }

    /**
     * 启动流程
     */
    @Test
    public void startProcess() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //runtimeService.startProcessInstanceById("HelloWorld:1:4");//根据流程定义id启动流程
        runtimeService.startProcessInstanceByKey("HelloWorld");//根据流程定义key启动
        System.out.println("流程启动成功！");
    }

    /**
     * 查询任务
     */
    @Test
    public void findTask() {
        TaskService taskService = processEngine.getTaskService();
        String assignee = "王五";
        List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println(task.getAssignee() + "   " + task.getCategory() + "；流程定义ID"
                    + task.getProcessDefinitionId() + task.getTaskDefinitionKey()
                    + ";流程定义Key" + task.getTaskDefinitionKey()
                    + "；节点名称:" + task.getName()
                    + ";任务ID：" + task.getId()
            );
        }
    }

    /**
     * 办理任务
     */
    @Test
    public void doTask(){
        //使用TaskService
        TaskService taskService = processEngine.getTaskService();
        taskService.complete("7502");
        System.out.println("任务完成成功！");
    }
}
