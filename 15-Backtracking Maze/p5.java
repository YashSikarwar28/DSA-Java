//Make a change, reverse the change when the work is done -> this is backtracking
//Now you can go in all the four directions

public class p5 {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        allPath("", 0, 0, maze);
    }

    static void allPath(String s, int r, int c, boolean[][] maze) {
        if (r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(s);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // when we have visited that particular cell we will mark it as false
        maze[r][c] = false;
        if (r < maze.length-1) {
            allPath(s + "D", r+1, c, maze);
        }
        if (c < maze[0].length-1) {
            allPath(s + "R", r, c+1, maze);
        }
        // going left
        if (c > 0) {
            allPath(s + "L", r, c - 1, maze);
        }
        // going up
        if (r > 0) {
            allPath(s + "U", r - 1, c, maze);
        }
        maze[r][c] = true;
        // when going back we mark it as true so we can use in future
    }
}
