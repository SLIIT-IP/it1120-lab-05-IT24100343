import java.util.Scanner;

public class  IT24100343Lab5Q3 {
    private static final int ROOM_CHARGE_PER_DAY = 48000;
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int DISCOUNT_3_TO_4_DAYS = 10;
    private static final int DISCOUNT_5_OR_MORE_DAYS = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start date (day) of the reservation: ");
        int startDate = scanner.nextInt();

        System.out.print("Enter the end date (day) of the reservation: ");
        int endDate = scanner.nextInt();

        scanner.close();

        if (startDate < MIN_DATE || startDate > MAX_DATE || endDate < MIN_DATE || endDate > MAX_DATE) {
            System.out.println("Error: Dates must be between " + MIN_DATE + " and " + MAX_DATE + ".");
            return; // Exit the program
        }

        if (startDate >= endDate) {
            System.out.println("Error: Start date must be earlier than end date.");
            return; // Exit the program
        }

        int numberOfDays = endDate - startDate;
        
        if (numberOfDays <= 3) {
            System.out.println("No discount applicable.");
            return; // Exit the program as no discount applies
        }

        int discountRate = 0;
        if (numberOfDays >= 3 && numberOfDays <= 4) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        } else if (numberOfDays >= 5) {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        }

        int totalAmountBeforeDiscount = numberOfDays * ROOM_CHARGE_PER_DAY;
        
        double discountAmount = (totalAmountBeforeDiscount * discountRate) / 100.0;
        double totalAmountToBePaid = totalAmountBeforeDiscount - discountAmount;

        System.out.println("Number of days reserved: " + numberOfDays);
        System.out.println("Discount rate: " + discountRate + "%");
        System.out.println("Total amount to be paid: Rs " + totalAmountToBePaid);
    }
}