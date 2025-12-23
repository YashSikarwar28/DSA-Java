//Maze Problem - counting the number of way to reach the destination and printing the path

public class p1 {
    public static void main(String[] args) {
        //System.out.println(count(3, 3));
        path("", 3, 3);
    }
    static int count(int row,int col){
        if (row==1 || col==1) {
            return 1;
        }
        int right=count(row-1,col);
        int down=count(row, col-1);
        return right+down;
    }
    
    static void path(String s,int r,int c){
        if (r==1 && c==1) {
            System.out.println(s);
            return;
        }
        if (r>1) {
            path(s+"R", r-1, c);
        }
        if (c>1) {
            path(s+"C", r, c-1);
        }
    }
}
