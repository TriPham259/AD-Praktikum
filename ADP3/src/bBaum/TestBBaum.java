package bBaum;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
* Testklasse für die BBaum-Implementierung.
*/
public class TestBBaum {

  /**
   * Mit dieser Instanz wird getestet.
   */
  // TODO: Legen Sie hier eine Instanz Ihrer Implementierung an.
  private BBaum<Integer, String> baum = new BBaum<Integer, String>(2);

  @Test
  public void testEinfuegen() {
      baum.empty();
      baum.insert(23, "23");

      System.out.println(baum);
      baum.insert(42, "42");
      System.out.println(baum);
      baum.insert(12, "12");
      System.out.println(baum);
      baum.insert(25, "25");
      System.out.println(baum);
      baum.insert(20, "20");
      System.out.println(baum);
      baum.insert(11, "11");
      System.out.println(baum);
      baum.insert(24, "24");
      System.out.println(baum);
      assertTrue(baum.validate());
      assertEquals(7, baum.numOfKeys());
      List<KeyValuePair<Integer, String>> preOrderElemente = baum.printPreOrder();
      assertEquals(7, preOrderElemente.size());
      for (int i = 0; i < preOrderElemente.size() - 1; i++) {
          assertTrue(preOrderElemente.get(i).getKey().
                  compareTo(preOrderElemente.get(i + 1).getKey()) <= 0);
      }
  }

  @Test
  /**
   * Testet das Finden von Elementen im Baum.
   */
  public void testFinden() {
      baum.empty();
      baum.insert(23, "23");
      baum.insert(42, "42");
      baum.insert(12, "12");
      baum.insert(25, "25");
      baum.insert(20, "20");
      baum.insert(11, "11");
      baum.insert(24, "24");

      assertEquals("23", baum.getValFromKey(23));
      assertEquals("25", baum.getValFromKey(25));
      assertEquals("42", baum.getValFromKey(42));
      assertEquals(null, baum.getValFromKey(1));
      assertEquals(null, baum.getValFromKey(100));
      assertEquals(null, baum.getValFromKey(26));
  }
}

