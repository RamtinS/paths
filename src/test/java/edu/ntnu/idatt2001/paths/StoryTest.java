package edu.ntnu.idatt2001.paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class tests the Story class.
 *
 * @author ...
 * @version JDK 17
 */
class StoryTest {

  Story story;
  Passage passage;

  @BeforeEach
  void setUp() {
    passage = new Passage("Test title", "Test content");
    story = new Story("Test title", passage);
  }

  @Test
  @DisplayName("Test constructor valid input")
  void testConstructorValidInput() {
    Story testStoryConstructor = new Story("Test title", passage);
    assertEquals("Test title", testStoryConstructor.getTitle());
    assertEquals(passage, testStoryConstructor.getOpeningPassage());
  }

  @Test
  @DisplayName("Test constructor invalid input throws NullPointerException")
  void testConstructorInvalidInputThrowsNullPointerException() {
    String invalidTitle = null;
    Passage invalidPassage = null;
    String validTitle = "Test title";
    assertThrows(NullPointerException.class, () -> new Story(invalidTitle, passage));
    assertThrows(NullPointerException.class, () -> new Story(validTitle, invalidPassage));
  }

  @Test
  @DisplayName("Test constructor invalid input throws IllegalArgumentException")
  void testConstructorInvalidInputThrowsIllegalArgumentException() {
    String invalidTitle = "";
    assertThrows(IllegalArgumentException.class, () -> new Story(invalidTitle, passage));
  }

  @Test
  @DisplayName("Should get the title of the story.")
  void shouldGetTitle() {
    String expected = "Test title";
    String actual = story.getTitle();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Should get the opening passage of the story.")
  void shouldGetOpeningPassage() {
    Passage expectedPassage = passage;
    Passage actualPassage = story.getOpeningPassage();
    assertEquals(expectedPassage, actualPassage);
  }

  @Test
  @DisplayName("Should add passage")
  void shouldAddPassage() {
    story.addPassage(passage);
    assertFalse(story.getPassages().isEmpty());
  }

  @Test
  @DisplayName("Should not add passage")
  void shouldNotAddPassage() {
    Passage passage = null;
    assertThrows(NullPointerException.class, () -> story.addPassage(passage));
  }

  @Test
  @DisplayName("Should get passage")
  void shouldGetPassage() {
    story.addPassage(passage);
    Link link = new Link (passage.getTitle(), passage.getTitle());
    Passage expected = passage;
    Passage actual = story.getPassage(link);
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Should not get passage")
  void shouldNotGetPassage() {
    Link link = null;
    assertThrows(NullPointerException.class, () -> story.getPassage(link));
  }

  @Test
  @DisplayName("Should get passages")
  void shouldGetPassages() {
    story.addPassage(passage);
    List<Passage> expectedPassages = new ArrayList<>();
    expectedPassages.add(passage);
    assertTrue(expectedPassages.containsAll(story.getPassages()));
  }
}