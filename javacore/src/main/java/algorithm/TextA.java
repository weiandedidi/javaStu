package algorithm;

import lombok.Data;

import java.util.concurrent.CompletableFuture;

/**
 * 问题:查询一个商品详情,需要分别去查商品信息,卖家信息,库存信息,订单信息等,这些查询相互独立,在不同的服务上,假设每个查询都需要一到两秒钟,要求总体查询时间小于2 秒.
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-04-25 11:26
 */
public class TextA {

    public static void main(String[] args) {
        //定义总查询方法，调用上面的查询接口

        //查询时间捕捉一下
        long start = System.currentTimeMillis();
        //每一步调用需要异步的CompletableFuture
        CompletableFuture<Object> product = CompletableFuture.supplyAsync(() -> getProduct(new Object()));
        CompletableFuture<Object> sellers = CompletableFuture.supplyAsync(() -> getSellers(new Object()));
        CompletableFuture<Object> stocks = CompletableFuture.supplyAsync(() -> getStocks(new Object()));
        CompletableFuture<Object> orders = CompletableFuture.supplyAsync(() -> getOrders(new Object()));
        //等待素有查询完成
        CompletableFuture.allOf(product, sellers, stocks, orders).join();
        //查询出来的拼装在一起
        Result result = new Result();
        //瓶装逻辑
        result.setProduct(product.join());
        result.setSellers(sellers.join());
        result.setStocks(stocks.join());
        result.setOrders(orders.join());
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));

    }

    private static Object getOrders(Object params) {
        try {
            Thread.sleep(1000);
            System.out.println("获取订单");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Object();
    }

    private static Object getStocks(Object params) {
        try {
            Thread.sleep(1000);
            System.out.println("获取库存");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Object();
    }

    private static Object getSellers(Object params) {
        try {
            Thread.sleep(1000);
            System.out.println("获取售卖方");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Object();
    }


    private static Object getProduct(Object params) {
        try {
            Thread.sleep(1000);
            System.out.println("获取商品");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Object();
    }
    //简单实现各查询接口

    @Data
    private static class Result {
        private Object product;
        private Object sellers;
        private Object stocks;
        private Object orders;
    }

}
