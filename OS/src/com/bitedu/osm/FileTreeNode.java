package com.bitedu.osm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTreeNode {
    String fileName;         //文件名
    long totalLength;       //文件总长度
    private File file;      //记录系统文件对象

    List<FileTreeNode> childrens=new ArrayList<>();

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public long getTotalLength() {
        return totalLength;
    }
    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }


    public List<FileTreeNode> getChildrens() {
        return childrens;
    }
    public void setChildrens(List<FileTreeNode> childrens) {
        this.childrens = childrens;
    }
    //方法
    public void addChildNode(FileTreeNode node) {
        this.childrens.add(node);
    }


    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }


}
