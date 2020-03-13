package Lab1;

public class Gigabyte implements Mainboard {
	private String Name="Gigabyte";
    private int speed = 288;
    private double price = 400.11;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Gigabyte work");
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
