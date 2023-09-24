package y23.m09.d09;

import util.MyTreeNode;

/**
 * 给定一颗二叉树的头节点head
 * 返回这颗二叉树中最大的二叉搜索子树的头节点（最大二叉搜索子树的节点数量）
 */

public class MaxBinarySearchSubtree {

    public int maxBinarySearchSubtree(MyTreeNode node){
        if(node == null){
            return 0;
        }
        return process(node).maxBSTsize;
    }

    private static Info process(MyTreeNode x){
        if(x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        boolean isBST;
        int maxBSTsize;
        int max;
        int min;
        if((leftInfo == null ? true : leftInfo.max < x.val)
                && (rightInfo == null ? true : rightInfo.min > x.val)
                && (leftInfo == null ? true : leftInfo.isBST)
                && (rightInfo == null ? true : rightInfo.isBST)){

            isBST = true;
            maxBSTsize = (leftInfo == null ? 0 : leftInfo.maxBSTsize) + (rightInfo == null ? 0 : rightInfo.maxBSTsize) + 1;
            max = (rightInfo == null ? x.val : rightInfo.max);
            min = (leftInfo == null ? x.val : leftInfo.min);

        }else{

            isBST = false;
            maxBSTsize = Math.max((leftInfo == null ? 0 : leftInfo.maxBSTsize),(rightInfo == null ? 0 : rightInfo.maxBSTsize));
            max = Math.max(x.val, Math.max((rightInfo == null ? x.val : rightInfo.max),(leftInfo == null ? x.val : leftInfo.max)));
            min = Math.min(x.val, Math.min((rightInfo == null ? x.val : rightInfo.min),(leftInfo == null ? x.val : leftInfo.min)));

        }
        return new Info(isBST,maxBSTsize,max,min);
    }

    private static class Info{
        boolean isBST;
        int maxBSTsize;
        int max;
        int min;

        Info(){

        }

        public Info(boolean isBST, int maxBSTsize, int max, int min) {
            this.isBST = isBST;
            this.maxBSTsize = maxBSTsize;
            this.max = max;
            this.min = min;
        }
    }

}

