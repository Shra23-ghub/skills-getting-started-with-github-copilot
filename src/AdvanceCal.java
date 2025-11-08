import java.util.Scanner;

public class AdvanceCal {
    private static final double PI = Math.PI;
    
    public double calculateRectangleArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            return -1; // Return -1 to indicate invalid dimensions
        }
        return length * width;
    }
    
    public double calculateCircleArea(double radius) {
        if (radius <= 0) {
            return -1; // Return -1 to indicate invalid radius
        }
        return PI * radius * radius;
    }

    public double calculateTriangleArea(double side1, double side2, double side3) {
        // First check if the triangle is valid
        if (!isValidTriangle(side1, side2, side3)) {
            return -1; // Return -1 to indicate invalid triangle
        }
        
        // Calculate semi-perimeter
        double s = (side1 + side2 + side3) / 2;
        
        // Calculate area using Heron's formula
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        
        return area;
    }
    
    private boolean isValidTriangle(double a, double b, double c) {
        // Check triangle inequality theorem
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdvanceCal calculator = new AdvanceCal();
        
        System.out.println("Choose the shape to calculate area:");
        System.out.println("1. Triangle");
        System.out.println("2. Circle");
        System.out.println("3. Rectangle");
        System.out.print("Enter your choice (1, 2, or 3): ");
        
        int choice = scanner.nextInt();
        double area;
        
        switch (choice) {
            case 1:
                System.out.println("\nEnter the three sides of the triangle:");
                System.out.print("Side 1: ");
                double side1 = scanner.nextDouble();
                System.out.print("Side 2: ");
                double side2 = scanner.nextDouble();
                System.out.print("Side 3: ");
                double side3 = scanner.nextDouble();
                
                area = calculator.calculateTriangleArea(side1, side2, side3);
                if (area == -1) {
                    System.out.println("Invalid triangle! These side lengths cannot form a triangle.");
                } else {
                    System.out.printf("The area of the triangle is: %.2f square units%n", area);
                }
                break;
                
            case 2:
                System.out.print("\nEnter the radius of the circle: ");
                double radius = scanner.nextDouble();
                
                area = calculator.calculateCircleArea(radius);
                if (area == -1) {
                    System.out.println("Invalid circle! Radius must be greater than 0.");
                } else {
                    System.out.printf("The area of the circle is: %.2f square units%n", area);
                }
                break;
                
            case 3:
                System.out.print("\nEnter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = scanner.nextDouble();
                
                area = calculator.calculateRectangleArea(length, width);
                if (area == -1) {
                    System.out.println("Invalid rectangle! Both length and width must be greater than 0.");
                } else {
                    System.out.printf("The area of the rectangle is: %.2f square units%n", area);
                }
                break;
                
            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }
        
        scanner.close();
    }
}