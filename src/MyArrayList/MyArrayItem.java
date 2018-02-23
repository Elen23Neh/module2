package MyArrayList;

public class MyArrayItem<T> {
    public T value;
    public MyArrayItem<T> next;

    public MyArrayItem(T value){
        this.value = value;
    }

    public MyArrayItem(T value, MyArrayItem<T> next){
        this.value = value;
        this.next = next;
    }
}
