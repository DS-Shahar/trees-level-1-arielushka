
public class Trees1 {

    public static void main(String[] args) {
        BinNode<Integer> t = buildTree();
        ex1(t);
        System.out.println(ex2(t));
        System.out.println(ex3(t));
        System.out.println(ex4(t));
    }

    public static BinNode<Integer> buildTree() {
        BinNode<Integer> n1 = new BinNode<>(2);
        BinNode<Integer> n2 = new BinNode<>(4);
        BinNode<Integer> n3 = new BinNode<>(6);
        n1.setLeft(n2);
        n1.setRight(n3);
        return n1;
    }

    public static void ex1(BinNode<Integer> t) {
        if (t == null) 
            return;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            System.out.println(t.getValue());
        ex1(t.getLeft());
        ex1(t.getRight());
    }

    public static int ex2(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int count = 0;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            count = 1;
        return count + ex2(t.getLeft()) + ex2(t.getRight());
    }

    public static boolean ex3(BinNode<Integer> t) {
        if (t == null) 
            return false;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            return true;
        return ex3(t.getLeft()) || ex3(t.getRight());
    }

    public static boolean ex4(BinNode<Integer> t) {
        if (t == null) 
            return true;
        if (t.getValue() % 2 != 0 || hasOddChild(t)) 
            return false;
        return ex4(t.getLeft()) && ex4(t.getRight());
    }

    public static boolean hasOddChild(BinNode<Integer> t) {
        if (t.hasLeft() && t.getLeft().getValue() % 2 != 0)
            return true;
        if (t.hasRight() && t.getRight().getValue() % 2 != 0) 
            return true;
        return false;
    }
}
