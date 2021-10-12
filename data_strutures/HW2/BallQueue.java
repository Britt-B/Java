import java.util.Arrays;

public class BallQueue{	
	//hold data array and size of array
	private int[] data;
    private int size;

	//constructor
    public BallQueue(int capacity) {
		//set size to zero and capacity desired
        this.data = new int[capacity];
        this.size = 0;
    }
    
	//push data onto queue, increment size
    public void enqueue(int element) {
        data[size] = element;
		size++;
    }
	
	//pop element off queue, decrease size, set empty spot to 0
    public int dequeue() {
        int temp = data[0];
		//shuffle item back to match
		for(int i=0; i<size-1; i++){
			data[i] = data[i+1];
		}
		data[size-1] = 0;
        size--;
        return temp;
    }

	//check item at specified index, no removal
    public int peekIndex(int index) {
        return data[index];
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