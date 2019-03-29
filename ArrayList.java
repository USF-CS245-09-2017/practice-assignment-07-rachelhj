
import java.util.Arrays;
public class ArrayList<T> implements List<T>{
    int count;
    public T[] arr;
    
    public ArrayList(){
        arr = (T[]) new Object[10];
        count = 0;
    }
    @Override
    public void add(T item){
        if(arr.length<=count){
            growList();
        }
        arr[count++]=item;
    }
    @Override
    public void add(int pos, T item){
        if(pos <= count && pos >= 0){
            count++;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
        if(arr.length<=count){
            growList();
        }
        int temp = count-2;
        while (temp>=pos){
            arr[temp+1]=arr[temp];
            temp--;
        }
        arr[pos] = item;
    }        
    @Override
    public T get(int pos){
        if(pos<=count&&pos>=0){
            return arr[pos];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    @Override
    public T remove(int pos){
        if(pos<count){
            T item = arr[pos];
            int temp = pos;
            count--;
            while(temp<count){
                arr[temp]=arr[temp+1];
                temp++;
            }
            return item;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    @Override
    public int size(){
        return count;
    }
    private void growList(){
        arr = Arrays.copyOf(arr, arr.length*2);
    }
}