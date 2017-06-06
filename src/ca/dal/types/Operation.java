package ca.dal.types;

public abstract class Operation {
	protected int operationalSymbol;  
	protected int arg1;               // argument 1
	protected int arg2;               // argument 2
	protected int rightResult1;       // right result
	protected int userResult1;        // user result
	protected int numOfDig;
	protected String queInString;
    public Operation(int ari, int numOfDig)
    {
        operationalSymbol = ari;//mark
        arg1 = (int)(Math.random()*Math.pow(10, numOfDig));
        arg2 = (int)(Math.random()*Math.pow(10, numOfDig));
        rightResult1 = 0;
        userResult1 = 0;
        this.numOfDig = numOfDig;
        this.queInString = Integer.toString(this.arg1)
        		+ " " + this.returnSymbol(this.operationalSymbol) 
        		+ " " + Integer.toString(this.arg2) + " = ";
    }
    
    public String showQuestionsString()
    {
        String temp;
        temp = Integer.toString(arg1) + returnSymbol(operationalSymbol) + Integer.toString(arg2);
        return temp;
    }
    
    public String outputAnswerString()
    {
        String temp;
        if(this.userResult1 != -1){
            temp = "Your  Answers:" + showQuestionsString();
            temp = temp +" = "+ Integer.toString(userResult1);
        } else {
            temp = "Your  Answers:" + showQuestionsString();
            temp = temp + " = " + "empty";
        }
        temp = temp + "    Right Answers:" + showQuestionsString();
        temp = temp +" = " + Integer.toString(rightResult1) + "\n";

        return temp;
    }
    
    public boolean judge()
    {
        return (userResult1 == rightResult1);
    }
    
    // return the index of symbol
    public int randomArithmetic(String s)
    {
        if(s.equals("+"))
            return 1;
        if(s.equals("-"))
            return 2;
        if(s.equals("x"))
            return 3;
        if(s.equals("/"))
            return 4;
        // return random number between 1~4 if type in 'r'
        if(s.equals("r"))
            return ((int)(Math.random()*4)+1);
        return 0;
    }
    
    // return symbol
    public static String returnSymbol(int ari)
    {
        if(ari == 1)
            return "+";
        else if(ari == 2)
            return "-";
        else if(ari == 3)
            return "x";
        else if(ari == 4)
            return "/";
        return null;
    }
    public int getOperationalSymbol() {
        return operationalSymbol;
    }
    public int getArg1() {
        return arg1;
    }
    public int getArg2() {
        return arg2;
    }
    public int getRightResult1() {
        return rightResult1;
    }
    public int getUserResult1() {
        return userResult1;
    }
    public int getNumOfDig() {
        return numOfDig;
    }
    public String getQueInString() {
        return queInString;
    }
    public void setRightResult1(int rightResult1) {
        this.rightResult1 = rightResult1;
    }
    public void setUserResult1(int userResult1) {
        this.userResult1 = userResult1;
    }
    public int getRightResult2() {
        return 0;
    }
    public int getUserResult2() {
        return 0;
    }
    public void setRightResult2(int rightResult2) {
        //
    }
    public void setUserResult2(int userResult2) {
        //
    }
    
}
