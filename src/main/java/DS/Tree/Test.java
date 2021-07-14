package DS.Tree;

public class Test {
    int value;

    @Override
    public boolean equals(Object o){
        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
    Test test=new Test();

    Test test2=new Test();
    test.value=1;
    test2.value=2;
        System.out.println(test.value);
        System.out.println(test2.value);
    }
}
