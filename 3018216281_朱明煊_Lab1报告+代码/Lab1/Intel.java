package Lab1;

public class Intel implements CPU {
	private String Name = "Intel";
    private int coreNum = 4;
    private double price = 600.5;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Intel work");
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public int getcoreNum() {
		// TODO Auto-generated method stub
		return coreNum;
	}
	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
