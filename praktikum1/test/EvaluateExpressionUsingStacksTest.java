package ad.praktikum1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ad.praktikum1.EvaluateExpressionUsingStacks;

class EvaluateExpressionUsingStacksTest {

	@Test
	void test() {
		assertEquals(72, EvaluateExpressionUsingStacks.evaluate("10 + 2 * 6"));
		assertEquals(212, EvaluateExpressionUsingStacks.evaluate("100 * 2 + 12"));
		assertEquals(1400, EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 )"));
		assertEquals(100, EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 ) / 14"));
	}

}
