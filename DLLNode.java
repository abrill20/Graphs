
public class DLLNode<T> {

	private T data;
	public DLLNode<T> next;
	public DLLNode<T> prev;
	
	public DLLNode(T d)
	{
		data = d;
		next = null;
		prev = null;
	}
	
	public T getData()
	{
		return data;
	}
	
}