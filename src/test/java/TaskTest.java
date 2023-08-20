import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // Тесты SimpleTask
    @Test
    public void simpleTaskMatchesShouldBeTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");

        Assertions.assertTrue(actual);

    }

    @Test
    public void simpleTaskMatchesShouldBeFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("друзьям");

        Assertions.assertFalse(actual);

    }

    // Тесты Meeting
    @Test
    public void meetingMatchesTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");

        Assertions.assertTrue(actual);

    }

    @Test
    public void meetingMatchesProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertTrue(actual);

    }

    @Test
    public void meetingMatchesFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Релиз");

        Assertions.assertFalse(actual);

    }

    // Тесты Epic
    @Test
    public void epicMatchesTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);

    }

    @Test
    public void epicMatchesFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Мясо");

        Assertions.assertFalse(actual);

    }

}