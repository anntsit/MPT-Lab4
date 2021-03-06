package refactored;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Lab4 {
    public static int[] array;

    public static void main(String[] args) {
        Random random = new Random();
        array = new int[20];
        for (int i = 0; i < 20; i++)
            array[i] = random.nextInt(50);
        sortRun();
        arrayRun();
    }

    private static void sortRun() {
        InsertionSort insertion = new InsertionSort();
        QuickSort quick = new QuickSort();
        BubbleSort bubble = new BubbleSort();
        ShellSort shell = new ShellSort();
        HeapSort heap = new HeapSort();
        CycleSort cycle = new CycleSort();

        insertion.sort(arrayCopy(array));
        quick.sort(arrayCopy(array), 0, arrayCopy(array).length - 1);
        bubble.sort(arrayCopy(array));
        shell.sort(arrayCopy(array));
        heap.sort(arrayCopy(array));
        cycle.sort(arrayCopy(array));
    }

    private static void arrayRun() {
        System.out.print("Input array size: ");
        int size = checkInput();
        int[] array = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++)
            array[i] = checkInput();
        getArrayOperationsInfo(new ArrayOperations(array));

        System.out.print("\nSet matrix dimension: ");
        size = checkInput();
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                matrix[i][j] = random.nextInt(30) - 15;
        }
        printMatrix(matrix);
        getMatrixOperationsInfo(new MatrixOperations(matrix));
    }

    public static int[] arrayCopy(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] i:matrix) {
            for (int item:i)
                System.out.print(item + "\t");
            System.out.print("\n");
        }
    }

    private static int checkInput() {
        Scanner input = new Scanner(System.in);
        int value;
        try {
            value = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("There are errors in your input");
            return checkInput();
        }
        return value;
    }

    private static void getArrayOperationsInfo(ArrayOperations operations){
        System.out.println("Number of even elements: " + operations.getEvenNumbers());
        System.out.println("Sum of elements  multiplied by 3: " + operations.getMultipliedSum());
        System.out.println("Array delta: " + operations.getDelta());
        System.out.println("Array mean: " + operations.getMean());
        System.out.println("Max and min sum: " + operations.getMaxMinSum());
        System.out.println("Module max element: " + operations.getModuleMax());
    }

    private static void getMatrixOperationsInfo(MatrixOperations matrixOperations){

        System.out.println("\nSum of the elements located behind the first negative element:");
        printMatrix(matrixOperations.getAfterNeg());
        System.out.println("Sum of the elements located before the last negative element:");
        printMatrix(matrixOperations.getBeforeNeg());
    }
}
