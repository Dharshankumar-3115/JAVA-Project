import java.util.ArrayList;
import java.util.Scanner;
class Product
{
    private int id;
    private String name;
    private int quantity;
    public Product(int id, String name, int quantity)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void displayProduct()
    {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}
class GodownManagementSystem
{
    private static ArrayList<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int productIdCounter = 1;
    public static void main(String[] args)
    {
        int choice;
        do
	{
            System.out.println("\n--- Warehouse Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();
            switch (choice)
	    {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }while (choice != 4);
    }
    private static void addProduct()
    {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = getIntInput();
        Product product = new Product(productIdCounter++, name, quantity);
        productList.add(product);
        System.out.println("Product added successfully.");
    }
    private static void viewProducts()
    {
        if (productList.isEmpty())
	{
            System.out.println("No products available.");
        } 
	else 
	{
            System.out.println("\n--- Product List ---");
            for (Product product : productList) 
	    {
                product.displayProduct();
            }
        }
    }
    private static void deleteProduct() 
    {
        System.out.print("Enter product ID to delete: ");
        int id = getIntInput();
        boolean removed = productList.removeIf(product -> product.getId() == id);
        if (removed) 
	{
            System.out.println("Product deleted successfully.");
        } 
	else 
	{
            System.out.println("Product with ID " + id + " not found.");
        }
    }
    private static int getIntInput() 
    {
        while (true) 
	{
            try 
	    {
                int input = Integer.parseInt(scanner.nextLine());
                if (input < 0) 
		{
                    System.out.print("Please enter a non-negative number: ");
                    continue;
                }
                return input;
            } 
	    catch (NumberFormatException e) 
	    {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
