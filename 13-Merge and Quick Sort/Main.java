//Triangle pattern using recursion

public class Main {
    public static void main(String[] args) {
        triangle(4, 0);
    }
    static void triangle(int r,int c){
        if (r==0) { 
            return;
        }
        if (c<r) {
            triangle(r,c+1);
            System.out.print("*");
        }
        else{
            triangle(r-1, 0); // we are starting from top row thats why we did r-1
            System.out.println();
        }
    }
}