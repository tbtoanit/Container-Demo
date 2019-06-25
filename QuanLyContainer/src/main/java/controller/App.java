package controller;
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
        App a = new App();
        a.menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ContainerController t = new ContainerController();
        String op = "";
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1 Thêm 1 container vào danh sách");
            System.out.println("2. In danh sách tất cả các container");
            System.out.println("3. In danh sách theo phân loại theo container");
            System.out.println("4. In danh sách theo tình trạng container");
            System.out.println("5. In danh sách các container nhập/xuất cảng Cát Lái:");
            System.out.println("6. thoat");
            System.out.print("Vui long chon chuc nang 1-5: ");
            op = sc.nextLine();
            switch (op) {
                case "1":
                    t.nhap();
                    break;
                case "2":
                    t.display();
                    break;
                case "3":
                    System.out.print("nhập phân loại container: ");
                    t.display(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.println("nhâp tình trạng container: ");
                    t.search(sc.nextLine().trim());
                    break;
                case "5":
                    System.out.println("Check container");
                    t.checkContainer();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Thao tác không hợp lệ !");
            }
        }
    }
}
