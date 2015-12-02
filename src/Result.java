import java.math.BigInteger;


public class Result {
	public BigInteger[] bob;
	
	public Result() {
		this.bob = new BigInteger[126];
		for (int i = 0; i<126;i++) {
			this.bob[i] = new BigInteger("0");
		}
	}
	
	public BigInteger get(int i) {
		return this.bob[i];
	}
	
	public void set(int i) {
		this.bob[i] = this.bob[i].add(BigInteger.ONE);
	}
	
	public BigInteger total() {
		BigInteger res = new BigInteger("0");
		for (BigInteger B : this.bob) {
			res = res.add(B);
		}
		return res;
	}
}
