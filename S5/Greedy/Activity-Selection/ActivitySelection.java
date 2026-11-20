import java.util.*;

class Activity {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {

    public static void selectActivities(List<Activity> activities) {

        // Sort activities by increasing finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected activities:");

        // Select the first activity
        Activity lastSelected = activities.get(0);

        System.out.println("Start: " + lastSelected.start
                + ", Finish: " + lastSelected.finish);

        // Check the remaining activities
        for (int i = 1; i < activities.size(); i++) {

            if (activities.get(i).start >= lastSelected.finish) {

                lastSelected = activities.get(i);

                System.out.println("Start: " + lastSelected.start
                        + ", Finish: " + lastSelected.finish);
            }
        }
    }

    public static void main(String[] args) {

        List<Activity> activities = Arrays.asList(
                new Activity(1, 2),
                new Activity(3, 4),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9),
                new Activity(5, 9)
        );

        selectActivities(activities);
    }
}
