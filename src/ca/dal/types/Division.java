package ca.dal.types;

public class Division extends Operation {
	int rightResult2;
    int userResult2;
    public Division(int ari, int numOfDig)
    {
        super(ari, numOfDig);
        arg2 = (int)(Math.random()*(Math.pow(10, numOfDig) - 1) + 1);
        rightResult1 = arg1 / arg2;
        rightResult2 = arg1 % arg2;
        userResult2 = 0;
        this.queInString = Integer.toString(this.arg1)
        		+ " " + Operation.returnSymbol(this.operationalSymbol)
        		+ " " + Integer.toString(this.arg2) + " = ";
    }
    public boolean judge()
    {
        return (userResult1 == rightResult1 && userResult2 == rightResult2);
    }
    
    public String outputAnswerString()
    {
        String temp;
        temp = "Your  Answers:" + showQuestionsString();
        temp = temp + " = ";
        if(this.userResult1 != -1){
            temp = temp + Integer.toString(userResult1);
        } else {
            temp = temp + "empty";
        }
        if(this.userResult2 != -1){
            temp = temp + "..." + Integer.toString(userResult2);
        } else {
            temp = temp + "..." + "empty";
        }
        
        temp = temp + "    Right Answers:" + showQuestionsString();
        temp = temp + " = ";
        temp = temp + Integer.toString(rightResult1) + "..." + Integer.toString(rightResult2)+"\n";
        return temp;
    }
    public int getRightResult2() {
        return rightResult2;
    }
    public void setRightResult2(int rightResult2) {
        this.rightResult2 = rightResult2;
    }
    public int getUserResult2() {
        return userResult2;
    }
    public void setUserResult2(int userResult2) {
        this.userResult2 = userResult2;
    }
    
}
