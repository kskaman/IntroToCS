public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        dna = dna.toUpperCase();
        int count = 0;
        int maxCount = 0;
        int n = dna.length();
        int i = 0;
        while (i < n - 2) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                count++;
                i = i + 3;
                if (maxCount < count)
                    maxCount = count;

            } else {

                count = 0;
                i = i + 1;
            }
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String s3 = s.replace("\t", "");
        String s4 = s3.replace(" ", "");
        String s2 = s4.replace("\n", "");
        return s2;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String str = "";
        if (maxRepeats < 10 || maxRepeats > 180)
            str = "not human";
        else if (maxRepeats < 36)
            str = "normal";
        else if (maxRepeats < 40)
            str = "high risk";
        else
            str = "Huntington's";
        return str;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String fileContent = in.readAll();
        String content = removeWhitespace(fileContent);
        int maxRepeats = maxRepeats(content);
        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }
}
