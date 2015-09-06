package member.register;
public class IDChecker {
	
	public String str="";

	private int D0(){
		int D00=0;
		int temp = this.str.codePointAt(0);

		if(72>=temp && temp>=65)
		{
			D00 = temp-55;
		}else if(78>=temp&&temp>=74){	
			D00 = temp-56;
		}else if(86>=temp&&temp>=80){
			D00 = temp-57;
		}else if(90>=temp&&temp>=88)
		{
			D00 =temp-58;
		}
		switch(temp){
		case 74 :
			D00 =temp-39;
		
		case 79 :
			D00 =temp-44;
			break;
		
		case 87 :
			D00 =temp-55;
			break;
		default:
			break;
		}
		
		if(104>=temp && temp>=97)
		{
			D00 = temp-87;
		}else if(110>=temp&&temp>=106){	
			D00 = temp-88;
		}else if(118>=temp&&temp>=112){
			D00 = temp-89;
		}else if(122>=temp&&temp>=120)
		{
			D00 =temp-90;
		}
		switch(temp){
		case 106 :
			D00 =temp-71;
		
		case 111 :
			D00 =temp-76;
			break;
		
		case 119 :
			D00 =temp-87;
			break;
		default:
			break;
		}			
		return D00;
	}


	private int DNumber(int i){
		int D1=100;
		//D1 is used to checked the character is 0~9 or not, so the initial value should not be 0~9
		int temp = this.str.codePointAt(i);
		//use variable to determine the code of the i-th character of the string
		if(57>=temp&&temp>=48){
			D1=temp-48;
		}
		return D1;
	}
	
	
	public boolean CheakID(){
		

		IDChecker id= new IDChecker(this.str);
		int[] D= new int[10];
		

		if(str==null || str.length()!=10){
			return false;
		}
		if(!(id.D0()!=0&&id.DNumber(1)>0&&id.DNumber(1)<3)){
			return false;
		}						
		//put the first code and the second code
		D[0] =id.D0();
		D[1] =id.DNumber(1);					
		//the other word is 0-9
		for(int k=2;k<10;k++){
			if(!(id.DNumber(k)>=0&&id.DNumber(k)<=9))
			{
				return false;
			}
		
			D[k] =id.DNumber(k);
		}
		//compute id checkcode

		
		int cheakCode =0;
		
		cheakCode=(10-(id.CheckCode(D)%10))%10;
			if(cheakCode!=D[9]){
				return false;
			}
		
		return true;
	}
	
	
	private int CheckCode(int[] X){
	
		int x1=Math.floorDiv(X[0],10);
		int x2=X[0]%10;
		
		
		int Y=x1+(9*x2)+(8*X[1]);
			for(int i=2;i<=8;i++){
				Y=(9-i)*X[i]+Y;
			}		
		return Y;
	}
	
	
	//random a ID number
	public static String IDRandom(){
		
		char[] idByChar = new char[9];
		
		String iDString = "";
					
			//create A-Z
			int x = (int)Math.floor(Math.random()*26+65);
			idByChar[0] = (char) x;
			
			//create 1-2
			idByChar[1] = (char)(int)Math.floor(Math.random()*2+49);
			
			//create the other numbers, which is 0-9
			for (int i=2;i<9;i++){
				idByChar[i] = (char)(int)Math.floor(Math.random()*10+48);
			}			

			iDString = new String(idByChar);
			IDChecker id = new IDChecker(iDString);
			int[] temp = new int[10];
			temp[0]= id.D0();
			
			for(int i=1;i<9;i++){
				temp[i]=id.DNumber(i);	
			}
			temp[9]=(10-(id.CheckCode(temp)%10))%10;
			iDString = iDString+temp[9];
			
		return iDString;
	}
	
	public IDChecker(String s){
		this.str=s;
	}
	public IDChecker(){
		
	}
	
	
}
