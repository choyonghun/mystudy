// sychronized 메서드
package com.eomcs.concurrent.ex5;

public class Exam0530 {
  public static void main(String[] args) {
    Job job1 = new Job();
    Job job2 = new Job();
    
    Worker w1 = new Worker("홍길동", job1);
    Worker w2 = new Worker("임꺽정", job2);
    
    w1.start();
    w2.start();
    
  }
  
  static class Job {
    // 같은 변수 (= 인스턴스) 에 대해 여러 스레드가 동시에 진입하는것을 막는다
    // 만약 다른 변수(= 인스턴스)라면?
    // -막지 않는다.
    synchronized void play(String threadName) throws Exception {
      System.out.println(threadName);
      Thread.sleep(10000);
    }
  }
  
  static class Worker extends Thread {
      Job job;
      
      public Worker(String name, Job job) {
        super(name);
        this.job = job;
    }
  
  
      @Override
      public void run() {
        try { 
          for(int i = 0; i < 10; i++) {
            job.play(getName());
            delay();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
  
  
  private void delay() {
    int delayCount = (int)(Math.random() * 1000);
    for (int i = 0; i < delayCount; i++)
      Math.asin(45.765);    // cpu 뺏길 기회를 제공
  }
}
}
