package com.linxz.androidinterview.kotlin

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


/**
 * @author Linxz
 * 创建日期：2020年08月25日 07:57
 * version：v5.0.0
 * 描述：
 */
class GlobalScopeTestMain {

    fun launchGlobalScope() {
//        val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
//            Log.d("KotlinTag", "1111")
//            delay(1000)
//            Log.d("KotlinTag", "2222")
//        }
//        Log.d("KotlinTag", "3333")
//        job.start()
//        job.cancel()


    }


    //异步
    fun main(){
        requestDataAsync{
            print(it)
        }
        Thread.sleep(3000)
    }

    fun requestDataAsync(callback: (String)->Unit) {
        Thread{
            // do something need lots of times.
            // ...
            Thread.sleep(1000)
            callback("success")
        }.start()
    }



    //假协程
    //获取数据的时候开启线程，当前线程await，新线程得到结果后notifyAll唤醒
    fun main2(){
        val data = async2Sync()  // 数据是同步返回了, 但是线程也阻塞了
        println("data is $data")
    }



    fun requestDataAsync2(callback: (String)->Unit) {
        Thread{
            // do something need lots of times.
            // ...
            Thread.sleep(1000)
            callback("success")
        }.start()
    }


    private var data = ""
    private val locker=Any()
    private fun async2Sync(): String {
        val obj = Object() // 随便创建一个对象当成锁使用
        requestDataAsync2 { data ->
            this.data = data  // 暂存data
            synchronized(locker) {
                obj.notifyAll() // 通知所有的等待者
            }
        }
        obj.wait() // 阻塞等待
        return this.data
    }



    //协程
    fun main3() = runBlocking {
        println("runBlocking协程")
        GlobalScope.launch {
            println("GlobalScope.launch协程")
        }.join() // 这里的join现在不理解没关系
        GlobalScope.async {
            println("GlobalScope.async协程")
        }.await() // 这里的await现在不理解没关系
        //runBlocking协程
        //GlobalScope.launch协程
        //GlobalScope.async协程
    }

    //runBlocking会阻塞当前线程的协程
    fun main4() {
        println("我在runBlocking之前 ${System.currentTimeMillis()}")
        runBlocking {
            println("我在runBlocking之中 ${System.currentTimeMillis()}")
            delay(2000) // 在协程中调用该方法会暂停当前协程指定时间，并不会阻塞线程
        }
        println("我在runBlocking之后 ${System.currentTimeMillis()}")
        //我在runBlocking之前 1588400909039
        //我在runBlocking之中 1588400909040
        //我在runBlocking之后 1588400911043
    }

    //launch不会阻塞当前协程
    fun main5() {
        println("main方法开始")
        GlobalScope.launch {
            println("GlobalScope.launch启动")
            delay(1000) // 防止协程过快结束
            println("GlobalScope.launch结束")
        }
        println("main方法结束")
        //main方法开始
        //main方法结束
        //GlobalScope.launch启动
    }


    fun main6() = runBlocking {
        println("runBlocking开始")
        launch {
            var count = 0L
            repeat(Int.MAX_VALUE) {
                count++
            }
            println("耗时任务结束 count = $count")
        }
        println("runBlocking结束")
        //runBlocking开始
        //runBlocking结束
        //耗时任务结束 count = 2147483647
    }



    //这里有一件是是很重要的，那就是协程与协程之间是存在父子关系的，父协程一定在其子协程结束之后才会结束。
    // 也就是说，父协程在执行完自己的代码逻辑后会检测与自己关联的子协程的状态，如果还有子协程没有执行完
    // （这里的没执行完是指协程处于活动状态，也就是isActive返回true的情况。如果isActive返回false则算是执行完了，
    // 即使还有代码逻辑在运行。），会一直等到子协程结束才会结束自己。
    //
    //正因为协程中存在父子关系，上面我在runBlocking中才会直接调用launch方法创建协程，而不是调用GlobalScope.launch来创建协程。
    // 假如将上面直接调用launch改成GlobalScope.launch，仅仅改成像下面这样的:

    fun main7() = runBlocking {
        println("runBlocking开始")
        GlobalScope.launch {
            var count = 0L
            repeat(Int.MAX_VALUE) {
                count++
            }
            println("耗时任务结束 count = $count")
        }
        println("runBlocking结束")
        //runBlocking开始
        //runBlocking结束

        //因为通过调用GlobalScope.launch方法创建的协程是没有父协程的，
        // 而在runBlocking中直接调用launch方法创建的协程是会建立父子关系，
        // 这样runBlocking会等到launch创建的协程执行完才结束。
    }



    fun main8() = runBlocking {
        println("runBlocking开始")
        val job = GlobalScope.launch {
            var count = 0L
            repeat(Int.MAX_VALUE) {
                count++
            }
            println("耗时任务结束 count = $count")
        }
        println("runBlocking结束")
        job.join() // 让当前协程等待job结束
        //runBlocking开始
        //runBlocking结束
        //耗时任务结束 count = 2147483647
    }


    //async 协程async方式，串行任务，代码从上到下依次执行
    fun main9() = runBlocking {
        val timeMillis = measureTimeMillis {
            val first = {
                Thread.sleep(1500) // 模拟耗时任务
                10
            }.invoke()
            val second = {
                Thread.sleep(2000) // 模拟耗时任务
                10
            }.invoke()
            println("first + second = ${first + second}")
        }
        println("timeMillis = ${timeMillis}")
        //first + second = 30
        //timeMillis = 3501
    }

    //async 协程async方式，并行任务，first跟second同时执行
    fun main10() = runBlocking {
        val timeMillis = measureTimeMillis {
            val first = GlobalScope.async {
                Thread.sleep(1500) // 模拟耗时任务
                10
            }
            val second =  GlobalScope.async {
                Thread.sleep(2000) // 模拟耗时任务
                10
            }
            println("first + second = ${first.await() + second.await()}")
        }
        println("timeMillis = ${timeMillis}")
    }





}