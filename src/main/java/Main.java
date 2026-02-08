public class Trees1 {

    public static void main(String[] args) {
        BinNode<Integer> t = buildTree();
        BinNode<Integer> t1 = buildTree1();

        ex1(t);
        System.out.println(ex2(t));
        System.out.println(ex3(t));
        System.out.println(ex4(t));
        
        System.out.println(ex14(t1));
        System.out.println(ex18(t1, t)); 
        System.out.println(ex20(t1));

        // בדיקות לפעולות החדשות
        System.out.println(getHeight(t));
        System.out.println(maxValue(t));
        System.out.println(isPerfect(t));
    }

    public static int getHeight(BinNode<Integer> t) {
        if (t == null)
            return -1;
        return 1 + Math.max(getHeight(t.getLeft()), getHeight(t.getRight()));
    }

    public static int maxValue(BinNode<Integer> t) {
        if (t == null)
            return Integer.MIN_VALUE;
        return Math.max(t.getValue(), Math.max(maxValue(t.getLeft()), maxValue(t.getRight())));
    }

    public static boolean isPerfect(BinNode<Integer> t) {
        if (t == null)
            return true;
        int height = getHeight(t);
        int leaves = ex14(t);
        return leaves == Math.pow(2, height);
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

    public static BinNode<Integer> buildTree1() {
        BinNode<Integer> n1 = new BinNode<>(10);
        BinNode<Integer> n2 = new BinNode<>(-5);
        BinNode<Integer> n3 = new BinNode<>(20);
        n1.setLeft(n2);
        n1.setRight(n3);
        return n1;
    }

    public static int ex14(BinNode<Integer> t) {
        if (t == null)
            return 0;
        if (!t.hasLeft() && !t.hasRight())
            return 1;
        return ex14(t.getLeft()) + ex14(t.getRight());
    }

    public static boolean ex18(BinNode<Integer> t1, BinNode<Integer> t2) {
        if (t2 == null)
            return true;
        if (!contains(t1, t2.getValue()))
            return false;
        return ex18(t1, t2.getLeft()) && ex18(t1, t2.getRight());
    }

    public static boolean contains(BinNode<Integer> t, int val) {
        if (t == null)
            return false;
        if (t.getValue() == val)
            return true;
        return contains(t.getLeft(), val) || contains(t.getRight(), val);
    }

    public static int ex20(BinNode<Integer> t) {
        if (t == null)
            return 0;
        return sumPos(t) - Math.abs(sumNeg(t));
    }

    public static int sumPos(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = (t.getValue() > 0) ? t.getValue() : 0;
        return current + sumPos(t.getLeft()) + sumPos(t.getRight());
    }

    public static int sumNeg(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = (t.getValue() < 0) ? t.getValue() : 0;
        return current + sumNeg(t.getLeft()) + sumNeg(t.getRight());
    }
}
