import java.util.*;

class Main {
  public static List<List<Integer>> permute(int[] nums) {

      List<List<Integer>> perms = new ArrayList<List<Integer>>();
      
      List<Integer> temp = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++){
          temp.add(nums[i]);
      }
      calcPermutations(temp, 0, perms);
      return perms;
  }
  
  private static void swap(List<Integer> arr, int a, int b){
      int temp = arr.get(a);
      arr.set(a, arr.get(b));
      arr.set(b, temp);
  }
  
  private static void calcPermutations(List<Integer> arr, int cid, List<List<Integer>> perms){
      if (cid == arr.size() - 1){        
          List<Integer> temp = new ArrayList<Integer>(arr);
          perms.add(temp);
      }
      else{
          
          for (int i = cid; i < arr.size(); i++){
              swap(arr, i, cid);
              calcPermutations(arr, cid+1, perms);
              swap(arr, i, cid);
          }
      }
  }
  public static void main(String[] args) {
    // int arr = new Integer [5];
    // int arr[] = {1,2,3};
    int[] arr = new int[]{1,2,3};
    System.out.println(permute(arr));
  }
}