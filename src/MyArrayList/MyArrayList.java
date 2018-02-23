package MyArrayList;

public class MyArrayList<T> {
    private MyArrayItem<T> head;
    public int count = 0;

    public int add(T element) {
        int index = 0;

        if (this.head == null) {
            this.head = new MyArrayItem<T>(element);
            return index;
        }

        MyArrayItem<T> current = this.head;
        while (current.next != null) {
            current = current.next;
            index++;
        }

        current.next = new MyArrayItem<T>(element);
        this.count = index + 1;
        return index;
    }

    public void add(T element, int index) {
        this.checkIndex(index);

        if (index == 0) {
            MyArrayItem<T> item = new MyArrayItem<T>(element, this.head);
            this.head = item;
            this.count++;
            return;
        }

        int currentIndex = 0;
        MyArrayItem<T> current = this.head;
        while (currentIndex != index - 1) {
            current = current.next;
            currentIndex++;
        }

        MyArrayItem<T> item = new MyArrayItem<T>(element, current.next);
        current.next = item;
        this.count++;
    }

    public T get(int index) {
        this.checkIndex(index);

        MyArrayItem<T> item = this.head;
        for (int i = 0; i < index; i++, item = item.next);

        return item.value;
    }

    public void remove(int index){
        this.checkIndex(index);

        MyArrayItem<T> item = this.head;
        for (int i = 0; i < index-1; i++, item = item.next);

        item.next = item.next.next;
    }

    public void print() {
        MyArrayItem<T> current = this.head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index > this.count)
            throw new ArrayIndexOutOfBoundsException();
    }
}
