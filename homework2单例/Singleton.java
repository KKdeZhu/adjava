package homework2;

public class Singleton {
	private static final Singleton ins=new Singleton();
    private Singleton(){
    }//���ع��췽��
	public static Singleton getInstance(){
	    return ins;
	}//�������Ψһʵ��
}

