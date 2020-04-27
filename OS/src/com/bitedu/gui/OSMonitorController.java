package com.bitedu.gui;

import com.bitedu.osm.FileScanner;
import com.bitedu.osm.FileTreeNode;
import com.bitedu.osm.OSResource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OSMonitorController {
    @FXML private LineChart cpuChart;
    @FXML private TreeTableView fileStat;
    @FXML private Text osType;
    @FXML private Text cpuArch;
    @FXML private Text cpuCore;


    //定时器任务
    private TimerTask timerTask=null;
    //定时器线程执行定时任务
    private Timer timer=new Timer();

    private final Image image=new Image(
            getClass().getClassLoader().getResourceAsStream("Folder.png")   );

    private Stage primaryStage=null;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    // CPU 占有率事件处理方法
    public void handleCPUSelectionChanged(Event event) {
        // 1. 创建一个定时器，每隔一秒获取一次 CPU 资源绘制曲线图
        // 2. 绘制 LineChart
        Tab tab = (Tab) event.getTarget();

        if (tab.isSelected()) {
            //匿名内部类
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    OSResource.XYPair[] xyPairs = OSResource.getCPUPercetage();
                    XYChart.Series series = new XYChart.Series();
                    for (OSResource.XYPair xyPair : xyPairs) {
                        XYChart.Data data = new XYChart.Data(xyPair.getX(), xyPair.getY());
                        series.getData().add(data);
                    }

                    //将渲染逻辑接到主线程执行
                    Platform.runLater(
                            () -> {
                                if (cpuChart.getData().size() > 0) {
                                    cpuChart.getData().remove(0);
                                }
                                cpuChart.getData().add(series);

                                //
                                osType.setText(OSResource.getOSName());

                                cpuArch.setText(OSResource.getcpuArch());

                                //cpuCore

                            }
                    );
                }
            };

            //0表示：任务安排好以后立即执行一次             1000表示：周期执行1000毫秒
            timer.schedule(timerTask, 0, 1000);

        } else{
            timerTask.cancel();
            timerTask=null;

        }


        //切换tab页 获取一个cpu占有率值
        //System.out.println("Tab select cpu="+ OSResource.getCPUPercetage());

        //测试切换tab页 得到响应输出
        //System.out.println("Tab selected");
    }


    // 磁盘目录扫描事件处理方法
    public void handleSelectFile(ActionEvent actionEvent) {

        // 1. 打开文件选择对话框     返回选择的目录file
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(primaryStage);


        // 2. 开启磁盘目录扫描线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FileTreeNode rootNode = new FileTreeNode();
                rootNode.setFile(file);
                rootNode.setFileName(file.getName());

                FileScanner.scannerDirectory(rootNode);

                TreeItem rooItem = new TreeItem(rootNode,new ImageView(image));

                //容许展开
                rooItem.setExpanded(true);

                fillTreeItem(rootNode,rooItem);

                // 3. 渲染TreeTableView
                //转换到主线程
                Platform.runLater(
                        ()->{
                            fileStat.setRoot(rooItem);
                        }
                );

            }
        });
        thread.setDaemon(true);
        thread.start();





        //测试按下按钮 得到响应输出
        //System.out.println("Button action");
    }



    private void fillTreeItem(FileTreeNode rootNode,TreeItem rootItem){
        List<FileTreeNode> childs=rootNode.getChildrens();
        for (FileTreeNode node:childs) {
            TreeItem item=new TreeItem(node);

            if(node.getChildrens().size()>0){
                item.setGraphic(new ImageView(image));
            }

            rootItem.getChildren().add(item);
            //逆向调用，转换子目录
            fillTreeItem(node,item);

        }

    }



    public void shutdown(){
        if(timer!=null){
            timer.cancel();
        }
    }





}
