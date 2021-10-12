import java.util.Arrays;

public class BallStack{
	//hold data array and size of array
    private int[] data;
    private int size;

	//constructor
    public BallStack(int capacity){
		//set size to zero and capacity desired
		this.size = 0;
        this.data = new int[capacity];
    }
    
	//push data onto stack, increment size
    public void push(int ballNum){
        data[size] = ballNum;
		size++;
    }
	
	//pop element off, decrease size, set empty spot to 0
    public int pop(){
		int temp = data[size-1];
		data[size-1] = 0;
        size--;
        return temp;
    }

	//check item at end, no removal
    public int peek(){
        return data[size];
	}
	
	//get size of stack
	public int size(){
		return this.size;
	}
	
	//print check for debugging
	public void printMe(){
		System.out.println(Arrays.toString(data));
	}
}
