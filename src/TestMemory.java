import java.util.ArrayList;
import java.util.List;

public class TestMemory {
    static class OOMObject {
        public byte[] placehodler = new byte[64*1024];
    }
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int num =1000;
        int i = 0;
        while (true) {
            Thread.sleep(50);
            i++;
            list.add(new OOMObject());
        }
       // System.gc();
       // Thread.sleep(500000);
    }
}
