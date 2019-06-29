package com.myrunnable;
/*
 * 使用Runnable接口创建线程的步骤：
 * 1.创建实现Runnable接口的类MyRunnable，并在MyRunable类的run()方法里编写想让线程执行的代码;
 * 2.创建实现了Runnable接口类的实例：myRunnable;
 * 3.创建线程类Thread的实例，并用构造方法(Runnable target)将myRunnable赋值给target
 */
public class MyRunnable implements Runnable {
	String threadName;
	
	public MyRunnable(String threadName) {	//构造方法（传入线程名字、输出）
		System.out.println("本线程的名字：" + threadName);
		this.threadName = threadName;
	}
	
	public void run() {	//包含线程运行时所执行的代码
		for(int i = 0; i < 3; i++) {
			System.out.println("正在运行的线程是" + threadName);
			try {
				Thread.sleep((int)(Math.random() * 1000));	//让线程休眠一段时间（随机）
			} catch(InterruptedException e) {
				System.err.println(e.toString());	//System.err：对应标准错误流
			}
		}	//for
	}	//run
	
	public static void main(String[] args) {
		System.out.println("开始运行主函数");
		MyRunnable myRunnable1 = new MyRunnable("如来");		//创建实现了Runnable接口类的实例
		MyRunnable myRunnable2 = new MyRunnable("孙悟空");
		Thread thread1 = new Thread(myRunnable1);
		//创建线程类实例，并由构造方法Thread(Runnable target)将myRunnable赋值给target
		Thread thread2 = new Thread(myRunnable2);
		thread1.start();	//用于启动线程
		thread2.start();
		System.out.println("主函数运行结束");
	}

}