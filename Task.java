package cs3500.pa05.model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Represents a Task
 */
public class Task {
  private String name;
  private String description;
  private DayType dayOfWeek;
  private boolean complete;

  /**
   * Instantiates a Task
   *
   * @param name        name
   * @param description description
   * @param dayOfWeek   weekday
   * @param complete    completion status
   */
  public Task(String name, String description, DayType dayOfWeek, boolean complete) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.complete = complete;
  }

  /**
   * Gets name
   *
   * @return name
   */
  public String nameProperty() {
    return name;
  }

  /**
   * Gets description
   *
   * @return description
   */
  public String descriptionProperty() {
    return description;
  }

  /**
   * Gets day of week
   *
   * @return day
   */
  public DayType dayOfWeekProperty() {
    return dayOfWeek;
  }

  /**
   * Gets completion
   *
   * @return completion
   */
  public boolean completeProperty() {
    return complete;
  }

  /**
   * Sets this task to the given completion
   *
   * @param complete completion status
   */
  public void setIsComplete(Boolean complete) {
    this.complete = complete;
  }

  /**
   * Returns a string format of a task
   *
   * @return string format of this task
   */
  public String taskToString() {
    if (description.isEmpty()) {
      return "Task: " + name
          + "\nDay: " + dayOfWeek.getDay()
          + "\nComplete: " + complete;
    } else {
      return "Task: " + name
          + "\nDay: " + dayOfWeek.getDay()
          + "\nDescription: " + description
          + "\nComplete: " + complete;
    }
  }

  /**
   * Determines if the url is valid
   *
   * @param possiblyUrl the url
   * @return true if it is valid
   */
  public boolean isUrlTask(String possiblyUrl) {
    URL url;
    try {
      url = new URL(possiblyUrl);
      return true;
    } catch (MalformedURLException e) {
      return false;
    }
  }


}
