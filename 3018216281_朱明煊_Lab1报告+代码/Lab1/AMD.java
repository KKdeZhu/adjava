package Lab1;

public class AMD implements CPU {
    private String Name = "AMD";
    private int coreNum = 8;
    private double price = 1000;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("AMD work");
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
