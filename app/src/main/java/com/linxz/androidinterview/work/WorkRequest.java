package com.linxz.androidinterview.work;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.linxz.androidinterview.App;
import com.linxz.androidinterview.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2020年06月12日 13:41
 * version：v4.5.4
 * 描述：
 */
public class WorkRequest {

    private AppCompatActivity activity;

    private WorkRequest(AppCompatActivity appCompatActivity){
        this.activity=appCompatActivity;
    }

    public static WorkRequest getInstance(AppCompatActivity appCompatActivity){
        return new WorkRequest(appCompatActivity);
    }

    public void request(){
        List<OneTimeWorkRequest> workRequests = new ArrayList<>();
        OneTimeWorkRequest request = getOneTimeWorkRequest("file://test1234");
        workRequests.add(request);
        enqueue(workRequests);
    }

    private void enqueue(List<OneTimeWorkRequest> workRequests) {
        WorkContinuation workContinuation = WorkManager.getInstance(App.instance).beginWith(workRequests);
        workContinuation.enqueue();
        workContinuation.getWorkInfosLiveData().observe(activity, new Observer<List<WorkInfo>>() {
            @Override
            public void onChanged(List<WorkInfo> workInfos) {
                //发起请求了之后会走三次这个onChange方法，第一次是ENQUEUE，第二次是RUNNING,第三次是SUCCEEDED OR FAILED
                if (workInfos.size()>0){
                    for (WorkInfo workInfo:workInfos){
                        if (workInfo.getState()== WorkInfo.State.SUCCEEDED){
                            String fileUrl=workInfo.getOutputData().getString("fileUrl");
                            Log.d("TAG","网络地址:"+fileUrl+"  是否是UI线程:"+ CommonUtils.isUIThread());
                        }
                    }
                }
            }
        });
    }

    private OneTimeWorkRequest getOneTimeWorkRequest(String filePath){
        Data inputData = new Data.Builder()
                .putString("filePath", filePath)
                .build();
//        @SuppressLint("RestrictedApi") Constraints constraints = new Constraints();
//        //设备存储空间充足的时候 才能执行 ,>15%
//        constraints.setRequiresStorageNotLow(true);
//        //必须在执行的网络条件下才能好执行,不计流量 ,wifi
//        constraints.setRequiredNetworkType(NetworkType.UNMETERED);
//        //设备的充电量充足的才能执行 >15%
//        constraints.setRequiresBatteryNotLow(true);
//        //只有设备在充电的情况下 才能允许执行
//        constraints.setRequiresCharging(true);
//        //只有设备在空闲的情况下才能被执行 比如息屏，cpu利用率不高
//        constraints.setRequiresDeviceIdle(true);
//        //workmanager利用contentObserver监控传递进来的这个uri对应的内容是否发生变化,当且仅当它发生变化了
//        //我们的任务才会被触发执行，以下三个api是关联的
//        constraints.setContentUriTriggers(null);
//        //设置从content变化到被执行中间的延迟时间，如果在这期间。content发生了变化，延迟时间会被重新计算
        //这个content就是指 我们设置的setContentUriTriggers uri对应的内容
//        constraints.setTriggerContentUpdateDelay(0);
//        //设置从content变化到被执行中间的最大延迟时间
        //这个content就是指 我们设置的setContentUriTriggers uri对应的内容
//        constraints.setTriggerMaxContentDelay(0);
        OneTimeWorkRequest request = new OneTimeWorkRequest
                .Builder(UploadFileWorker.class)
                .setInputData(inputData)
//                .setConstraints(constraints)
//                //设置一个拦截器，在任务执行之前 可以做一次拦截，去修改入参的数据然后返回新的数据交由worker使用
//                .setInputMerger(null)
//                //当一个任务被调度失败后，所要采取的重试策略，可以通过BackoffPolicy来执行具体的策略
//                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10, TimeUnit.SECONDS)
//                //任务被调度执行的延迟时间
//                .setInitialDelay(10, TimeUnit.SECONDS)
//                //设置该任务尝试执行的最大次数
//                .setInitialRunAttemptCount(2)
//                //设置这个任务开始执行的时间
//                //System.currentTimeMillis()
//                .setPeriodStartTime(0, TimeUnit.SECONDS)
//                //指定该任务被调度的时间
//                .setScheduleRequestedAt(0, TimeUnit.SECONDS)
//                //当一个任务执行状态编程finish时，又没有后续的观察者来消费这个结果，难么workamnager会在
//                //内存中保留一段时间的该任务的结果。超过这个时间，这个结果就会被存储到数据库中
//                //下次想要查询该任务的结果时，会触发workmanager的数据库查询操作，可以通过uuid来查询任务的状态
//                .keepResultsForAtLeast(10, TimeUnit.SECONDS)
                .build();
        return request;
    }
}
