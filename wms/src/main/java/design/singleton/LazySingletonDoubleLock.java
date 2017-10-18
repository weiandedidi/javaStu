package design.singleton;

/**
 * ������
 * ��Ҫע����ǣ����ʹ��˫�ؼ��������ʵ������ʽ�����࣬��Ҫ�ھ�̬��Ա����instance֮ǰ�������η�volatile��
 * ��volatile���εĳ�Ա��������ȷ������̶߳��ܹ���ȷ�����Ҹô���ֻ����JDK 1.5�����ϰ汾�в�����ȷִ��
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/18
 * Time: 11:43
 */
public class LazySingletonDoubleLock {
    private volatile static LazySingletonDoubleLock instance = null;

    //˽�еķ���
    private LazySingletonDoubleLock() {
    }

    //˫���ڲ���
    public synchronized LazySingletonDoubleLock getInstance() {
        //��һ���ж�
        if (instance == null) {
            //���������
            synchronized (LazySingletonDoubleLock.class) {
                //�ڶ����ж�
                if (instance == null) {
                    instance = new LazySingletonDoubleLock(); //��������ʵ��
                }
            }
        }
        return instance;
    }

}
