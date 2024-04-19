import java.util.Scanner;

class ATM extends BankAccount {

    ATM(String accountNo) {
        super(accountNo);
    }

    public void deposit(int amount){
        this.Balance = amount;
    }

    public void withdraw(int amount){
        if(Balance==0 || amount>Balance){
            System.out.println("Insufficient Balance");
        }
        else{
            Balance = (Balance - amount);
            System.out.println("Withdraw Successfully!");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);

        String userAccountNo = "";
        int n;

        ATM user = new ATM(userAccountNo);


        System.out.printf("WELCOME TO ATM MACHINE!!\n");
        System.out.println();

        do{
            System.out.println("What do you want to do? Choose from Options Below!");

            System.out.println("------------------------------------------------------");
            System.out.println("1.CHECK BALANCE");
            System.out.println("2.WITHDRAW MONEY");
            System.out.println("3.DEPOSIT MONEY");
            System.out.println("4.EXIT");
            System.out.println("------------------------------------------------------");

            System.out.print("Enter your Option:");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter Account Number:");
                    userAccountNo = sc.next();
                    user.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount you want to Withdraw:");
                    int amount = sc.nextInt();
                    user.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter the amount you want to Deposit:");
                    int money = sc.nextInt();
                    user.deposit(money);
                    System.out.println("Deposited Successfully!");
                    break;
                case 4:
                    System.out.println("Thank you!! Have a nice Day!");
                    break;
                default:
                    System.out.println("Please Choose the correct Option!!");
            }

        }while(n!=4);

        sc.close();
    }
}