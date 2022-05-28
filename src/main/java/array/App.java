package array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Random;

public class App {
    static int viewer = 0;

    public static void main(String[] args) {
    }


    static int algCompare(int[] arr) throws Exception {
        if (arr != null && arr.length >= 2) {
            int[] noDuplicates = IntStream.of(arr).distinct().toArray();
            int min1 = noDuplicates[0];
            for (int i = 0; i < noDuplicates.length; i++) {
                if (noDuplicates[i] < min1) {
                    min1 = noDuplicates[i];
                }
            }

            int min2 = min1;
            for (int i = 0; i < noDuplicates.length; i++) {
                if (noDuplicates[i] > min1) {
                    min2 = noDuplicates[i];
                    break;
                }
            }

            for (int i = 0; i < noDuplicates.length; i++) {
                if (noDuplicates[i] > min1 && noDuplicates[i] < min2) {
                    min2 = noDuplicates[i];
                }
            }
            //int[] res = { min1, min2 };
            int result = min1 + min2;
            return result;
        } else {
            throw new Exception("array is not valid");
        }
    }

    static int algSort(int[] arr) throws Exception {
        if (arr != null && arr.length >= 2) {
            int[] noDuplicates = IntStream.of(arr).distinct().toArray();
            Arrays.sort(noDuplicates);
            int[] res = { noDuplicates[0], noDuplicates[1] };
            int result = res[0] + res[1];
            return result;
        } else {
            throw new Exception("array is not valid");
        }

    }

    static int algStream(int[] arr) throws Exception {
        if (arr != null && arr.length >= 2) {
            int min = Arrays.stream(arr).min().getAsInt();
            int[] arr1 = Arrays.stream(arr).filter(value -> value != min).toArray();
            int min1 = Arrays.stream(arr1).min().getAsInt();
            //int[] res = { min, min1 };
            int result = min + min1;
            return result;
        } else {
            throw new Exception("array is not valid");
        }
    }

    static int algMath(int[] arr) throws Exception {
        if (arr != null && arr.length >= 2) {
            int min = IntStream.of(arr).min().orElse(Integer.MAX_VALUE);
            int[] arr1 = Arrays.stream(arr).filter(value -> value != min).toArray();
            int min1 = IntStream.of(arr1).min().orElse(Integer.MAX_VALUE);
            //int[] res = { min, min1 };
            return min + min1;
        } else {
            throw new Exception("array is not valid");
        }
    }

    static int algCollections(int[] arr) throws Exception {
        if (arr != null && arr.length >= 2) {
            int min = Collections.min(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
            int[] arr1 = Arrays.stream(arr).filter(value -> value != min).toArray();
            int min1 = Collections.min(Arrays.asList(Arrays.stream(arr1).boxed().toArray(Integer[]::new)));
            //int[] res = { min, min1 };
            return min + min1;
        } else {
            throw new Exception("array is not valid");
        }
    }


    public static int[] generateArray(int length, int minV, int maxV) throws Exception {

        int[] randomArray = null;
        if (length >= 2) {
            Random random = new Random();
            try {
                int min = minV;
                int max = maxV;
                if (min > max) {
                    min = maxV;
                    max = minV;
                }
                randomArray = random.ints(length, min, max).toArray();
                int pozition1 = random.nextInt(0, (length) - 1);
                int pozition2 = random.nextInt(0, (length - 1));
                if (pozition1 == pozition2) {
                    String str = viewer == 0 ? "FIGHT!!! " : "";
                    System.out.println(str);
                    if (length > 2) {
                        while (pozition1 == pozition2) {
                            /** rivalry for pozitions */
                            str = viewer == 0
                                    ? " rivalry for pozitions - " + pozition1 + ":" + pozition2 + " Damm!! Once again!"
                                    : "";
                            System.out.println(str);
                            pozition2 = random.nextInt(0, length - 1);
                        }
                    } else {
                        pozition1 = 0;
                        pozition2 = 1;
                    }
                    str = viewer == 0 ? "Bingo! - " + pozition1 + ":" + pozition2 : "";
                    System.out.println(str);
                    viewer++;
                }
                randomArray[pozition1] = min;
                randomArray[pozition2] = min + 1;
                return randomArray;
            } catch (Exception e) {
                throw new Exception("random generator error");
            }
        } else {
            throw new Exception(" array length (" + length + ") must be pozitive value and > 2");
        }
    }
}
