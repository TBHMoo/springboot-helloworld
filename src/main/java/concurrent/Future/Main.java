package concurrent.Future;

/**
 * Created by xli on 2017/5/18.
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("xyy2048 ");
        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("数据 = " + data.getContent());

    }

}
