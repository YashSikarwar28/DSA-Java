import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        // Scanner scanner=new Scanner(System.in);
        // Main tree=new Main();
        // tree.populate(scanner);
        // tree.display();
        
        //BST
        BST tree=new BST();
        int[] nums={4,2,7,4,3,2,8,6,5,1};
        tree.populate(nums);
        tree.display();
    }
}
