package com.linxz.algorithm.sort;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 08:14
 * version：v4.5.4
 * 描述：
 */
public class 排序_3折半插入排序 {

    public static void main(String[] args) {
        int[] array={156,88,141,111,35,100};
        int[] newArray=sortArray(array);
        for (int a:newArray){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("遍历次数："+count);
    }

    static int count=0;

    public static int[] sortArray(int[] array){
        int[] newArray=new int[array.length];
        for (int i=0;i<array.length;i++){
            insert(array[i],newArray);
            count++;
        }
        return newArray;
    }

    public static void insert(int e,int[] array){
        //要插入的下标
        int low=0;
        int height=array.length-1;
        int middle=(low+height)/2;
        while (low<=height){
            if (array[middle]>e){
                height=middle-1;
            }else{
                low=middle+1;
            }
            middle=(low+height)/2;
        }
        //141-->{0,0,0,0,88,156};
        //如果当前结点位置的结点比插入的结点大，则需要后移；如果当前结点比原来的结点小(相等)，则需要往前移
        if (array[middle]>e){
            for (int i=array.length-1;i<=middle;i--){
                array[i]=array[i-1];
            }
        }else{
            for (int i=1;i<=middle;i++){
                array[i-1]=array[i];
            }
        }
        array[middle]=e;
    }


    public static int[] binaryInsertSort(int[] data){
        for(int i=1;i<data.length;i++){
            if(data[i] < data[i-1]){
                //缓存i处的元素值
                int tmp = data[i];
                //记录搜索范围的左边界
                int low = 0;
                int high = i-1;
                while(low <= high){
                    //记录中间位置
                    int mid = (low+high)/2;
                    //比较中间位置数据和i处数据大小，以缩小搜索范围
                    if(data[mid] < tmp){
                        low = mid +1;
                    }else{
                        high = mid - 1;
                    }
                }
                //将low---i处的数据整体向后移动1位
                for(int j = i;j>low;j--){
                    data[j] = data[j-1];
                }
                data[low] = tmp;
            }
        }
        return data;
    }
}
