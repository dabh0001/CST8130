
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class Library {

    private ArrayList<Resource> resourcesBorrowed;

    public Library() {
        resourcesBorrowed = new ArrayList<>();
    }

    public void inputResource(Scanner in, MyDate myDate) throws ParseException {
        String resouceType = "";
        boolean isValidResourceType = false;
        do {
            System.out.println("Enter type of resource being borrowed - D for DVD, M for Magazine and B for book: ");
            resouceType = in.next();
            Resource resource = null;
            if (resouceType.equalsIgnoreCase("B")) {
                resource = new Book();
                isValidResourceType = true;
            } else if (resouceType.equalsIgnoreCase("D")) {
                resource = new DVD();
                isValidResourceType = true;
            } else if (resouceType.equalsIgnoreCase("M")) {
                resource = new Magazine();
                isValidResourceType = true;
            }
            if (isValidResourceType) {
                resource.inputResource(in, myDate, true);
                int index = findIndexToInsert(resource);
                resourcesBorrowed.add(index, resource);
            }
        } while (!isValidResourceType);
    }

    public int findIndexToInsert(Resource resource) {
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            Resource currentResource = resourcesBorrowed.get(i);
            if (currentResource.title.compareTo(resource.title) > 0) {
                return i;
            }
        }
        return resourcesBorrowed.size();
    }

    public String toString() {
        System.out.println("Items currently borrowed from library are:");
        if (resourcesBorrowed.size() == 0) {
            System.out.println("No entries underneath");
            return "";
        }
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            System.out.println((i + 1) + ":  " + resourcesBorrowed.get(i).toString());
        }
        return "";
    }

    public String resourcesOverDue(MyDate today) throws ParseException {
        System.out.println("Items currently borrowed from library that are overdue as of  " + today + " are:");
        if (resourcesBorrowed.size() == 0) {
            System.out.println("No entries underneath");
            return "";
        }
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            Resource resource = resourcesBorrowed.get(i);
            if (resource.isOverDue(today)) {
                System.out.println((i + 1) + ":  " + resource.toString());
            }
        }
        return "";
    }

    public void deleteResource(Scanner in, MyDate todayDate) throws ParseException {
        int resourceNum = 0;
        if (resourcesBorrowed.isEmpty()) {
            System.out.println("No resources to delete");
            return;
        }
        System.out.println("List of resources checked out in the library: ");
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            System.out.println("[" + (i + 1) + "]:  " + resourcesBorrowed.get(i).toString());
        }

        do {
            System.out.println("Which resource to delete: ");
            if (in.hasNextInt()) {
                resourceNum = in.nextInt();
            } else {
                System.out.println("Invalid resource number. Prompted to re-enter");
            }
        } while (resourceNum <= 0 || resourceNum > resourcesBorrowed.size());

        //check if overdue present or not
        Resource resource = resourcesBorrowed.get(resourceNum - 1);
        if (resource.isOverDue(todayDate)) {
            System.out.println("This resource is overdue - $" + resource.overdueCost + " is owed by borrower. Item is not deleted.");
        }
        resourcesBorrowed.remove(resourceNum - 1);

        System.out.println("Item is deleted.");
    }

    /**
     * view a specific resource
     *
     * @param input
     */
    public void viewResource(Scanner input) {
        if (resourcesBorrowed.isEmpty()) {
            System.out.println("No resources to view");
            return;
        }
        System.out.println("Enter the title to search for: ");
        String resouceTitle = input.next();
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            if (resourcesBorrowed.get(i).isSameTitle(resouceTitle)) {
                System.out.println(resourcesBorrowed.get(i).toString());
                return;
            }
        }
        System.out.println("Resource with this title is not found");

    }

    public void readResourceFile(Scanner input, MyDate myDate) throws ParseException {
        String resouceType = "";
        boolean isValidResourceType = false;
        System.out.println("Enter name of file to process: ");
        String fName = input.next();
        try {
            File file = new File(fName);
            if (file.exists()) {
                input = new Scanner(file);
                while (input.hasNext()) {
                    resouceType = input.next();
                    Resource resource = null;
                    if (resouceType.equalsIgnoreCase("B")) {
                        resource = new Book();
                        isValidResourceType = true;
                    } else if (resouceType.equalsIgnoreCase("D")) {
                        resource = new DVD();
                        isValidResourceType = true;
                    } else if (resouceType.equalsIgnoreCase("M")) {
                        resource = new Magazine();
                        isValidResourceType = true;
                    }
                    if (isValidResourceType) {
                        resource.inputResource(input, myDate, false);
                        int index = findIndexToInsert(resource);
                        resourcesBorrowed.add(index, resource);
                    }
                }
            } else {
                System.out.println("File does not exist");
            }

        } catch (IOException e) {
            System.out.println("Could not open file..." + fName + "exiting");
        }
    }

    /**
     * Save the current resources to a file
     *
     * @param input
     */
    void saveResourceFile(Scanner input) {
        String str = "";
        for (int i = 0; i < resourcesBorrowed.size(); i++) {
            str += resourcesBorrowed.get(i).saveToString() + "\n";
        }

        try {
            System.out.println("Enter name of file to write to: ");
            Formatter x = new Formatter(input.next());
            x.format("%s", str);
            x.close();
        } catch (Exception e) {
            System.out.println("you have an error");
        }

    }

}
