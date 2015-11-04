
import java.util.Stack;


public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementQueueUsingStacks a=new ImplementQueueUsingStacks();
//		a.push(1);
//		a.push(2);
//		a.push(3);
//		a.pop();
//		System.out.println(a.peek());
		System.out.println(a.empty());
	}
	/**
	 * 堆栈a和b，a用作入队，b出队.判队满：如果a满且b不为空，则队满.判队空：如果a和b都为空，则队空.
	 * 入队：首先判队满。若队不满：栈a若不满，则直接压入栈a;若a满，则将a中的所有元素弹出到栈b中，然后再将元素入栈a
	 * 出队：若b空就将a中的所有元素弹出到栈b中，然后出来。b不空就直接从b中弹出元素
	 */
	// Push element x to the back of queue.  
    Stack<Integer> stackA = new Stack<Integer>();  
    Stack<Integer> stackB = new Stack<Integer>();  
      
      
    public void push(int x) {  
        stackA.push(x);  
    }  
  
    // Removes the element from in front of queue.  
    public void pop() {  
        if(!stackB.isEmpty()) {  
            stackB.pop();  
        } else {  
            while(!stackA.isEmpty()){  
                stackB.push(stackA.pop());  
            }  
            stackB.pop();  
        }  
    }  
  
    // Get the front element.  
    public int peek() {  
        if(!stackB.isEmpty()) {  
            return stackB.peek();  
        } else {  
            while(!stackA.isEmpty()){  
                stackB.push(stackA.pop());  
            }  
            return stackB.peek();  
        }  
    }  
  
    // Return whether the queue is empty.  
    public boolean empty() {  
        return (stackA.isEmpty() && stackB.isEmpty());  
    }  
}
