package ca.dal.types;

public class Substraction extends Operation {
	public Substraction(int ari, int numOfDig)
    {
        super(ari, numOfDig);
        if(arg1 < arg2)
        {
            int temp = arg1;
            arg1 = arg2;
            arg2 = temp;
        }
        rightResult1 = arg1 - arg2;
        this.queInString = Integer.toString(this.arg1)
        		+ " " + Operation.returnSymbol(this.operationalSymbol)
        		+ " " + Integer.toString(this.arg2) + " = ";
    }
}
