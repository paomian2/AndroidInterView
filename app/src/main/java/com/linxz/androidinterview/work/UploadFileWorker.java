package com.linxz.androidinterview.work;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.linxz.androidinterview.utils.CommonUtils;

/**
 * @author Linxz
 * 创建日期：2020年06月12日 12:00
 * version：v4.5.4
 * 描述：
 */
public class UploadFileWorker extends Worker {

    public UploadFileWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data inputData=getInputData();
        String filePath=inputData.getString("filePath");
        String fileUrl=doInbacground(filePath);
        if (!TextUtils.isEmpty(fileUrl)){
            Data outputData = new Data.Builder().putString("fileUrl", fileUrl)
                    .build();
            return Result.success(outputData);
        }
        return Result.failure();
    }

    /**
     * 业务处理
     * */
    private String doInbacground(String filePath){
       Log.d("TAG","文件地址:"+filePath+"  是否是UI线程:"+ CommonUtils.isUIThread());
       return "http://1234";
    }
}
