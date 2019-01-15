public class MainClass {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] array1 = new float[h];
    static float[] array2 = new float[h];



    public static void main (String[] args) {

        for(int i = 0; i<arr.length; i++){
            arr[i] = 1;
        }

        oneThread(arr);

        manyThreads(arr);

    }


    private static void oneThread(float[] arr){

        long a = System.currentTimeMillis();

        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void manyThreads(float[] array){

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, array1, 0, h);
        System.arraycopy(arr, h, array2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < array1.length; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < array2.length; i++) {
                    array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, arr, 0, h);
        System.arraycopy(array2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }
}








