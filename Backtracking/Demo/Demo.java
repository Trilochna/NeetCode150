public class Main
{
    
    public static void printPermutation(String str, String perm, int index){
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char currCharacter = str.charAt(i);
            // because already used character channot be used again
            // compute other characters
            String newString = str.substring(0, i) + str.substring(i + 1);
            // now ass we have solved one problem 
            // use recursion
            printPermutation(newString, perm + currCharacter, index + 1);
        }    
    }
    
	public static void main(String[] args) {
		String str = "ABC";
		printPermutation(str, "", 0);
	}
}


