package DomaceNaloge;
import java.util.Scanner;
public class scannerTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
         //arg[0] - trace/count, arg[1] - sortings, arg[2] - up/dow
         String read1 = sc.nextLine();
         String[] instructions1 = read1.split("\\s+");
             
         String[] nums1 = sc.nextLine().split("\\s+"); //številke za sortiranje
         int[] elements1 = new int[nums1.length];
             
         
         for (int i = 0; i < nums1.length; i++) {
             elements1[i] = Integer.parseInt(nums1[i]);
         }
        
         
        }
    }
}
