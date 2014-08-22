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
}
