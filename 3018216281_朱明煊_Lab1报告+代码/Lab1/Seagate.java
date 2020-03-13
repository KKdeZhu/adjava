package Lab1;

public class Seagate implements Hard_disk {
	private String Name="Seagate";
    private int volume = 16;
    private double price = 250.5;
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Seagate work");
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
