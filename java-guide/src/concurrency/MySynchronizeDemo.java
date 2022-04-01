package concurrency;



public class MySynchronizeDemo{
    public volatile static MySynchronizeDemo member;

    public MySynchronizeDemo() {
    }

    public static Object getMember(){
        if (null == member){
            synchronized (MySynchronizeDemo.class){
                if (null == member){
                    member = new MySynchronizeDemo();
                }
            }
        }
        return member;
    }

}
//  执行以下语句：
//  > javac MySynchronizeDemo.java
//  > javap -c -s -v -l MySynchronizeDemo.class
//
//执行结果部分如下：
//    public static java.lang.Object getMember();
//    descriptor: ()Ljava/lang/Object;
//            flags: ACC_PUBLIC, ACC_STATIC
//            Code:
//            stack=2, locals=2, args_size=0
//            0: aconst_null
//            1: getstatic     #2                  // Field member:Ljava/lang/Object;
//            4: if_acmpne     39
//            7: ldc           #3                  // class concurrency/MySynchronizeDemo
//            9: dup
//            10: astore_0
//            11: monitorenter
//            12: aconst_null
//            13: getstatic     #2                  // Field member:Ljava/lang/Object;
//            16: if_acmpne     29
//            19: new           #4                  // class java/lang/Object
//            22: dup
//            23: invokespecial #1                  // Method java/lang/Object."<init>":()V
//            26: putstatic     #2                  // Field member:Ljava/lang/Object;
//            29: aload_0
//            30: monitorexit
//            31: goto          39
//            34: astore_1
//            35: aload_0
//            36: monitorexit
//            37: aload_1
//            38: athrow
//            39: getstatic     #2                  // Field member:Ljava/lang/Object;
//            42: areturn
//            Exception table:
//            from    to  target type
//            12    31    34   any
//            34    37    34   any
//            LineNumberTable:
//            line 11: 0
//            line 12: 7
//            line 13: 12
//            line 14: 19
//            line 16: 29
//            line 18: 39
//            StackMapTable: number_of_entries = 3
//            frame_type = 252 /* append */
//            offset_delta = 29
//            locals = [ class java/lang/Object ]
//        frame_type = 68 /* same_locals_1_stack_item */
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//        offset_delta = 4