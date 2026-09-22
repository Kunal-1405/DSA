class Solution {
    static class Node {
        int[] remain = new int[5];
        int prod = 1;
    }

    private Node[] tree;
    private int n;
    private int k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        int[] modNums = new int[n];
        for (int i = 0; i < n; i++) {
            modNums[i] = nums[i] % k;
        }

        build(modNums, 0, 0, n - 1);

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1] % k;
            int start = queries[q][2];
            int x = queries[q][3];

            update(0, 0, n - 1, index, value);

            Node res = query(0, 0, n - 1, start, n - 1);
            ans[q] = res.remain[x];
        }

        return ans;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node node = new Node();
        node.prod = (left.prod * right.prod) % k;

        for (int i = 0; i < k; i++) {
            node.remain[i] = left.remain[i];
        }

        for (int i = 0; i < k; i++) {
            int newRem = (i * left.prod) % k;
            node.remain[newRem] += right.remain[i];
        }

        return node;
    }

    private void build(int[] nums, int treeIdx, int lo, int hi) {
        if (lo == hi) {
            tree[treeIdx].remain[nums[lo]] = 1;
            tree[treeIdx].prod = nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(nums, 2 * treeIdx + 1, lo, mid);
        build(nums, 2 * treeIdx + 2, mid + 1, hi);
        tree[treeIdx] = merge(tree[2 * treeIdx + 1], tree[2 * treeIdx + 2]);
    }

    private void update(int treeIdx, int lo, int hi, int idx, int val) {
        if (lo == hi) {
            for (int i = 0; i < k; i++) {
                tree[treeIdx].remain[i] = 0;
            }
            tree[treeIdx].remain[val] = 1;
            tree[treeIdx].prod = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (idx <= mid) {
            update(2 * treeIdx + 1, lo, mid, idx, val);
        } else {
            update(2 * treeIdx + 2, mid + 1, hi, idx, val);
        }
        tree[treeIdx] = merge(tree[2 * treeIdx + 1], tree[2 * treeIdx + 2]);
    }

    private Node query(int treeIdx, int lo, int hi, int ql, int qr) {
        if (ql <= lo && hi <= qr) {
            return tree[treeIdx];
        }
        if (qr < lo || hi < ql) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        Node left = query(2 * treeIdx + 1, lo, mid, ql, qr);
        Node right = query(2 * treeIdx + 2, mid + 1, hi, ql, qr);
        return merge(left, right);
    }
}