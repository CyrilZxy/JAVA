package com.bitedu.gui;

import com.bitedu.osm.OSResource;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TreeTableView;

public class OSMonitorController {
    private LineChart cpuChart;
    private TreeTableView fileStat;

    // CPU 占有率事件处理方法
    public void handleCPUSelectionChanged(Event event) {

        //切换tab页 获取一个cpu占有率值
        System.out.println("Tab select cpu="+ OSResource.getCPUPercetage());



        // 1. 创建一个定时器，每隔一秒获取一次 CPU 资源绘制曲线图
        // 2. 绘制 LineChart

        //测试切换tab页 得到响应输出
        //System.out.println("Tab selected");
    }


    // 磁盘目录扫描事件处理方法
    public void handleSelectFile(ActionEvent actionEvent) {


        // 1. 打开文件选择对话框
        // 2. 开启磁盘目录扫描线程
        // 3. 渲染TreeTableView

        //测试按下按钮 得到响应输出
        System.out.println("Button action");
    }

}
