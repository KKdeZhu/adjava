package homework2;

public class Singleton {
	private static final Singleton ins=new Singleton();
    private Singleton(){
    }//隐藏构造方法
	public static Singleton getInstance(){
	    return ins;
	}//返回类的唯一实例
}

