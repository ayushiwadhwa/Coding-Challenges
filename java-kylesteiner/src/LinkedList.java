import java.util.HashMap;
import java.util.Map;

public class LinkedList {
	/*
	 * Problem 1
	 * Runtime: O(n)
	 * Memory: O(n)
	 */
	public static void removeDuplicates(LLNode node) {
		Map<Integer, Boolean> nodes = new HashMap<Integer, Boolean>();
		LLNode cur = node;
		while (cur != null && cur.next != null) {
			if (nodes.containsKey(cur.next.data)) {
				cur.next = cur.next.next;
			} else {
				nodes.put(cur.data, true);
			}
			cur = cur.next;
		}
	}

	/*
	 * Problem 2
	 * Runtime: O(n)
	 */
	public static LLNode KthFromLast(LLNode node, int k) {
		if (k <= 0) return null;

		LLNode front = node;
		LLNode back = node;

		// Set front and back pointers
		int diff = 0;
		while (back != null && diff++ < k - 1) {
			back = back.next;
		}
		if (back == null) return null;

		// Shift front and back pointers until end of LinkedLIst
		while (back != null) {
			back = back.next;
			front = front.next;
		}
		return front;
	}

	/*
	 * Problem 3
	 * Runtime: O(n)
	 */
	public static void deleteNode(LLNode n, LLNode list) {
		if (n == null || list == null) {
			return;
		} else if (list == n) {
			list = list.next;
			return;
		}

		LLNode prev = list;
		LLNode cur = list.next;
		while (cur != null) {
			if (cur == n) {
				prev.next = cur.next;
				return;
			}
			prev = prev.next;
			cur = cur.next;
		}
	}

	/*
	 * Problem 4
	 * O(n)
	 */
	public static void partition(int x, LLNode list) {
		if (list == null) return;
		LLNode lt = null;
		LLNode gte = null;
		LLNode cur = list;
		while (cur != null) {
			LLNode next = cur.next;
			if (cur.data < x) {
				if (lt == null) {
					lt = cur;
				} else {
					lt.next = cur;
				}
			} else {
				if (gte == null) {
					lt = cur;
				} else {
					lt.next = cur;
				}
			}
			cur.next = null;
			cur = next;
		}
		list = lt;
		lt.next = gte;
	}

	/*
	 * Problem 5
	 */
	public static LLNode sum(LLNode list1, LLNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		LLNode sum = new LLNode();
		LLNode curSum = sum;
		int carry = 0;
		LLNode cur1 = list1;
		LLNode cur2 = list2;
		while (cur1 != null && cur2 != null) {
			int digit = (cur1.data + cur2.data + carry) % 10;
			carry = (cur1.data + cur2.data + carry) / 10;
			newNodeToSum(curSum, digit);
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		while (cur1 != null) {
			newNodeToSum(curSum, cur1.data);
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			newNodeToSum(curSum, cur2.data);
			cur2 = cur2.next;
		}
		return sum;
	}

	private static void newNodeToSum(LLNode node, int digit) {
		if (node.data == null) {
			node.data = digit;
		} else {
			node.next = new LLNode();
			node.next.data = digit;
			node = node.next;
		}
	}

	/*
	 * Problem 6
	 */
	public static LLNode loopStart(LLNode start) {
		LLNode fast = start;
		LLNode slow = start;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) break;
		}
		if (fast == null || fast.next == null) return null;

		slow = start;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
