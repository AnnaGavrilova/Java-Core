package CheckSizeOfArray;

public class CheckArraySize {

    public static void main(String[] args) {

        String[][] array = new String[4][4];

        array = new String[][]{{"2", "5", "ж", "9"}, {"9", "8", "6", "4"}, {"9", "5", "6", "3"}, {"6", "8", "3", "5"}};
        try {
            checkSize(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


    }

    public static void checkSize(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        if (array.length != 4) throw new MyArraySizeException("Необходим массив размером 4 * 4");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Необходим массив размером 4 * 4");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e1) {
                    throw new MyArrayDataException("Необходим числовой формат данных в ячейке", i, j);
                }
            }
        }

        System.out.println(summ);

    }

}



