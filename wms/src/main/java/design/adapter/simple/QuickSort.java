package design.adapter.simple;

/**
 * ��������������
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/31
 * Time: 16:43
 */
public class QuickSort {

    /**
     * ��������
     *
     * @param array
     * @param startIndex ���������
     * @param endIndex   ���������
     * @return
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //�жϷǿ�
        if (null == array || array.length < 1) {
            return;
        }
        algorithm.sort.quick.QuickSort.quickSort(array, startIndex, endIndex);
    }

    /**
     * ��������
     *
     * @param array
     */
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        sort.quickSort(a);
        System.out.println(a);
    }
}
