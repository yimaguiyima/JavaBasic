package com.thread.RedPacket;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedPacket {
    static long redPacketId = 111;
    static RedPacketService redPacketService = new RedPacketService();
    static ExecutorService executor =
            Executors.newCachedThreadPool();
    public static void main(String[] args) {
        int skillNum = 100;
        final CountDownLatch latch = new CountDownLatch(skillNum);//N个抢红包
        /**
         * 初始化红包数据，抢红包拦截
         */
        RedisUtil.cacheValue(redPacketId+"-num",10);
        /**
         * 初始化红包金额，单位为分
         */
        RedisUtil.cacheValue(redPacketId+"-money",20000);
        /**
         * 模拟100个用户抢10个红包
         */
        for(int i=1;i<=skillNum;i++){
            int userId = i;
            Runnable task = () -> {
                /**
                 * 抢红包 判断剩余金额
                 */
                Integer money = (Integer) RedisUtil.getValue(redPacketId+"-money");
                if(money>0){
                    /**
                     * 虽然能抢到 但是不一定能拆到
                     * 类似于微信的 点击红包显示抢的按钮
                     */
                    Result result = redPacketService.startTwoSeckil(redPacketId,userId);
                    if(result.get("code").toString().equals("500")){
                        System.out.println("用户"+ userId + "手慢了，红包派完了");
                    }else{
                        Double amount = Double.parseDouble(result.get("msg").toString());
                        System.out.println("用户" +userId+ "抢红包成功，金额："+ amount);
                    }
                }else{
                    /**
                     * 直接显示手慢了，红包派完了
                     */
                    //System.out.println("用户{}手慢了，红包派完了",userId);
                }
                latch.countDown();
            };
            executor.execute(task);
        }
        try {
            latch.await();
            Integer restMoney = Integer.parseInt(RedisUtil.getValue(redPacketId+"-money").toString());
            System.out.println("剩余金额：" + restMoney);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
