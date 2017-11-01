package design.adapter.simple;

/**
 * ������������������
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/31
 * Time: 16:42
 */
public class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj; //����������QuickSort����
    private BinarySearch searchObj; //����������BinarySearch����

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    public int search(int[] array, int key) {
        return searchObj.binarySearch(array, key);
    }
}
