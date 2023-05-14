public class MyClass {
    private int value;

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        MyClass object1 = new MyClass();
        MyClass object2 = new MyClass();

        object1.setValue(10);
        System.out.println("Value of object1: " + object1.getValue()); // Output: 10
        System.out.println("Value of object2: " + object2.getValue()); // Output: 10

        object2.setValue(20);
        System.out.println("Value of object1: " + object1.getValue()); // Output: 20
        System.out.println("Value of object2: " + object2.getValue()); // Output: 20
    }
}