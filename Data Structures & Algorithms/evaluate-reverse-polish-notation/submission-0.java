class Solution {
    public int evalRPN(String[] tokens) {
        int stack[]=new int[tokens.length];
        int top=-1;
        int sum=0;
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int op1=stack[top--];
                int op2=stack[top--];
                if(token.equals("+")){
                   sum=op1+op2;
                    stack[++top]=sum;
                }
                else if(token.equals("-")){
                    sum=op2-op1;
                    stack[++top]=sum;
                }
                else if(token.equals("*")){
                    sum=op1*op2;
                    stack[++top]=sum;
                }
                else{
                    sum=op2/op1;
                    stack[++top]=sum;
                }
            }
            else{
                stack[++top]=Integer.parseInt(token);
            }
        }
        sum=stack[top];
        return sum;
    }
}