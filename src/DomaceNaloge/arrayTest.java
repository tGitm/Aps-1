package DomaceNaloge;

public class arrayTest {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arrCopy[] = new int[arr1.length*2];
    
        System.arraycopy(arr1, 0, arrCopy, 0, arr1.length);

        /*for (int i = 0; i < arr1.length; i++) {
            arrCopy[i] = arr1[i];
        }
*/
        for (int i = 0; i < arrCopy.length; i++) {
            System.out.println(arrCopy[i]);
            
        }
        
    }
 
}
