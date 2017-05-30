package concurrent.Future;

/**
 * Created by xli on 2017/5/18.
 */
public class RealData implements Data {

    protected  final String content;

    public   RealData(String  para){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<10 ;i++){
            sb.append(para);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        content = sb.toString();
    }
    public String getContent() {
        return content;
    }
}
