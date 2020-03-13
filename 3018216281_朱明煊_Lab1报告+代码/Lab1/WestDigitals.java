package Lab1;

public class WestDigitals implements Hard_disk {
	private String Name="WestDigitals";
    private int volume = 32;
    private double price = 200.5;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("WestDigitals work");
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
	public int getVolume() {
		// TODO Auto-generated method stub
		return volume;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
