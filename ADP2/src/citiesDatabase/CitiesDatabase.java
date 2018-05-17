package citiesDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.City;
import model.Col;
import model.Criterion;

/**
 * 
 * @author tripham
 *
 */
public class CitiesDatabase {
	private ArrayList<City> cities = new ArrayList<>();

	/**
	 * Constructor for CitiesDatabase. It reads from the a csv file line by line,
	 * creates a new City for each line and adds it to a list of cities.
	 * 
	 * @param pathname
	 *            Path to the csv file.
	 * @throws FileNotFoundException.
	 */
	public CitiesDatabase(String pathname) throws FileNotFoundException {
		// create scanner from pathname
		Scanner scanner = new Scanner(new File(pathname));

		while (scanner.hasNextLine()) {
			// get and split one line
			String line = scanner.nextLine();
			String[] data = line.split(";\\s*");

			// get name and type
			String[] nameAndType = data[0].split(",\\s*");
			String name = nameAndType[0];
			String type = "";
			if (nameAndType.length > 1) {
				type = nameAndType[1];
			}

			// get plz
			int plz = Integer.parseInt(data[1]);

			// get area
			double area = Double.parseDouble(data[2].replaceAll(",", "."));

			// get total, men and women
			String totalStr = data[3].replaceAll(" ", "");
			int total = 0;
			if (!totalStr.equals("/")) {
				total = Integer.parseInt(totalStr);
			}

			String menStr = data[4].replaceAll(" ", "");
			int men = 0;
			if (!menStr.equals("/")) {
				men = Integer.parseInt(menStr);
			}

			String womenStr = data[5].replaceAll(" ", "");
			int women = 0;
			if (!womenStr.equals("/")) {
				women = Integer.parseInt(womenStr);
			}

			// create a city from the data of the line
			City aCity = new City(name, type, plz, area, total, men, women);

			// add the city into database
			cities.add(aCity);
		}

		scanner.close();
	}

	/**
	 * Create a list with a specific number of cities. (count from the start of
	 * original list)
	 * 
	 * @param citiesNum
	 *            Number of cities needed to be in the list.
	 * @return List of cities.
	 * @throws IllegalArgumentException.
	 */
	public List<City> load(int citiesNum) throws IllegalArgumentException {
		if (citiesNum < 0 || citiesNum > cities.size()) {
			throw new IllegalArgumentException("Illegal citiesNum.");
		}

		return cities.subList(0, citiesNum);
	}

	// /**
	// * Find a list of Cities that satisfies all given Criteria. (linear search
	// using stream)
	// *
	// * @param critList
	// * List of Criteria.
	// * @return A new list of Cities that satisfies all given Criteria.
	// */
	// public List<City> find(List<City> cities, List<Criterion> critList) {
	// // list of conditions made from critList
	// List<Predicate<City>> preds = new ArrayList<>();
	//
	// // extract single conditions form each Criteria
	// for (Criterion crit : critList) {
	// // a (single) condition
	// Predicate<City> pred;
	//
	// // condition for total area
	// if (crit.getCol() == Col.AREA) {
	// pred = c -> c.getArea() >= crit.getMin() && c.getArea() <= crit.getMax();
	// }
	//
	// // condition for plz
	// else if (crit.getCol() == Col.PLZ) {
	// pred = c -> c.getPlz() >= crit.getMin() && c.getPlz() <= crit.getMax();
	// }
	//
	// // condition for total population
	// else if (crit.getCol() == Col.TOTAL) {
	// pred = c -> c.getTotal() >= crit.getMin() && c.getTotal() <= crit.getMax();
	// }
	//
	// // condition for male population
	// else if (crit.getCol() == Col.MEN) {
	// pred = c -> c.getMen() >= crit.getMin() && c.getMen() <= crit.getMax();
	// }
	//
	// // condition for female population
	// else {
	// pred = c -> c.getWomen() >= crit.getMin() && c.getWomen() <= crit.getMax();
	// }
	//
	// // add extracted condition to the condition list
	// preds.add(pred);
	// }
	//
	// // combine the conditions with the logical AND
	// Predicate<City> andPred = preds.stream().reduce(Predicate::and).orElse(x ->
	// true);
	//
	// // return list of cities that satisfy the tatal condition
	// return cities.stream().filter(andPred).collect(Collectors.toList());
	// }

	/**
	 * Find a list of Cities that satisfies all given Criteria. (using binary
	 * search)
	 * 
	 * @param critList
	 *            List of Criteria.
	 * @return A new list of Cities that satisfies all given Criteria.
	 */
	public List<City> find(List<City> cities, List<Criterion> critList) {
		List<City> res = new ArrayList<>(cities);
		int size;

		// "recursively" extract sublist that satisfies all crit one after another
		for (Criterion crit : critList) {
			Col col = crit.getCol();

			// sort the original list after col
			switch (col) {
			case AREA:
				res.sort(Comparator.comparing(City::getArea));
				break;
			case PLZ:
				res.sort(Comparator.comparing(City::getPlz));
				break;
			case TOTAL:
				res.sort(Comparator.comparing(City::getTotal));
				break;
			case MEN:
				res.sort(Comparator.comparing(City::getMen));
				break;
			default:
				res.sort(Comparator.comparing(City::getWomen));
				break;
			}

			// extract sublist that satisfies crit (leftBound <= col <= rightBound)
			size = res.size();
			int leftBound = binarySearchForLeftRange(res, size, crit.getMin(), col);
			int rightBound = binarySearchForRightRange(res, size, crit.getMax(), col);

			res = res.subList(leftBound, rightBound + 1);

			// stop if result list is empty (aka. one criteria can't be satisfied)
			if (res.isEmpty()) {
				break;
			}
		}

		return res;
	}

	/**
	 * Binary search the lower bound of a certain criterion of a list of cities that
	 * is greater or equal a given integer. The list must be sorted after this
	 * criterion.
	 * 
	 * @param a
	 *            List of cities.
	 * @param length
	 *            Length of the list.
	 * @param left_range
	 *            Given left bound.
	 * @param col
	 *            Name of the criterion.
	 * @return index of the lower bound of the list.
	 */
	public static int binarySearchForLeftRange(List<City> a, int length, int left_range, Col col) {
		City city;
		double lastElem; // an attribute of the last city on the list

		// get the last element of the list
		city = a.get(length - 1);
		lastElem = col == Col.AREA ? city.getArea()
				: col == Col.PLZ ? city.getPlz()
						: col == Col.TOTAL ? city.getTotal() : col == Col.MEN ? city.getMen() : city.getWomen();

		// if left range > lastElem -> out of bound
		if (lastElem < left_range)
			return -1;

		int low = 0;
		int high = length - 1;

		// binary search (end when low = mid > high)
		while (low <= high) {
			int mid = low + ((high - low) / 2);

			city = a.get(mid);
			lastElem = col == Col.AREA ? city.getArea()
					: col == Col.PLZ ? city.getPlz()
							: col == Col.TOTAL ? city.getTotal() : col == Col.MEN ? city.getMen() : city.getWomen();

			if (lastElem >= left_range)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return high + 1;
	}

	/**
	 * Binary search the upper bound of a certain criterion of a list of cities
	 * that's less than or equal a given integer. The list must be sorted after this
	 * criterion.
	 * 
	 * @param a
	 *            List of cities.
	 * @param length
	 *            Length of the list.
	 * @param left_range
	 *            Given right bound.
	 * @param col
	 *            Name of the criterion.
	 * @return index of the upper bound of the list.
	 */
	public static int binarySearchForRightRange(List<City> a, int length, int right_range, Col col) {
		City city;
		double firstElem; // an attribute of the first city on the list

		// get the first element of the list
		city = a.get(0);
		firstElem = col == Col.AREA ? city.getArea()
				: col == Col.PLZ ? city.getPlz()
						: col == Col.TOTAL ? city.getTotal() : col == Col.MEN ? city.getMen() : city.getWomen();

		// if right range < lastElem -> out of bound
		if (firstElem > right_range)
			return -1;

		int low = 0;
		int high = length - 1;

		// binary search (end when low > mid = high)
		while (low <= high) {
			int mid = low + ((high - low) / 2);

			city = a.get(mid);
			firstElem = col == Col.AREA ? city.getArea()
					: col == Col.PLZ ? city.getPlz()
							: col == Col.TOTAL ? city.getTotal() : col == Col.MEN ? city.getMen() : city.getWomen();

			if (firstElem > right_range)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return low - 1;
	}

	/**
	 * get the list of cities
	 * 
	 * @return cities list of cities in database
	 */
	public ArrayList<City> getCities() {
		return cities;
	}

	// public static void main(String[] args) throws FileNotFoundException {
	// CitiesDatabase myCityDatabase = new CitiesDatabase("StaedteStatistik.csv");
	// List<City> myCities = myCityDatabase.load(2058);
	//
	// Criterion newTotalCrit = new Criterion(Col.TOTAL, 14000, 15000);
	// Criterion newMenCrit = new Criterion(Col.MEN, 5000, 7000);
	// Criterion newWomenCrit = new Criterion(Col.WOMEN, 5000, 8000);
	//
	// List<Criterion> critList = new ArrayList<>();
	// critList.add(newTotalCrit);
	// critList.add(newMenCrit);
	// critList.add(newWomenCrit);
	//
	// myCities = myCityDatabase.find(myCities, critList);
	// for (City city : myCities) {
	// System.out.println(city);
	// }
	//
	// }
}