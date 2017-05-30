package concurrent.Future;

/**
 * Created by xli on 2017/5/18.
 */
public class FutureData implements Data {

    protected boolean isReady = false;

    protected RealData realData = null;

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData =realData;
        isReady = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.content;
    }
}
