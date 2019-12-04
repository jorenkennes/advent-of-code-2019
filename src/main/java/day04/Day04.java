package day04;

public class Day04 {


    public static void main(String[] args) {
        Day04 day04 = new Day04();
        int numberOfPossiblePassword = day04.findNumberOfPossiblePassword(264793, 803935);
        System.out.println(numberOfPossiblePassword);
    }

    public int findNumberOfPossiblePassword(int startRange, int endRange) {
        int count = 0;
        for (int i = startRange; i <= endRange; i++) {
            if (isNoDecreasingPasscode("" + i)) {
                if (strictlyTwoAdjacentMatchingNumbers("" + i)) {
                    count++;
                    System.out.println("-->>" + i);
                }
            }
        }
        return count;
    }

    private boolean isNoDecreasingPasscode(String passcode) {
        for (int i = 1; i < passcode.length(); i++) {
            if (passcode.charAt(i) < passcode.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean twoAdjacentMatchingNumbers(String passcode) {
        for (int i = 1; i < passcode.length(); i++) {
            if (passcode.charAt(i) == passcode.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean strictlyTwoAdjacentMatchingNumbers(String passcode) {
        StringBuilder doubles = new StringBuilder();
        for (int i = 1; i < passcode.length(); i++) {
            if (passcode.charAt(i) == passcode.charAt(i - 1)) {
                System.out.println(passcode);
                doubles.append(passcode.charAt(i));
            }
        }
        String d = doubles.toString();
        return findNonDouble(d);
    }

    private boolean findNonDouble(String d) {
        for (int i = 1; i < d.length(); i++) {
            if (d.charAt(i) != d.charAt(i - 1)) {
                if (i == d.length() - 1 || i == 1) {
                    //last element
                    System.out.println(d.charAt(i));
                    return true;
                } else if (d.charAt(i) != d.charAt(i + 1)) {
                    System.out.println(d.charAt(i));
                    return true;
                }
            }
        }
        return d.length() == 1;
    }
}

