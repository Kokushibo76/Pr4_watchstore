import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] watchCompanies = {"Casio", "Seiko", "Rolex"};
        String[][] watchBrands = {{"G-Shock", "Edifice"}, {"Prospex", "Presage"}, {"Submariner", "Datejust"}};

        ArrayList<Customer> customersList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        Scanner console = new Scanner(System.in);

        int numberOfCustomers = getNumberOfCustomers(console);

        if (numberOfCustomers < 3) {
            System.out.println("Минимальное количество заказчиков должно быть не менее 3.");
        } else {
            for (int i = 0; i < numberOfCustomers; i++) {
                Customer customer = getCustomerInfo(console, watchCompanies, watchBrands);
                customersList.add(customer);
            }
        }

        displayCustomerOrders(customersList);
    }

    static int getNumberOfCustomers(Scanner scanner) {
        System.out.print("Введите количество заказчиков: ");
        return scanner.nextInt();
    }

    static Customer getCustomerInfo(Scanner scanner, String[] watchCompanies, String[][] watchBrands) {
        System.out.println("-----------------------------------" );
        System.out.println("Введите информацию о заказчике" );
        System.out.print("ФИО: ");
        String fullName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Номер телефона: ");
        String phoneNumber = scanner.nextLine();

        displayAvailableProducts(watchCompanies, watchBrands);

        System.out.print("Бренд: ");
        int position = scanner.nextInt();
        System.out.print("Марка: ");
        int quantity = scanner.nextInt();

        scanner.nextLine();

        return new Customer(fullName, email, phoneNumber, watchCompanies[position - 1], watchBrands[position - 1][0], quantity);
    }

    static void displayAvailableProducts(String[] watchCompanies, String[][] watchBrands) {
        System.out.println("Список доступных товаров:");
        for (int j = 0; j < watchCompanies.length; j++) {
            for (int k = 0; k < watchBrands[j].length; k++) {
                System.out.println((j + 1) + ". " + watchCompanies[j] + " - " + watchBrands[j][k]);
            }
        }
    }

    static void displayCustomerOrders(ArrayList<Customer> customersList) {
        System.out.println("-----------------------------------" );
        System.out.println("Информация о заказах:");
        for (Customer customer : customersList) {
            System.out.println("Имя покупателя: " + customer.getFullName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Номер телефона: " + customer.getPhoneNumber());
            System.out.println("Бренд: " + customer.getCompany() + " - " + customer.getBrand());
            System.out.println("Марка: " + customer.getQuantity());
            System.out.println();
        }
    }

    static class Customer {
        private String fullName;
        private String email;
        private String phoneNumber;
        private String company;
        private String brand;
        private int quantity;
        public Customer(String fullName, String email, String phoneNumber, String company, String brand, int quantity) {
            this.fullName = fullName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.company = company;
            this.brand = brand;
            this.quantity = quantity;
        }
        public String getFullName() {
            return fullName;
        }
        public String getEmail() {
            return email;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public String getCompany() {
            return company;
        }
        public String getBrand() {
            return brand;
        }
        public int getQuantity() {
            return quantity;
        }
    }
}