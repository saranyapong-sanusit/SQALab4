package sqa.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

public class normalBoundary {

	@ParameterizedTest
	@CsvSource({
			"0, 4, 500,Standard", "1, 4, 500,Standard", "50000, 4, 500,Gold", "99999, 4, 500,Gold",
			"100000, 4, 500,Gold", "50000,0,500,Standard", "50000,1,500,Silver", "50000,6,500,Gold", "50000,7,500,Gold",
			"50000,4,0,Standard", "50000,4,1,Standard", "50000,4,999,Gold", "50000,4,1000,Gold" })
	void testNormal(int purchaseTotal, int frequency, int pointCollected, String expectedRank) {
		Ranking rank = new Ranking();
		String actualRank = rank.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expectedRank, actualRank);
	}
}