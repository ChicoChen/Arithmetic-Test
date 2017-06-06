package ca.dal.types;

public class Addition extends Operation {
	public Addition(int ari, int numOfDig)
    {
        super(ari,numOfDig);
        rightResult1 = arg1 + arg2;
        this.queInString = Integer.toString(this.arg1) 
        		+ " " + Operation.returnSymbol(this.operationalSymbol)
        		+ " " + Integer.toString(this.arg2) + " = ";
    }
}
