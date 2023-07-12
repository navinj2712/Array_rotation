import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements : ");
        for(int i = 0; i < size; i++){
             array[i] = scanner.nextInt();
        }
        System.out.println("Enter times to rotate : ");
        int times = scanner.nextInt();
        int start = 0, end = size-1;
        int[] outputArray1 = findArrayRotation(array, start, end);
        int[] outputArray2 = findArrayRotation(outputArray1, start, times - 1);
        for (int i = 0; i < times; i++){
            outputArray1[i] = outputArray2[i];
        }
        int[] outputArray3 = findArrayRotation(outputArray2, times, outputArray2.length - 1);
        for (int i = times; i < outputArray1.length; i++){
            outputArray1[i] = outputArray3[i];
        }
        for (int i = 0; i < outputArray1.length; i++){
            System.out.print(outputArray1[i] + " ");
        }
    }

    private static int[] findArrayRotation(int[] array, int start, int end) {
        int i = start, j = end ;
        while(i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }
}
