import java.util.Scanner;

public class daysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month;
        int year;

        while (true) {
            System.out.print("Enter the month (1-12 or name/abbreviation): ");
            String monthInput = scanner.nextLine();

            month = getMonthValue(monthInput);

            if (month != -1) {
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter the year: ");
            String yearInput = scanner.nextLine();

            if (isValidYear(yearInput)) {
                year = Integer.parseInt(yearInput);
                break;
            } else {
                System.out.println("Invalid year. Please try again.");
            }
        }

        int numDays = getNumberOfDays(month, year);
        System.out.println("Number of days: " + numDays);
    }

    private static int getMonthValue(String monthInput) {
        monthInput = monthInput.toLowerCase();

        switch (monthInput) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun.":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul.":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sep.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return -1;
        }
    }

    private static boolean isValidYear(String yearInput) {
        try {
            int year = Integer.parseInt(yearInput);
            return year >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getNumberOfDays(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}