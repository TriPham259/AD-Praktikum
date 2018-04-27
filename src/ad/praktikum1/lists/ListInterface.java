package ad.praktikum1.lists;
/**
* Listen-Interface 
*/
public interface ListInterface<T> {
	/**
	 * get size of list 
	 * @return
	 */
	public int size();
	
	/**
	 * add element at indexition
	 * @param data
	 * @param index > 0 und index < length 
	 * @throws IllegalArgumentException 
	 */
	public void add(T data, int index) throws IllegalArgumentException;
	
	/**
	 * remove element at indexition 
	 * @param index > 0 und index < length 
	 * @return Removed data
	 * @throws IllegalArgumentException
	 */
	public T delete(int index) throws IllegalArgumentException;
	
	/**
	 * get element 
	 * @param index > 0 und index < length 
	 * @return 
	 * @throws IllegalArgumentException
	 */
	public T get(int index) throws IllegalArgumentException;
	
	/**
	 * delete all elements 
	 */
	public void empty();
	
	/**
	 * join 2 lists
	 * @param list
	 * @return new concatenated list 
	 * @throws IllegalArgumentException
	 */
//	public ListInterface<T> join(ListInterface<T> list) throws IllegalArgumentException;
	
	/**
	 * extract part of the list
	 * @param start >= 0
	 * @param start <= end < length
	 * @return sublist 
	 * @throws IllegalArgumentException
	 */
	public ListInterface<T> extract(int start, int end) throws IllegalArgumentException;
	
}
