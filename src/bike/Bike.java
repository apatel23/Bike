package bike;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Bike {
	
	private String file;
	private ArrayList<String> name;
	private String brand;
	private String model;
	private String frontGear;
	private String rearGear;
	private String speed;
	private String comp;
	private String compModel;
	private String wheelSet;
	private String tires;
	private int smallCog;
	private int largeCog;
	private int currentCog;
	private int smallChainRing;
	private int largeChainRing;
	private int currentChainRing;
	private ArrayList<Integer> rearGears;
	private ArrayList<Integer> frontChainRings;
	

	// Constructor
	Bike() {
		file = "GiantTCRAdv2.txt";
		name = new ArrayList<String>();
		brand = "";
		model = "";
		frontGear = "";
		rearGear = "";
		speed = "";
		comp = "";
		compModel = "";
		wheelSet = "";
		tires = "";
		smallCog = 0;
		largeCog = 0;
		currentCog = 0;
		smallChainRing = 0;
		largeChainRing = 0;
		currentChainRing = 0;
	}
	
	
	public void loadConfigFiles() {
		loadBikeFile();
		loadRearGearsFile();
		loadFrontChainRingFile();
	}
	
	
	public void loadBikeFile() {
		String line = "";
		String[] store = null;
		
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(file));
			while(in.hasNext()) {
				//name,brand,model,front gear,rear gear,speed,components,components model,wheel set,tires
				line = in.nextLine();
				store = line.split(",");
				name.add(store[0]);
				brand = store[1];
				model = store[2];
				frontGear = store[3];
				rearGear = store[4];
				speed = store[5];
				comp = store[6];
				compModel = store[7];
				wheelSet = store[8];
				tires = store[9];
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	public void loadRearGearsFile() {
		rearGears = new ArrayList<Integer>();
		
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("RearGears.txt"));
			while(in.hasNext()) {
				rearGears.add(in.nextInt());
			}
			
			setSmallCog(rearGears.get(0));
			setLargeCog(rearGears.get(rearGears.size()-1));
			setCurrentCog(0);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadFrontChainRingFile() {
		frontChainRings = new ArrayList<Integer>();
		
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("FrontGears.txt"));
			while(in.hasNext()) {
				frontChainRings.add(in.nextInt());
			}
			
			setSmallChainRing(frontChainRings.get(0));
			setLargeChainRing(frontChainRings.get(frontChainRings.size()-1));
			setCurrentChainRing(0);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Integer> getFrontChainRings() {
		return frontChainRings;
	}

	public void setFrontChainRings(ArrayList<Integer> frontChainRings) {
		this.frontChainRings = frontChainRings;
	}

	public void setCurrentChainRing(int currentChainRing) {
		this.currentChainRing = currentChainRing;
	}
	
	public void setSmallChainRing(int smallChainRing) {
		this.smallChainRing = smallChainRing;
	}
	
	public void setLargeChainRing(int largeChainRing) {
		this.largeChainRing = largeChainRing;
	}
	
	public void setCurrentCog(int currentCog) {
		this.currentCog = currentCog;
	}
	
	public void setSmallCog(int smallCog) {
		this.smallCog = smallCog;
	}
	
	public void setLargeCog(int largeCog) {
		this.largeCog = largeCog;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFrontGear() {
		return frontGear;
	}

	public void setFrontGear(String frontGear) {
		this.frontGear = frontGear;
	}

	public String getRearGear() {
		return rearGear;
	}

	public void setRearGear(String rearGear) {
		this.rearGear = rearGear;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getCompModel() {
		return compModel;
	}

	public void setCompModel(String compModel) {
		this.compModel = compModel;
	}

	public String getWheelSet() {
		return wheelSet;
	}

	public void setWheelSet(String wheelSet) {
		this.wheelSet = wheelSet;
	}

	public String getTires() {
		return tires;
	}

	public void setTires(String tires) {
		this.tires = tires;
	}
	
	public ArrayList<Integer> getRearGears() {
		return rearGears;
	}

	public void setRearGears(ArrayList<Integer> rearGears) {
		this.rearGears = rearGears;
	}
	
	public int getCurrentCog() {
		return currentCog;
	}
}
