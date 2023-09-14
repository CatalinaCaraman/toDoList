package org.example;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
public class Task {
    private int id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String projectName;

    public Task(int id, String title, LocalDate dueDate, String status, String projectName) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.projectName = projectName;
    }

    public static Task buildTask(int id, String title, LocalDate dueDate, String status, String projectName) {
        return new Task(id, title, dueDate, status, projectName);
    }

    public Task() {
        // Empty constructor
    }

    // Getters and setters

    //setter for ID
    public void setId(int id) {
        this.id = id;
    }

    //setter for Title
    public void setTitle(String title) {
        this.title = title;
    }

    //setter for DueDate
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //setter for Status
    public void setStatus(String status) {
        this.status = status;
    }

    //setter for ProjectName
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // Input validation methods

    // Validate and set ID
    public void enterId() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter ID of the task: ");
                int id = Integer.parseInt(scanner.nextLine());
                setId(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please enter a valid integer.");
            }
        }
    }

    // Validate and set Title
    public void enterTitle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter title of the task: ");
            String input = scanner.nextLine();
            if (input.length() >= 3 && input.length() <= 50) {
                setTitle(input);
                break;
            } else {
                System.out.println("Invalid title length. Title must be between 3 and 50 characters.");
            }
        }
    }

    // Validate and set DueDate
    public void enterDueDate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Due Date (yyyy-MM-dd): ");
            String input = scanner.nextLine();

            try {
                LocalDate newDueDate = LocalDate.parse(input);
                setDueDate(newDueDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in yyyy-MM-dd format.");
            }
        }
    }

    // Validate and set Status
    public void enterStatus() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter status of the task: ");
            String input = scanner.nextLine();
            if (input.matches("^[a-zA-Z ]+$")) {
                setStatus(input);
                break;
            } else {
                System.out.println("Invalid status. Status must contain only letters and spaces.");
            }
        }
    }

    // Validate and set ProjectName
    public void enterProjectName() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter project name: ");
            String input = scanner.nextLine();
            if (input.length() >= 3 && input.length() <= 50) {
                setProjectName(input);
                break;
            } else {
                System.out.println("Invalid length of the project name. It must be between 3 and 50 characters.");
            }
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Task newTask = new Task();
        newTask.enterStatus();
        newTask.enterProjectName();
        newTask.enterDueDate();
        newTask.enterTitle();
        System.out.println(newTask);
    }
}
