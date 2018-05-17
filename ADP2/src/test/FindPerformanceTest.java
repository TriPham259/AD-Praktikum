package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import citiesDatabase.CitiesDatabase;
import model.City;
import model.Col;
import model.Criterion;

/**
 * Test find() performance with different number of cities.
 * Run find() 100 times for each number of cities and get the average time.
 * @author tripham
 *
 */

public class FindPerformanceTest {
	public static void main(String[] args) throws FileNotFoundException {
		CitiesDatabase cdb = new CitiesDatabase("StaedteStatistik.csv");
		int cdbSize = cdb.getCities().size();

		Criterion totalCrit = new Criterion(Col.TOTAL, 14000, 15000);
		Criterion menCrit = new Criterion(Col.WOMEN, 5000, 8000);
		Criterion womenCrit = new Criterion(Col.MEN, 5000, 7000);
		List<Criterion> critList = new ArrayList<>(Arrays.asList(totalCrit, menCrit, womenCrit));

		List<City> cl;

		long startTime;
		long endTime;
		long totalTime = 0;
		long averageTime;

		for (int i = 1; i <= cdbSize; i++) {
			cl = cdb.load(i);

			for (int j = 0; j < 100; j++) {
				startTime = System.nanoTime();
				cdb.find(cl, critList);
				endTime = System.nanoTime();
				totalTime += endTime - startTime;
			}
			averageTime = totalTime / 100;

			System.out.println("Search within " + i + " cities: " + averageTime + " ns.");
			totalTime = 0;
		}
	}
}