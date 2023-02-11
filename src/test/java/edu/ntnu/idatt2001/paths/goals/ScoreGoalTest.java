package edu.ntnu.idatt2001.paths.goals;

import edu.ntnu.idatt2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class tests the ScoreGoal class.
 *
 * @author ...
 * @version JDK 17
 */
class ScoreGoalTest {

  ScoreGoal scoreGoal;

  @BeforeEach
  void setUp() {
    scoreGoal = new ScoreGoal(50);
  }

  @Test
  @DisplayName("Test constructor valid input")
  void testConstructorValidInput() {
    int minimumPoints = 80;
    ScoreGoal testScoreGoalConstructor = new ScoreGoal(minimumPoints);
    assertEquals(minimumPoints, testScoreGoalConstructor.getMinimumPoints());
  }

  @Test
  @DisplayName("Test constructor invalid input throws IllegalArgumentException")
  void testConstructorInvalidInputThrowsIllegalArgumentException() {
    int invalidMinimumPoints = -80;
    assertThrows(IllegalArgumentException.class, () -> new ScoreGoal(invalidMinimumPoints));
  }

  @Test
  @DisplayName("Goal is fulfilled")
  void goalIsFulfilled() {
    Player player = new Player("Test name", 100, 60, 50);
    assertTrue(scoreGoal.isFulfilled(player));
  }

  @Test
  @DisplayName("Goal is not fulfilled")
  void goalIsNotFulfilled() {
    Player player = new Player("Test name", 100, 40, 50);
    assertFalse(scoreGoal.isFulfilled(player));
  }

  @Test
  @DisplayName("Goal is not fulfilled throws NullPointerException")
  void goalIsNotFulfilledThrowsNullPointerException() {
    Player player = null;
    assertThrows(NullPointerException.class, () -> scoreGoal.isFulfilled(player));
  }
}