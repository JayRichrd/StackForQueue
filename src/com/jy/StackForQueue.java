package com.jy;

import java.util.ArrayDeque;

/**
 * 用两个栈实现的队列
 * 
 * @author jiangyu
 *
 * @param <E>
 */
public class StackForQueue<E> {
	// 定义两个栈
	private ArrayDeque<E> stack1 = new ArrayDeque<>();
	private ArrayDeque<E> stack2 = new ArrayDeque<>();

	/**
	 * 在队尾插入
	 * 
	 * @param e
	 *            待插入的元素
	 */
	public void appendTail(E e) {
		stack1.push(e);
	}

	/**
	 * 在队头删除
	 * 
	 * @return 对头待删除的元素
	 */
	public E deleteHead() {
		// 当stack2位空时，将stack中的元素全部出栈并压如stack2中
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		// 当将stack1中的元素全部出栈并压入stack2中后，再次检查stack2是否为空
		if (stack2.isEmpty())
			throw new RuntimeException("Queue is empty!");
		// 返回stack2栈顶的元素
		return stack2.pop();
	}
}
