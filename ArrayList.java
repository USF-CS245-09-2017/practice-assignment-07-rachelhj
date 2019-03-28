
import java.util.Arrays;
public class ArrayList<T> implements List<T>{
    int count = 0;
    public Object[] tempArray;
    public T[] arr;
    
    public ArrayList(){
        tempArray = new Object[10];
        arr = (T[]) tempArray;
    }
    @Override
    public void add(T item){
        if(arr.length-count<2){
            growList();
        }
        arr[count++]=item;
    }
    @Override
    public void add(int pos, T item){
        if(pos <= count && pos >= 0){
            count++;
        }
        if(arr.length-count<2){
            growList();
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
            arr[pos] = null;
            int temp = pos;
            while(temp<count){
                arr[temp]=arr[temp+1];
                arr[temp+1]=null;
                temp++;
            }
            count--;
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
