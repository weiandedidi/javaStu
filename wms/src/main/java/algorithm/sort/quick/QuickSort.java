package algorithm.sort.quick;

/**
 * ��������
 * ˼�룺�ֶ���֮���û�׼�ȷֶѣ�Ȼ���ڶ������һ�׼�����򣨵ݹ飩��
 * �ؼ��㣺
 * 1.��׼
 * 2.���ҽ���
 * 3.�ݹ�
 * �˷���ֻ����ʹ��������Ԫ����Ϊ��׼
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/11/1
 * Time: 10:45
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        int left = startIndex;  //���α�
        int right = endIndex;   //���α�
        int standard = arr[left];   //��׼
        while (left < right) {
            while (left < right && arr[right] >= standard) {    //��starder���ֻ��right�α���һ��arr��ֵ�������仯
                right--;
            }
            arr[left] = arr[right];                             //������С�ļ�¼�Ƶ��Ͷ�
            while (left < right && arr[left] <= standard) {     //��starderС��ֻ��left�α����ƣ�arr��ֵ�������仯
                left++;
            }
            arr[right] = arr[left];                             //�������ļ�¼�Ƶ��߶�
        }
        arr[left] = standard;                                   //�����¼��
        quickSort(arr, startIndex + 1, endIndex);   //�������
        quickSort(arr, startIndex, endIndex - 1);   //�Ҳ�����
    }

    /**
     * ����� 49, 38��ͷֻ����0��ʼ  ���ǰ����Ѿ������ˣ�ֻ��ı�starIndex�� ���� 4, 5, 49���Դ�2��ʼ
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {4, 5, 49, 38, 65, 97, 76, 34, 13, 27, 49, 78, 34, 12, 64, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 34, 53, 51};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(" " + a[i]);
        }
    }

}
