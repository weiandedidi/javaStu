/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/8/14
 * Time: 11:32
 */
public class CharTest {
    public static void main(String[] args) {
        Integer a = 2013;
        Integer b = 1989;
        Integer c = 2000;

        System.out.println(getModelYear(a));
        System.out.println(getModelYear(b));
        System.out.println(getModelYear(c));
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.toString());

    }

    public static Integer getModelYear(Integer modelYear){
        if (null != modelYear) {
            if (modelYear > 2000) {
                Integer temp = modelYear - 2000;
                return temp;
            } else {
                String tempStr = Integer.toString(modelYear);
                String num = tempStr.substring(tempStr.length() - 2, tempStr.length());
                Integer temp = Integer.valueOf(num);
                return temp;
            }
        }
        return null;
    }
}
