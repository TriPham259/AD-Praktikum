package model;

import java.util.Objects;

/**
 * 
 * @author tripham
 *
 */
public class City {
	private String name;
	private String type;
	private int plz;
	private double area;
	private int total;
	private int men;
	private int women;

	/**
	 * Constructor for City.
	 * 
	 * @param name
	 *            Name of the city.
	 * @param type
	 *            Type of the city.
	 * @param plz
	 *            Postal code.
	 * @param area
	 *            Total area.
	 * @param total
	 *            Total population.
	 * @param men
	 *            Male population.
	 * @param women
	 *            Female population.
	 */
	public City(String name, String type, int plz, double area, int total, int men, int women) {
		this.name = name;
		this.type = type;
		this.plz = plz;
		this.area = area;
		this.total = total;
		this.men = men;
		this.women = women;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPlz() {
		return plz;
	}

	public double getArea() {
		return area;
	}

	public int getTotal() {
		return total;
	}

	public int getMen() {
		return men;
	}

	public int getWomen() {
		return women;
	}
	
	@Override
	public boolean equals(Object otherCity) {
		if (otherCity == this) return true;
		
        if (!(otherCity instanceof City)) {
            return false;
        }
        
        City city = (City) otherCity;
        
		return city.name.equals(name) && city.type.equals(type) && city.plz == plz
				&& city.area == area && city.total == total && city.men == men && city.women == women;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, type, plz, area, total, men, women);
	}

	@Override
	public String toString() {
		return String.format("City {name = %s, type = %s, plz = %05d, area = %.2f, total = %d, men = %d, women = %d}",
				name, type, plz, area, total, men, women);
	}

}
