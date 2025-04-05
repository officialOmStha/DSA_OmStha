public class Recursion {
    public static int sum(int n){
        if(n ==1){
            return 1;
        }
        else{
            return n + sum(n-1);
        }
    }
    public static void main(String[] args){
        System.out.println("The sum of numbers upto 10 is: "+sum(10));
    }
}
