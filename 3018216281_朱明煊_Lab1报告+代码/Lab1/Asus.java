package Lab1;

public class Asus implements Mainboard {
	private String Name="Asus";
    private int speed = 144;
    private double price = 200.51;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Asus work");
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
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
