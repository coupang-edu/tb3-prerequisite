package project1.week1;

public class RightTriangle 
{
    public static void main(String[] args) { 
        Integer a = Integer.parseInt(args[0]);
        Integer b = Integer.parseInt(args[1]);
        Integer c = Integer.parseInt(args[2]);
        Integer max_int = Math.max(a,b);
        max_int = Math.max(max_int, c);
        Integer left = a*a + b*b + c*c - max_int * max_int;
        Boolean ret = (left==max_int * max_int)? true : false;
        System.out.println(ret);
    }
}