package com.linxz.androidinterview.kotlin

import android.widget.Toast
import com.linxz.androidinterview.App
import kotlinx.coroutines.*
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

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

    suspend fun foo(){}




    suspend fun getUser(name:String)= suspendCoroutine<User> {
        continuation ->

    }

}