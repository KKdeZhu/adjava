package Lab4;

import java.util.Random;

public class MatrixGenerator {
    private int row,column,column2;
    private double [] [] array1 = null;
    private double [] [] array2 = null;
    Random ran=new Random();
    public MatrixGenerator(int n,int m,int p) {
    	this.row = n;
    	this.column = m;
    	this.column2 = p;
    	array1 = new double [row][column];
    	array2 = new double [column][column2];
    }
    public void getMatrix() {
    	for(int i=0;i<this.row;i++) {
    		for(int j=0;j<this.column;j++) {
    			array1[i][j]=Math.abs(ran.nextDouble()*1000);
    		}
    	}
    	for(int i=0;i<this.column;i++) {
    		for(int j=0;j<this.column2;j++) {
    			array2[i][j]=Math.abs(ran.nextDouble()*1000);
    		}
    	}
    }
	public double[][] getArray1() {
		return array1;
	}
	public double[][] getArray2() {
		return array2;
	}

	
}
