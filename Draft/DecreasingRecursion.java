class DecreasingRecursion {
    static void printNum(int num) {
        System.out.println(num);
        if(num > 0) {
            printNum(num - 1);
        }
    }
    public static void main(String args[]) {
        printNum(3);
    }
}
