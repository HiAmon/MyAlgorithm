package hw.interview.sort;

/**
 * 自定义排序接口
 * @param <T>
 */
public interface MySortable<T> {
    void arraySort(T[] array);

    void linkedSort(MyNode head);

    default void arraySwap(int i ,int j, T[] array){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    default void linkedSwap(MyNode i, MyNode j){
        MyNode temp = i;
        i = j;
        j = temp;
    }
}
