package com.myrunnable;
/*
 * ʹ��Runnable�ӿڴ����̵߳Ĳ��裺
 * 1.����ʵ��Runnable�ӿڵ���MyRunnable������MyRunable���run()�������д�����߳�ִ�еĴ���;
 * 2.����ʵ����Runnable�ӿ����ʵ����myRunnable;
 * 3.�����߳���Thread��ʵ�������ù��췽��(Runnable target)��myRunnable��ֵ��target
 */
public class MyRunnable implements Runnable {
	String threadName;
	
	public MyRunnable(String threadName) {	//���췽���������߳����֡������
		System.out.println("���̵߳����֣�" + threadName);
		this.threadName = threadName;
	}
	
	public void run() {	//�����߳�����ʱ��ִ�еĴ���
		for(int i = 0; i < 3; i++) {
			System.out.println("�������е��߳���" + threadName);
			try {
				Thread.sleep((int)(Math.random() * 1000));	//���߳�����һ��ʱ�䣨�����
			} catch(InterruptedException e) {
				System.err.println(e.toString());	//System.err����Ӧ��׼������
			}
		}	//for
	}	//run
	
	public static void main(String[] args) {
		System.out.println("��ʼ����������");
		MyRunnable myRunnable1 = new MyRunnable("����");		//����ʵ����Runnable�ӿ����ʵ��
		MyRunnable myRunnable2 = new MyRunnable("�����");
		Thread thread1 = new Thread(myRunnable1);
		//�����߳���ʵ�������ɹ��췽��Thread(Runnable target)��myRunnable��ֵ��target
		Thread thread2 = new Thread(myRunnable2);
		thread1.start();	//���������߳�
		thread2.start();
		System.out.println("���������н���");
	}

}