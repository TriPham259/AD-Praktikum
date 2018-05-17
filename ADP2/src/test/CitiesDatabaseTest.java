package test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import citiesDatabase.CitiesDatabase;
import model.City;
import model.Col;
import model.Criterion;

public class CitiesDatabaseTest {
	private CitiesDatabase cdb;
	
	private List<City> cl0;
	private List<City> cl1;
	private List<City> cl2;
	private List<City> cl3;
	
	private City berlinCity; 
	private City hamburgCity;
	private City arnisCity;
	private City leipzigCity;
	private City jeverCity;
	private City schneebergCity;
	
	private Criterion totalCrit;
	private Criterion menCrit;
	private Criterion womenCrit0;
	private Criterion womenCrit1;
	private List<Criterion> critList0;
	private List<Criterion> critList1;
	
	@Before
	public void init() throws FileNotFoundException {
		cdb = new CitiesDatabase("StaedteStatistik.csv");
		
		cl0 = cdb.load(0);
		cl1 = cdb.load(1);
		cl2 = cdb.load(15);
		cl3 = cdb.load(2058);
		
		berlinCity = new City("Berlin", "Stadt", 10178, 891.12, 3574830, 1755700, 1819130);
		hamburgCity = new City("Hamburg", "Freie und Hansestadt", 20038, 755.30, 1810438, 886289, 924149);
		arnisCity = new City("Arnis", "Stadt", 24399, 0.45, 275, 143, 132); 
		leipzigCity = new City("Leipzig", "Stadt", 4109, 297.80, 571088, 280292, 290796);
		jeverCity = new City("Jever", "Stadt", 26441, 42.23, 14201, 6767, 7434);
		schneebergCity = new City("Schneeberg", "Stadt", 8289, 23.35, 14193, 6907, 7286);
		
		totalCrit = new Criterion(Col.TOTAL, 14000, 15000);
		menCrit = new Criterion(Col.WOMEN, 5000, 8000);
		womenCrit0 = new Criterion(Col.MEN, 5000, 7000);
		womenCrit1 = new Criterion(Col.MEN, 5000, 6000);
		critList0 = new ArrayList<>(Arrays.asList(totalCrit, menCrit, womenCrit0));
		critList1 = new ArrayList<>(Arrays.asList(totalCrit, menCrit, womenCrit1));
	}

	@Test
	public void loadTest() {
		assertEquals(0, cl0.size());
		
		assertEquals(1, cl1.size());
		assertEquals(berlinCity, cl1.get(0));

		assertEquals(15, cl2.size());
		assertEquals(hamburgCity, cl2.get(1));

		assertEquals(2058, cl3.size());
		assertEquals(arnisCity, cl3.get(2057));
		assertTrue(cl3.contains(leipzigCity));
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void loadNegCitesNum() {
		cl0 = cdb.load(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void loadGreaterThanSizeCitiesNum() {
		cl0 = cdb.load(cdb.getCities().size() + 1);
	}

	@Test()
	public void findTest() {
//		City {name = Bitburg, type = Stadt, plz = 54634, area = 47.55, total = 14540, men = 6995, women = 7545}
//		City {name = Ratzeburg, type = Stadt, plz = 23909, area = 30.29, total = 14528, men = 6862, women = 7666}
//		City {name = Immenstadt i.Allgäu, type = St, plz = 87509, area = 81.43, total = 14207, men = 6921, women = 7286}
//		City {name = Gernsbach, type = Stadt, plz = 76593, area = 82.03, total = 14202, men = 6984, women = 7218}
//		City {name = Jever, type = Stadt, plz = 26441, area = 42.23, total = 14201, men = 6767, women = 7434}
//		City {name = Schneeberg, type = Stadt, plz = 08289, area = 23.35, total = 14193, men = 6907, women = 7286}
//		City {name = Bad Camberg, type = Stadt, plz = 65520, area = 54.63, total = 14148, men = 6979, women = 7169}
//		City {name = Bad Bramstedt, type = Stadt, plz = 24576, area = 24.14, total = 14139, men = 6965, women = 7174}
//		City {name = Lauterbach (Hessen), type = Kreisstadt, plz = 36341, area = 102.00, total = 14110, men = 6988, women = 7122}
//		City {name = Plochingen, type = Stadt, plz = 73207, area = 10.64, total = 14086, men = 6950, women = 7136}
//		City {name = Wilsdruff, type = Stadt, plz = 01723, area = 81.60, total = 14004, men = 6929, women = 7075}
		cl3 = cdb.find(cl3, critList0);
		assertEquals(11, cl3.size());
		assertTrue(cl3.contains(jeverCity));
		assertTrue(cl3.contains(schneebergCity));
		assertFalse(cl3.contains(berlinCity));
		assertFalse(cl3.contains(leipzigCity));
		
		cl3 = cdb.find(cl3, critList1);
		assertEquals(0, cl3.size());
	}

}