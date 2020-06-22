import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        int num =1000;
        int i = 0;
        while (true) {
           // Thread.sleep(50);
            i++;
            list.add(String.valueOf(i).intern());
        }
        // System.gc();
        // Thread.sleep(500000);
    }
}
