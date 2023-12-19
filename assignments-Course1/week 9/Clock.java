public class Clock {
    private int hour = 0;
    private int minutes = 0;

    // Creates a clock whose initial time is h hours and m minutes
    public Clock(int h, int m) {
        if (h < 0 || h >= 24 || m < 0 || m >= 60) {
            throw new IllegalArgumentException("Arguments out of range");
        }
        hour = h;
        minutes = m;

    }

    // Creates a clock whose whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        int n = s.length();
        if (n != 5)
            throw new IllegalArgumentException("");
        for (int i = 0; i < n; i++) {
            if (i == 2) {
                if (!s.substring(i, i + 1).equals(":"))
                    throw new IllegalArgumentException("Illegal arguments");
            } else {
                try {
                    Integer.parseInt(s.substring(i, i + 1));

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("");
                }
            }
        }
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h >= 24 || m < 0 || m >= 60) {
            throw new IllegalArgumentException("");
        }
        hour = h;
        minutes = m;

    }


    // Returns a string representation of this clock, using the format HH:MM
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour)
            return true;
        else if (hour == that.hour) {
            if (minutes < that.minutes)
                return true;
            else
                return false;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes++;
        if (minutes >= 60) {
            minutes = 0;
            hour++;

            if (hour >= 24)
                hour = 0;
        }
    }

    // Adds delta minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Negative increment");
        else {
            int addHour = delta / 60;
            int addMinutes = delta % 60;
            hour += addHour;
            minutes += addMinutes;
            if (minutes >= 60) {
                minutes = minutes % 60;
                hour++;
            }
            if (hour >= 24) {
                hour = hour % 24;
            }

        }
    }

    // Test client.
    public static void main(String[] args) {
        Clock time1 = new Clock(20, 26);
        Clock time2 = new Clock("08:34");
        StdOut.println(time1.toString());
        time1.tic();
        time1.toc(98);
        time1.toc(120);
        StdOut.println(time1.toString());
        StdOut.println(time2.toString());
    }
}
