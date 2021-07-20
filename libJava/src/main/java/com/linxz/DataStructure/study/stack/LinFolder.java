package com.linxz.DataStructure.study.stack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年01月04日 21:44
 * version：
 * 描述：
 */
public class LinFolder {
    static ListQueue<File> queueList = new ListQueue();


    static ListStack<File> list = new ListStack<File>();

    static List<File> list1 = new ArrayList<>();
    static List<File> list2 = new ArrayList<>();

    static List<File> listQueue=new ArrayList<>();

    public static void findFileQueue(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    queueList.enqueue(files[i]);


                } else {
                    System.out.println(files[i].getName());
                    listQueue.add(files[i]);

                }
            }

        } else {
            System.out.println(file.getName());
            listQueue.add(file);


        }
        while (!queueList.empty()) {
            File fileQueue = queueList.dequeue();
            File[] filesQueue = fileQueue.listFiles();
            for (int i = 0; i < filesQueue.length; i++) {
                if (filesQueue[i].isDirectory()) {
                    queueList.enqueue(filesQueue[i]);

                } else {
                    System.out.println(filesQueue[i].getName());
                    listQueue.add(filesQueue[i]);
                }
            }

        }
    }

    public static void findFile(File file) {
        if (!file.isDirectory()) {
            System.out.println(file.getName());
            list1.add(file);
        } else {
            File[] files = file.listFiles();
            if (files == null)
                return;
            for (File value : files) {
                if (value.isDirectory()) {
                    findFile(value);
                } else {
                    System.out.println(value.getName());
                    list1.add(value);
                }
            }
        }
    }

    public static void findFileStack(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    list.push(files[i]);

                } else {
                    System.out.println(files[i].getName());
                    list2.add(files[i]);

                }
            }

        } else {
            System.out.println(file.getName());
            list2.add(file);
        }
        while (!list.empty()) {
            File filePop = list.pop();
            File[] filesPop = filePop.listFiles();
            for (int j = 0; j < filesPop.length; j++) {
                if (filesPop[j].isDirectory()) {
                    list.push(filesPop[j]);


                } else {
                    System.out.println(filesPop[j].getName());
                    list2.add(filesPop[j]);
                }


            }

        }
    }

    public static void findFile2(File file) {

    }


    public static void main(String[] args) {
        findFile(new File("/Users/linxz/Desktop/APP"));
//        findFileStack(new File("/Users/linxz/Desktop/APP"));
        System.out.println(list1.size());
//        System.out.println(list2.size());
        findFileQueue(new File("/Users/linxz/Desktop/APP"));
        System.out.println(listQueue.size());

    }

}
//我们的配置.png
//APP用户列表.png
//用户详情.png
//订单详情.png
//检测订单列表.png
//订单列表.png
//用户列表.png
//维保订单详情.png
//价格配置.png
//.DS_Store
//编辑.png
//修改密码.png
//新增用户.png
//完善信息.png
//用户主页.png
//二手车鉴定评估委托书.png
//评估日.png
//车辆检测.png
//待检测数据.png
//车辆列表.png
//管理员.png
//个人中心.png
//首页.png
//行驶证信息收集.png
//车辆列表.png
//优惠券详情.png
//下啦列表.png
//创建优惠券.png
//列表选择.png
//优惠券列表.png
//.DS_Store
//维保订单报告.png
//VIN查询.png
//VIN输入查询.png
//爱车估值.png
//车辆信息.png