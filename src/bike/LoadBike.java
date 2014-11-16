package bike;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadBike {
	
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

	// Constructor
	LoadBike() {
		file = "BikeConfig.txt";
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
	}
	
	public void loadConfigFiles() {
		String line = "";
		String[] store = null;
		
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(file));
			System.out.println("opened");
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
	
}
