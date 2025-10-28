import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    boolean run = true;
        while (run) {    
       
            Three tree = new Three();
            Scanner scanner = new Scanner(System.in);

            System.out.println("=================================");
            System.out.println("Program sederhana Binary tree (pilih mode)");
            System.out.println("- Mode Otomatis (1)");
            System.out.println("- Mode Manual (2)");
            System.out.println("- Exit (3)");
            System.out.println("=================================");
                 
            
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("nilai awal tree = 4 , 2 , 6 , 1 , 3 , 5 , 7");
                    tree.Insert(4);
                    tree.Insert(2);
                    tree.Insert(6);
                    tree.Insert(1);
                    tree.Insert(3);
                    tree.Insert(5);
                    tree.Insert(7); 
                    System.out.println("Tampilan awal tree ");
                    tree.displayAscii();
                    System.out.println("---------------------------------");
                    System.out.print("Nilai pada InOrder: ");
                    tree.InOrder();
                    System.out.println();
                    System.out.print("Nilai pada PreOrder: ");
                    tree.PreOrder();
                    System.out.println();
                    System.out.print("Nilai pada PostOrder: ");
                    tree.PostOrder();
                    System.out.println();
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    int key;
                    char choice;
                    do {
                        System.out.print("Masukkan nilai yang ingin ditambahkan: ");
                        key = scanner.nextInt();
                        tree.Insert(key);
                        System.out.println("Nilai " + key + " telah ditambahkan ke dalam tree.");
                        System.out.print("Apakah Anda ingin menambahkan nilai lain? (y/n): ");
                        choice = scanner.next().charAt(0);
                    } while (choice == 'y' || choice == 'Y'); 
                    System.out.println("Tampilan akhir tree ");;
                    tree.displayAscii();
                    System.out.println("---------------------------------");
                    System.out.print("Nilai pada InOrder: ");
                    tree.InOrder();
                    System.out.println();
                    System.out.print("Nilai pada PreOrder: ");     
                    tree.PreOrder();
                    System.out.println();
                    System.out.print("Nilai pada PostOrder: ");
                    tree.PostOrder();
                    System.out.println();
                    System.out.println("---------------------------------");
                    break;
                    case 3:
                    System.out.println("Exiting program.");
                    run = false;
                    break; 
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;   
            }
        }
    }    
}
