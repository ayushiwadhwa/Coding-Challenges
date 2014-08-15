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
}
