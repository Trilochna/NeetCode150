
// Let's go through each line of the provided Java code and explain its purpose:

// java
// Copy code
// class MinStack {

//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;

//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
// class MinStack {: This line declares a new class named "MinStack." It is a custom implementation of a stack that will also support finding the minimum element efficiently.

// private Stack<Integer> stack;: This line declares a private member variable stack, which is an instance of the built-in Stack class in Java. It will store the actual elements pushed into the MinStack.

// private Stack<Integer> minStack;: This line declares another private member variable minStack, which is also an instance of the built-in Stack class in Java. This stack will store the minimum elements at each step, allowing for quick retrieval of the minimum value in the MinStack.

// public MinStack() {: This is the constructor of the MinStack class. When an object of this class is created, this constructor will be called.

// stack = new Stack<>();: Inside the constructor, this line initializes the stack object as a new instance of the Stack class.

// minStack = new Stack<>();: Inside the constructor, this line initializes the minStack object as a new instance of the Stack class.


class MinStack {


    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // condition ? value_if_true : value_if_false
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
