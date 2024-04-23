public class Menu {
    public static void main(String[] args) {
        System.out.println("Menu");
        while(true){
            System.out.println("1. Make a deposit");
            System.out.println("2. Make a withdrawal");
            System.out.println("3. Take out a loan");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(System.console().readLine());
            if(choice == 5){
                break;
            }
            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
