package com.bitedu.osm;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class OSResource {

    private static OperatingSystemMXBean mxBean=ManagementFactory.getPlatformMXBean(
            OperatingSystemMXBean.class);

    private static final int DATA_LENGTR=60;
    private static XYPair[] xyPairs=new XYPair[DATA_LENGTR];

    static{
        for (int i = 0; i <xyPairs.length ; ++i) {
            xyPairs[i]=new XYPair(0,0);
        }
    }

    //
    public static class XYPair{
        private double x;
        private double y;

        //有参构造方法
        public XYPair(double x, double y) {
            this.x = x;
            this.y = y;

        }

        //getter setter
        public double getY() {
            return y;
        }
        public void setY(double y) {
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public void setX(double x) {
            this.x = x;
        }
    }

    //获取cpu占有率
    public static XYPair[] getCPUPercetage(){
        double cpu=mxBean.getSystemCpuLoad();
        moveCPUData(cpu);
        return xyPairs;
    }


    private static void moveCPUData(double cpuPercetage){
        int movIdx = -1;
        if (firstIndex == 0){
            movIdx = firstIndex + 1;
        }else {
            movIdx = firstIndex;
            firstIndex--;
        }
        for (; movIdx < cpuDatas.length; ++movIdx){
            cpuDatas[movIdx-1].setX(cpuDatas[movIdx].getX()-1);
            cpuDatas[movIdx-1].setY(cpuDatas[movIdx].getY());
        }
        movIdx--;
        cpuDatas[movIdx] = new XYPair(movIdx, cpuPercetage);
    }



}
