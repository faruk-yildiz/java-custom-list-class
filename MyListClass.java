import java.util.Arrays;
import java.util.Collection;

public class MyListClass<T> {
    private int capacity = 10;
    private T[] array;

    public MyListClass() {
        array = (T[]) new Object[this.capacity];
    }

    public MyListClass(int capacity) {
        this.capacity = capacity;
        array=(T[]) new Object[this.capacity];
    }

    public int size() {
        int count = 0;
        for (T item : array) {
            if (item == null)
                return count;
            else {
                count++;
            }
        }
        return count;
    }

    public void addData(T data) {
        if (size() == this.capacity) {
            int tempCapacity = this.capacity;
            this.capacity *= 2;
            T[] tempArray = Arrays.copyOf(array, capacity);
            array = tempArray;
            array[tempCapacity] = data;
        } else {
            array[this.size()] = data;
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

    public T getData(int index) {
        if (index < 0 || index >= getCapacity())
            return null;
        else
            return array[index];
    }

    public T remove(int index) {
            T deletedItem;
            if(!contains(this.array[index]) || index<0 || index>=this.capacity)
                return null;
            else{
                deletedItem=this.array[index];
                for(int i=index,j=i+1;j<capacity;i++,j++){
                    if(this.array[j]==null){
                        this.array[i]=null;
                        return deletedItem;
                    }
                    else{
                        this.array[i]=this.array[j];
                    }

                }
            }
            return deletedItem;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= getCapacity())
            return null;
        else
        {
            array[index]=data;
            return data;
        }
    }

    @Override
    public String toString() {
        if(size()==0)
            return "[]";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (T arr : this.array) {
                if (arr != null) {
                    stringBuilder.append(arr.toString() + ",");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public int indexOf(T data) {
        for(int i=0;i<array.length;i++){
            if(array[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int index=-1;
        for(int i=0;i<array.length;i++){
            if(array[i].equals(data))
                index=i;
        }
        return index;
    }

    public boolean isEmpty() {
        if(size()==0)
            return true;
        else
            return false;
    }

    public T[] toArray() {
        return this.array;
    }

    public void clear() {
        for(int i=0;i<this.capacity;i++){
            this.array[i]=null;
        }
    }

    public MyListClass<T> subList(int start, int finish) {
        MyListClass<T> newList = new MyListClass<>();
        for(int i = start+1; i<finish; i++){
            newList.addData(this.array[i]);
        }
        return newList;
    }

    public boolean contains(T data) {
        for(T item:this.array){
            if(item==null)
                return false;
            else if(item.equals(data))
                return true;
        }
        return false;
    }

}
