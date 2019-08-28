package exam.NiuKe.快手;
import java.util.ArrayList;
import java.util.LinkedList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class ddasda {
    public   void solution(TreeNode pRoot) {
        ArrayList<ArrayList<TreeNode>> linkresult=new ArrayList<>();

        LinkedList<TreeNode> link=new LinkedList<>();
        LinkedList<TreeNode> link2=new LinkedList<>();
        if(pRoot.left!=null){
            link.add(pRoot.left);
        }
        if(pRoot.right!=null){
            link.add(pRoot.right);
        }

        while(!link.isEmpty() || !link2.isEmpty()  ){
            linkresult.add(new ArrayList<>(link));
            while(!link.isEmpty() ){
                TreeNode temp=link.poll();
                if(temp.left!=null){
                    link2.add(temp.left);
                }
                if(temp.right!=null){
                    link2.add(temp.right);
                }
            }
            linkresult.add(new ArrayList<>(link2));
            while(link.isEmpty() && !link2.isEmpty()){
                TreeNode temp2=link2.poll();
                if(temp2.left!=null){
                    link.add(temp2.left);
                }
                if(temp2.right!=null){
                    link.add(temp2.right);
                }
            }

        }

    }
}
