package com.example.demo.Throttling;

class XYZ{
    public  void sayHello(){
        System.out.println("hello");
    }
    public static void saySomething(){
        System.out.println("i am xyz");
    }

}
public class MrRight{
    public static void main(String[] args) {
        XYZ xyz=new XYZ();
     xyz.sayHello();
     xyz=null;
     xyz.saySomething();
    }
}