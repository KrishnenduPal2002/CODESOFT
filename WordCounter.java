import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WordCounter {

    public static void countWord(String word){
        int count = 0;
        for(int i=0;i<word.length();i++){
            count++;
        }
        System.out.println("No of Words present inside the string is = "+count);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("WELCOME TO A SIMPLE WORD COUNTER");

        do{
            System.out.println("------------------------------------------------------------");
            System.out.printf("1.Take Input as a File:\n2.User input Text:\n3.Exit:\n");
            System.out.println("------------------------------------------------------------");
            System.out.print("Enter the Choice:");

            n = sc.nextInt();

            switch(n){
                case 1:
                    sc.nextLine(); // Here we have use this to skip the escape sequence present inside the buffer after using the nextInt function (i.e. \n)

                    System.out.print("Enter any File name (with extension as .txt):");
                    String fileName = sc.nextLine();
                    File myfile = new File(fileName);
                    try{
                        myfile.createNewFile();
                        System.out.println("File created Successfully");
                    }catch(Exception e){
                        System.out.println("Unable to create a file");
                        e.printStackTrace();
                    }

                    try{
                        FileWriter filewriter = new FileWriter(fileName);
                        System.out.print("Enter any text:");
                        String text = sc.nextLine();
                        filewriter.write(text);
                        filewriter.close();

                        System.out.println("Text added Successfully");
                    }catch(Exception e){
                        System.out.println("Unable to write inside the File");
                        e.printStackTrace();
                    }

                    try{
                        Scanner s = new Scanner(myfile);
                        String s2 = "";
                        while(s.hasNextLine()){
                            s2 = s.nextLine();
                        }
                        
                        countWord(s2);

                        s.close();
                    }catch(Exception e){
                        System.out.println("Unable to read the file");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sc.nextLine(); // Here we have use this to skip the escape sequence present inside the buffer after using the nextInt function (i.e. \n)

                    System.out.println("Enter any Text:");
                    String word = sc.nextLine();
                    countWord(word);
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please Enter the correct Option");
            }

        }while(n!=3);

        sc.close();
    }
}