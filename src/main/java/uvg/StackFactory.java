package uvg;

public class StackFactory {
    public static Stack getStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("Vector")) {
            return new StackVector();
        } else if (stackType.equalsIgnoreCase("ArrayList")) {
            return new StackArrayList();
        } else {
            return new StackList(ListFactory.getList(listType));
        }
    }
}

