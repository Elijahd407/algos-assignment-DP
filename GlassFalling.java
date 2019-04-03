/**
 * Glass Falling
 *Author: Elijah Desrosier
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
	  if (floors == 1 || floors == 0)
          return floors;
      if (sheets == 1)
          return floors;

      int minTrails = Integer.MAX_VALUE, x, res;
      for(x = 1; x <= floors; x++){
    	  res = Math.max(glassFallingRecur(x - 1, sheets - 1), glassFallingRecur(floors - x, sheets));
          if (res < minTrails)
              minTrails = res;
      }

      return minTrails + 1;
  	  
      
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized(int floors, int sheets) {
    // Fill in here and change the return
	  int[][] glassMemo= new int [sheets + 1][floors + 1];
	  int result;
	  
	  for (int i= 1; i<=sheets; i++){
	      glassMemo[0][i] = 1;
	      glassMemo[1][i] = 0;

	    }
	  for(int j = 1;j <= floors; j++) {
		  glassMemo[j][1] = j;
	  }
	  for(int i = 2; i<= sheets; i++) {
		  for(int j = 2; j <= floors; j++) {
			 glassMemo[j][i] = Integer.MAX_VALUE;
			  for(int k = 2; k <= j; k++) {
				  result = 1 + Math.max(glassMemo[k-1][i-1], glassMemo[j-k][i]);
				  if(result < glassMemo[j][i]) {
					  glassMemo[j][i] = result;
				  }
			  }
		  }
	  }
    return glassMemo[floors][sheets];
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
	  if(floors == 1 || floors == 0) {
			return floors;
		}
	  if(sheets == 1) {
			return floors;
		}
	  int minTrails  = Integer.MAX_VALUE;
		int result;
		
		for(int currentFloor = floors; currentFloor >= 2 ; currentFloor--) {

			result = Math.max(glassFallingRecur(currentFloor - 1, sheets - 1), glassFallingRecur(floors - currentFloor, sheets));

			if(result < minTrails) {

				minTrails = result;
			}

		}
		return minTrails + 1;
	}

  


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}
