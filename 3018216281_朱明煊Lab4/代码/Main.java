package Lab4;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
public class Main extends Thread {
	private double[][] A;
	private double[][] B;
	private int index;
	private int gap;
	private double[][] result;
	private CountDownLatch countDownLatch;
 
	public Main(double[][] A, double[][] B, int index, int gap, double[][] result, CountDownLatch countDownLatch) {
		this.A = A;
		this.B = B;
		this.index = index;
		this.gap = gap;
		this.result = result;
		this.countDownLatch = countDownLatch;
	}
 
	// 计算特定范围内的结果
	public void run() {
		// TODO Auto-generated method stub
		for (int i = index * gap; i < (index + 1) * gap; i++)
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < B.length; k++)
					result[i][j] += A[i][k] * B[k][j];
			}
		// 线程数减1
		countDownLatch.countDown();
	}
 
	public static void main(String[] args) throws InterruptedException {
		System.out.println("请输入两个矩阵的行与列");
		long startTime;
		long endTime;
		Scanner input = new Scanner(System.in);
		int row_A = input.nextInt();
		int col_A = input.nextInt();
		int col_B = input.nextInt();
		double[][] A = new double[row_A][col_A];
		double[][] B = new double[col_A][col_B];
        //存放并行计算结果
		double[][] p_result = new double[A.length][B[0].length];
        //存放串行计算结果
		double[][] s_result = new double[A.length][B[0].length];
        //子线程数量
		int threadNum = 10;
        //子线程的分片计算间隔
		int gap = A.length / threadNum;
		CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		// 为A和B矩阵随机赋值
	    MatrixGenerator m1 = new  MatrixGenerator(row_A,col_A,col_B);
	    m1.getMatrix();
	    A = m1.getArray1();
	    B = m1.getArray2();
		//串行
		startTime = System.currentTimeMillis();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++)
					s[i][j] += A[i][k] * B[k][j];
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("串行计算开始时刻:" + (startTime));
		System.out.println("串行计算结束时刻:" + (endTime));
		System.out.println("串行计算运行时间:" + (endTime - startTime));

		//并行
		startTime = System.currentTimeMillis();
		for (int i = 0; i < threadNum; i++) {
			Calu ct = new Calu(A, B, i, gap, p_result, countDownLatch);
			ct.start();
		}
		countDownLatch.await();
		endTime = System.currentTimeMillis();
		System.out.println("并行计算开始时刻:" + (startTime));
		System.out.println("并行计算结束时刻:" + (endTime));
		System.out.println("并行计算运行时间:" + (endTime - startTime));
		
		boolean flag = true;
		for(int i=0;i<A.length;i++) {
		    for(int j=0;j<B[0].length;j++) {
		        if(p_result[i][j]!=s_result[i][j]) {
		    	    flag = false;
		        }
		    }
		 }
		if(flag) {
		    System.out.println("结果一致");
		}
	}
}

