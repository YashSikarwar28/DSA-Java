//LC 103 Zigzag printing using deque and BFS

List<List<Integer>> str=new ArrayList<>();
        if(root==null) return str;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        boolean rev=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ds=new LinkedList<>();
            for(int i=0;i<size;i++){
                if(rev){
                TreeNode t=queue.pollLast();
                ds.add(t.val);
                if(t.right!=null) queue.addFirst(t.right);
                if(t.left!=null) queue.addFirst(t.left);
                }
                else{
                    TreeNode t=queue.pollFirst();
                    ds.add(t.val);
                    if(t.left!=null) queue.addLast(t.left);
                    if(t.right!=null) queue.addLast(t.right);
                }
            }
            rev=!rev;
            str.add(ds);
        }
        return str;