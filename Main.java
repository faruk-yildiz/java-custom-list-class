public class Main {
    public static void main(String[] args) {
        MyListClass<Integer> myListClass = new MyListClass<>(20);
        myListClass.addData(2);
        myListClass.addData(3);
        System.out.println(myListClass.getCapacity());
        System.out.println(myListClass.size());
        System.out.println(myListClass.contains(5));
        System.out.println(myListClass.contains(3));
        myListClass.clear();
        System.out.println(myListClass.size());
        System.out.println(myListClass.getCapacity());
        System.out.println(myListClass.isEmpty());
        System.out.println(myListClass);
        myListClass.addData(2);
        myListClass.addData(3);
        myListClass.addData(4);
        myListClass.addData(5);
        myListClass.addData(6);
        myListClass.addData(7);
        myListClass.addData(8);
        System.out.println(myListClass);
        myListClass.remove(2);
        System.out.println(myListClass);


    }
}
