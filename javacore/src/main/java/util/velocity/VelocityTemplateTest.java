package util.velocity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * 模版测试类
 * <p>
 * 模版的编写示例：
 * https://velocity.apache.org/engine/devel/user-guide.html#if-elseif-else
 *
 * @author maqidi
 * @date 2023/12/18 11:38 AM
 */
public class VelocityTemplateTest {

    public static void main(String[] args) throws Exception {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId("123456");
        orderInfo.setUserName("John Doe");
        orderInfo.setProductName("Example Product");
        orderInfo.setPrice(null);
        List<String> addressList = Lists.newArrayList("内蒙古", "新疆", "湖北");
        orderInfo.setAddressList(addressList);
        // #if() #end 进行模块处理, 严格大小写
        String templateString = "Order ID: $orderId\nUser Name: $userName\n#if($productName && $productName != '')Product Name: $productName\n#end #if($price && $price != '')价格：$price\n#end#foreach( $address in $addressList)  地址: $address;\n#end";
        String formattedOrderInfo = formatOrderInfo(templateString, orderInfo);
        System.out.println(formattedOrderInfo);
    }


    /**
     * 模版配置类方法
     *
     * @param templateString
     * @param orderInfo
     * @return
     * @throws Exception
     */
    public static String formatOrderInfo(String templateString, OrderInfo orderInfo) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(VelocityEngine.RESOURCE_LOADER, "string");
        ve.addProperty("string.resource.loader.class", StringResourceLoader.class.getName());
        ve.init();

        StringResourceRepository repo = StringResourceLoader.getRepository();
        String myTemplateName = "myTemplate";
        repo.putStringResource(myTemplateName, templateString);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(gson.toJson(orderInfo), new TypeToken<Map<String, Object>>(){}.getType());
        VelocityContext context = new VelocityContext(map);

        Template template = ve.getTemplate(myTemplateName, "UTF-8");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }
}
