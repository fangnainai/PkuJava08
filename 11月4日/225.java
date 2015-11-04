import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackUsingQueues {
      public static void main(String[] args){
    	  Queue<Integer> queue1=new LinkedList<Integer>();  
  	      Queue<Integer> queue2=new LinkedList<Integer>(); 
//  	    queue2.offer(1);
//  	    queue2.offer(2);
  	     ImplementStackUsingQueues a=new ImplementStackUsingQueues();
//  	   for( Integer i : queue2){
//           System.out.println(i);
//       }
//  	 System.out.println("peek="+queue2.peek()); //返回第一个元素 
//  	 int tmp=queue2.peek();
//  	 queue2.poll();
//  	 queue1.offer(tmp);
//  	for( Integer i : queue1){
//        System.out.println(i);
//    }
  	 
    	  a.push(1);
    	  a.push(2);
    	  a.push(3);
    	  a.pop();
    	  System.out.println(a.empty());
    	  
    	  
//  	for( Integer i : queue1){
//      System.out.println(i);
//  }
// 	  a.pop();
  	  System.out.println(a.top());
  	
      }
	
	    Queue<Integer> queue1=new LinkedList<Integer>();  
	    Queue<Integer> queue2=new LinkedList<Integer>(); 
	    
	    
	    /**
	     * 将元素压入栈
	     * @param x
	     */
	    void push(int x) {  
	        if (queue1.isEmpty())  
	        {  
                queue1.offer(x);//要使用offer()来加入元素,它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 
	            while(!queue2.isEmpty()){  
	                int tmp = queue2.peek();  //如果要使用前端而不移出该元素，使用element()或者peek()方法。
	                queue2.poll();  //使用poll()来获取并移出元素
	                queue1.offer(tmp);  
	            }  
	        }else{  
	            queue2.offer(x);  
	            while(!queue1.isEmpty()){  
	                int tmp = queue1.peek();  
	                queue1.poll();  
	                queue2.offer(tmp);  
	            }  
	        }  
	    }  
	  
	   /**
	    *  将元素出栈
	    */
	    void pop() {  
	        if (!queue1.isEmpty())  
	            queue1.poll();  
	        if (!queue2.isEmpty())  
	            queue2.poll();  
	    }  
	  
	    /**
	     * 获取第一个元素
	     * @return
	     */
	    int top() {  
	        if (!queue1.isEmpty())  
	            return queue1.peek();  
	        if (!queue2.isEmpty())  
	            return queue2.peek();
			return 0;  
	    }  
	  
	    /**  
	     * 判断栈是否为空
	     * @return
	     */
	    boolean empty() {  
	        return queue1.isEmpty() && queue2.isEmpty();  
	    }  

}
