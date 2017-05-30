package concurrent.Future;

/**
 * Created by xli on 2017/5/18.
 */
public class Client {

    public Data request(final String para){
        final FutureData futureData = new FutureData();
        new Thread(){
            public void run(){
                RealData realData = new RealData(para);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;
    }
}
