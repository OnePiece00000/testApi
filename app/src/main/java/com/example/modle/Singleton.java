package com.example.modle;
// 参考博客  https://blog.csdn.net/goodlixueyong/article/details/51935526
/*
* 饿汉模式
* 这种实现方式适合单例占用内存比较小，在初始化时就会被用到的情况。但是，如果单例占用的内存比较大，或单例只是在某个特定场景下才会用到，
* 使用饿汉模式就不合适了，这时候就需要用到懒汉模式进行延迟加载。
*  */
/*
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton() {
        return singleton;
    }
}

 */

/*
* 懒汉模式
 */
/*
public class Singleton {
    private static Singleton singleton = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

 */

/*
*  静态内部类
 */

public class Singleton {
    private static class SingletonHolder {
        public static Singleton singleton = new Singleton();
    }
    private Singleton() {}
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}




