package design.factory.simpleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * �򵥹����࣬��������ӿ�
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 13:04
 */
public class CarFactory {
    Map<String,Car> carMap = new HashMap<String, Car>(){
        {
            put("bwm",new BWMCar());
            put("honda",new HondaCar());
        }
    };
    public Car productCar(String carName){
        return this.carMap.get(carName);
    }
}
