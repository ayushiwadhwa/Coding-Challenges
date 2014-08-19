import java.util.HashMap;
import java.util.Map;

public class LinkedList {
	/*
	 * Problem 1
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
}
