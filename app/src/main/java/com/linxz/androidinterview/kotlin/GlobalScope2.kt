package com.linxz.androidinterview.kotlin

import android.util.Log
import android.widget.Toast
import com.linxz.androidinterview.App
import com.linxz.net.HttpClientCreator
import com.linxz.net.bean.UserResp
import kotlinx.coroutines.*
import okhttp3.internal.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.concurrent.thread
import kotlin.coroutines.*

/**
 * @author Linxz
 * 创建日期：2020年10月26日 10:57
 * version：
 * 描述：
 */
class GlobalScope2 {

    fun main(){
        repeat(100_000){
            thread{
                Thread.sleep(1000L)
                print(".")
            }
        }
    }


    fun loadData(){
        GlobalScope.launch(Dispatchers.IO) { //切换IO线程
            val data=fetchData()
            withContext(Dispatchers.Main){ //切换主线程
                print(data)
                //show(data)
            }
        }
    }

    suspend fun fetchData():String{
        delay(2000)
        return "success"
    }



    fun main2(){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val name = getMessageFromNetwork()
                Toast.makeText(App.instance.applicationContext,name,Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(App.instance.applicationContext,e.message,Toast.LENGTH_SHORT).show()
            }
        }


    }

    /**
     * 从服务器取信息
     */
    private suspend fun getMessageFromNetwork(): String {
        var name = ""
        withContext(Dispatchers.IO) {
            delay(3000)
            name = "success"
        }
        if (""==name){
            throw IllegalArgumentException("加载失败啦")
        }
        return name
    }



    suspend fun mainTest(){
        val bar=foo()
    }

     fun mainTest2(){
         GlobalScope.launch(Dispatchers.Main) {
             val bar=foo()
         }
    }

    suspend fun foo():String{
        return "白菜"
    }

    fun foo2(continuation: Continuation<String>):Any{
        return "白菜"
    }

    //suspend方法会传一个continuation进来
    //真正的挂起必须异步调用resume，包括：1.切换到其它线程resume  2.单线程时间循环异步执行
    //直接return或者在suspendCoroutine中直接调用resume也算没有挂起

    //suspend使用suspendCoroutine获取挂起函数continuation
    //回调成功的分支使用continuation.resume(),
    //回调失败分支使用continuation.resumeWithException
    suspend fun getUserList()= suspendCoroutine<User> {
        continuation ->
        HttpClientCreator.getInstance().gitHubApi().listRepos("octocat")
                .enqueue(object : Callback<List<UserResp>>{
                    override fun onResponse(call: Call<List<UserResp>>, response: Response<List<UserResp>>) {
                       response.takeIf{
                           it.isSuccessful
                       }?.body()?.let { continuation::resume }
                    }

                    override fun onFailure(call: Call<List<UserResp>>?, t: Throwable)=continuation.resumeWithException(t)
                })
    }


    //创建协程方法1
    fun createCoroutineTest(){
        suspend {
            //val foo=foo()
            try {
                val name = getMessageFromNetwork()
                Toast.makeText(App.instance.applicationContext,name,Toast.LENGTH_SHORT).show()
                //System.err: java.lang.RuntimeException: Can't toast on a thread that has not called Looper.prepare()
            }catch (e:Exception){
                e.printStackTrace()
                //Toast.makeText(App.instance.applicationContext,"success",Toast.LENGTH_SHORT).show()
            }
        }.createCoroutine(object : Continuation<Unit>{
            override val context=EmptyCoroutineContext
            override fun resumeWith(result: Result<Unit>) {
                Log.d("TAG","Coroutine End with${result}")
                //Toast.makeText(App.instance.applicationContext,"$result",Toast.LENGTH_SHORT).show()
                // Caused by: java.lang.RuntimeException: Can't toast on a thread that has not called Looper.prepare()
            }
        }).resume(Unit)
        //调用协程就能启动协程了
    }

    //创建协程方法2
    //上面使用resume启动，startCoroutine这里创建完之后直接启动
    fun createCoroutineTest2(){
        suspend {
            try {
                val name = getMessageFromNetwork()
                printValue(name)
                //Toast.makeText(App.instance.applicationContext,name,Toast.LENGTH_SHORT).show()
                //System.err: java.lang.RuntimeException: Can't toast on a thread that has not called Looper.prepare()
            }catch (e:Exception){
                e.printStackTrace()
                //Toast.makeText(App.instance.applicationContext,"success",Toast.LENGTH_SHORT).show()
            }
        }.startCoroutine(object : Continuation<Unit>{
            override val context=EmptyCoroutineContext
            override fun resumeWith(result: Result<Unit>) {
                Log.d("TAG","Coroutine End with${result}")
                //Toast.makeText(App.instance.applicationContext,"$result",Toast.LENGTH_SHORT).show()
                // Caused by: java.lang.RuntimeException: Can't toast on a thread that has not called Looper.prepare()
            }
        })
    }


    private fun printValue(name:String){
        Log.d("TAG ","$name")
    }

}