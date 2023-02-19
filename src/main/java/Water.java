import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Water {
    public static int[] waterLevel(int[] array, int index) {
        if (array[index] > 1) {
            array[index] = 0;
            if ((index - 1) < 0 & index + 1 < array.length) {
                array[index + 1] = array[index + 1] + 1;
                if (array[index + 1] >= 1) waterLevel(array, index + 1);
            } else if (index + 1 >= array.length & index - 1 > 0) {
                array[index - 1] = array[index - 1] + 1;
                if (array[index - 1] >= 1) waterLevel(array, index - 1);
            } else if (index - 1 < 0 & index + 1 >= array.length) {
                array[index] = 0;
            } else {
                array[index + 1] = array[index + 1] + 1;
                array[index - 1] = array[index - 1] + 1;
                if (array[index - 1] >= 1) waterLevel(array, index - 1);
                if (array[index + 1] >= 1) waterLevel(array, index + 1);
            }
        } else array[index] = 1;
        return array;
    }

    public static void main(String[] args) {
        Long date = System.currentTimeMillis();
        System.out.println(date + "начало");
        Scanner sc;
        int start;
        int end;
        int shiftStart;
        int[] roadSections;
        try {
            sc = new Scanner(new File("C:\\Users\\vasya\\Desktop\\test.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("файл не найден");
        }
        String[] firstString = sc.nextLine().split(" ");
        start = 0 + Integer.parseInt(firstString[1]);
        end = Integer.parseInt(firstString[2]);
        shiftStart = 0 - start;
        roadSections = new int[end - start + 1];
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            int currentRoadSection = Integer.parseInt(str[1]);
            switch (str[0]) {
                case "?":
                    System.out.println(roadSections[currentRoadSection + shiftStart]);
                    break;
                case "+":
                    roadSections[currentRoadSection + shiftStart] = roadSections[currentRoadSection + shiftStart] + 1;
                    waterLevel(roadSections, currentRoadSection + shiftStart);
            }
        }
        System.out.println(System.currentTimeMillis() + "конец");
        System.out.println(System.currentTimeMillis() - date + "разница");
    }
}