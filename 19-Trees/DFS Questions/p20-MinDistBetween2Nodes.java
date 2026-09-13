//GFG
//The approach is quite straight forward. Find the lca for both nodes and from that lca find the distance to both the nodes and add the distance.
//Have a look at the distance function the lca is exactly the same.
//For distance our approach is that we will go in left and right and on the side we find the node on that side the value will become zero as per the condition, when value will become zero we will increase the count of that particular side.
class Solution {
	public int findDist(Node root, int a, int b) {
		Node ll = lca(root, a, b);
		int d1 = dist1(ll, a);
		int d2 = dist2(ll, b);
		return d1 + d2;
	}
	private Node lca(Node root, int a, int b) {
		if (root == null)
			return null;
		if (root.data == a || root.data == b)
			return root;
		Node l = lca(root.left, a, b);
		Node r = lca(root.right, a, b);
		if (l != null && r != null)
			return root;
		return (l == null)?r:l;
	}
	private int dist1(Node ll, int a) {
		if (ll == null)
			return -1;
		if (ll.data == a)
			return 0;
		int left = dist1(ll.left, a);
		if (left != -1) {
			return left + 1;
		}
		int right = dist1(ll.right, a);
		if (right != -1) {
			return right + 1;
		}
		return - 1;
	}
	private int dist2(Node ll, int b) {
		if (ll == null)
			return - 1;
		if (ll.data == b)
			return 0;
		int left = dist2(ll.left, b);
		if (left != -1) {
			return left + 1;
		}
		int right = dist2(ll.right, b);
		if (right != -1) {
			return right + 1;
		}
		return - 1;
	}
}
