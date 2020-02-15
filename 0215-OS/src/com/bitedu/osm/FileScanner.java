package com.bitedu.osm;

import java.io.File;

public class FileScanner {

    public static void scannerDirectory(FileTreeNode node){

        //获取当前目录的子目录或文件
        File[] files = node.getFile().listFiles();
        if (files == null) {
            return;
        }

        //遍历子目录或文件
        for (File file : files) {
            FileTreeNode child = new FileTreeNode();
            child.setFile(file);
            child.setFileName(file.getName());
            if (file.isDirectory()) {
                scannerDirectory(child);
            } else {
                child.setTotalLength(file.length());
            }
            node.setTotalLength(node.getTotalLength() + child.getTotalLength());
            node.addChildNode(child);
        }
    }

}
