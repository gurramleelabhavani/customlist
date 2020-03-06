import java.util.Arrays;
public class customlist<E>
{
    private int length=0;
    private static final int stamina=10;
    private Object element[];
    public customlist() {
        element=new Object[stamina];
    }
    public void add(E e)
    {
        if (length==element.length)
        {
            ensureCapacity();
        }
        element[length++]=e;
    }
    public E get(int i)
    {
        if (i>=length||i<0)
        {
            throw new IndexOutOfBoundsException("Index: "+i+", Size "+i);
        }
        return (E) element[i];
    }
    public E remove(int i) {
        if (i>=length||i<0) {
            throw new IndexOutOfBoundsException("Index: "+i +", Size "+i);
        }
        Object item=element[i];
        int numElts=element.length-(i + 1) ;
        System.arraycopy(element, i + 1,element,i,numElts ) ;
        length--;
        return (E) item;
    }
    public int size() {
        return length;
    }
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for(int i=0; i<length ;i++) {
            sb.append(element[i].toString());
            if(i<length-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void ensureCapacity() {
        int newSize=element.length * 2;
        element=Arrays.copyOf(element, newSize);
    }
}
class Main
{
    public static void main(String[] args)
    {
        customlist<Integer> list=new customlist<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println( list.get(0) );
        System.out.println( list.get(1) );
        System.out.println(list.size());
    }
}