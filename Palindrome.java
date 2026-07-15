public class Palindrome {
    public boolean isPalindrome(int x) 
    {
        int result =0;
        int original=x;
        if(x<0)
        {
            return false;
        }
        else
        {
           while(x!=0)
           {
            int pop=x%10;
            x/=10;
            result=(result*10)+pop;
           } 
        }
        if(original ==result)
        {
          return true;
         }
        else
        {
         return false;
         } 
    }
}