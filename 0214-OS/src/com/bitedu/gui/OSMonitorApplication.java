package com.bitedu.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//javafx 主程序要求：
//1.必须继承javafx的Application类
//2.必须覆盖（Override）Application类的static方法

public class OSMonitorApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // 1. 加载 .fxml 文件
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("os_monitor_tab.fxml"));

        // 2. 真正的加载
        Parent root = loader.load();

        // 3. 创建一个场景对象
        Scene scene = new Scene(root, 700, 600);

        // 4. 给舞台对象设置标题
        primaryStage.setTitle("OS Monitor");

        // 5. 给舞台对象 stage 设置场景对象
        primaryStage.setScene(scene);

        // 6. 展示舞台
        primaryStage.show();



/*
        Parent root = FXMLLoader.load(getClass().getResource("os_monitor_tab.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
*/

    }


    public static void main(String[] args) {
        launch(args);
    }
}
