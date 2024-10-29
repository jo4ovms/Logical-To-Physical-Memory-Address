import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the page size (in bytes): ");
        int pageSize = scanner.nextInt();

        System.out.println("Enter the number of pages: ");
        int numPages = scanner.nextInt();

        int[] pageTable = new int[numPages];
        System.out.println("Enter the corresponding frame for each page (-1 if it doesn't exist):");

        for (int i = 0; i < numPages; i++) {
            System.out.print("Page " + i + ": ");
            pageTable[i] = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.print("Enter the logical addresses to convert, separated by commas: ");
        String logicalAddressesStr = scanner.nextLine();
        String[] logicalAddressesArr = logicalAddressesStr.split(",");

        for (String addressStr : logicalAddressesArr) {
            int logicalAddress = Integer.parseInt(addressStr.trim());


            int logicalPage = logicalAddress / pageSize;
            int offset = logicalAddress % pageSize;


            if (logicalPage < numPages && pageTable[logicalPage] != -1) {
                int physicalFrame = pageTable[logicalPage];
                int physicalAddress = (physicalFrame * pageSize) + offset;
                System.out.println("Logical Address: " + logicalAddress +
                        " -> Page " + logicalPage + ", Frame " + physicalFrame +
                        ", Physical Address: " + physicalAddress);
            } else {
                System.out.println("Logical Address: " + logicalAddress +
                        " -> Page " + logicalPage + " not mapped (Generates an Interruption).");
            }
        }
        scanner.close();
    }
}
