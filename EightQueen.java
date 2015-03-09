import java.util.Arrays;
public class EightQueen {
	static int counter = 0;
	public static boolean noSameRow(int[] qs , int index, int pos){
		for(int i = 0; i < index; i ++){
			if (qs[i] == pos) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean noSameDia(int[] qs, int index, int pos){
		for(int i = 0; i < index; i ++){
			if (Math.abs(qs[i]-pos) == index - i){
				return false;
			}
		}
		return true;		
	}
	
	public static boolean isSafe(int[] qs, int index, int pos){
		return (noSameRow(qs,index,pos) && noSameDia(qs,index,pos));
	}
	public static void place(int[] qs, int col){
		if(col == qs.length - 1){
			for(int i = 0 ; i < qs.length ; i ++){
				if(isSafe(qs, col, i)){
					qs[col] = i; 
					counter ++;
					System.out.println(Arrays.toString(qs));
				}
			}
		}
		else{
			for(int p = 0 ; p < qs.length ; p++){
				if(isSafe(qs, col, p)){
					qs[col] = p; 
					place(qs,col+1);
				}
			}
		}
	}
	public static void main(String[] args){
		int[] queens =  new int[] {0,0,0,0,0,0,0,0};
		place(queens, 0);
		System.out.println(counter);
	}
}
