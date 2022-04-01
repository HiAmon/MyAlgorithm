package temp;

/**
 * -verbose:gc
 * -Xmx200M
 * -Xms200M
 * -Xmn50M
 * -XX:+PrintGCDetails
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxTenuringThreshold=3
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 */
public class GCDemo {
    public static void main(String[] args) throws InterruptedException{
        byte[] byte1m_1 = new byte[1 * 1024 * 1024];
        byte[] byte1m_2 = new byte[1 * 1024 * 1024];
        byte[] byte1m_3 = new byte[1 * 1024 * 1024];//3M
        String str = new byte[100 * 1024 * 1024].toString();//100M
        makeGarbage(34);//34M
        byte[] byteArr = new byte[10*1024*1024];//10M
        makeGarbage(38);//38M

    }
    private static void makeGarbage(int size){
        byte[] byteArrTemp = new byte[size * 1024 * 1024];
    }
}
/**
 * Heap
 *  par new generation   total 46080K, used 4096K [0x00000007b3800000, 0x00000007b6a00000, 0x00000007b6a00000)
 *   eden space 40960K,  10% used [0x00000007b3800000, 0x00000007b3c001d0, 0x00000007b6000000) //4M
 *   from space 5120K,   0% used [0x00000007b6000000, 0x00000007b6000000, 0x00000007b6500000)
 *   to   space 5120K,   0% used [0x00000007b6500000, 0x00000007b6500000, 0x00000007b6a00000)
 *  concurrent mark-sweep generation total 153600K, used 0K [0x00000007b6a00000, 0x00000007c0000000, 0x00000007c0000000)
 *  Metaspace       used 3169K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
 */