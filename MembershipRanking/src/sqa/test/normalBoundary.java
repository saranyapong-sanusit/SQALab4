package sqa.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

public class normalBoundary {

	@ParameterizedTest
	@CsvSource({
			"1, 15, 500,Standard", "2, 15, 500,Standard", "50000, 15, 500,Gold", "99999, 15, 500,Gold",
			"100000, 15, 500,Gold", "50000,1,500,Standard", "50000,2,500,Silver", "50000,30,500,Gold", "50000,31,500,Gold",
			"50000,15,1,Standard", "50000,15,2,Standard", "50000,15,999,Gold", "50000,15,1000,Gold" })
	void normalBoundaryTesting(int purchaseTotal, int frequency, int pointCollected, String expectedRank) {
		Ranking rank = new Ranking();
		String actualRank = rank.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expectedRank, actualRank);
	}
}