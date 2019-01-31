import java.util.Set;
import java.util.TreeSet;
import java.util.*;

public class Encoding
{
	public static Set<String> morseCodes(int m, int n)
	{
		Set<String> result = new TreeSet<>();
		gen(m,n,"", result);
		return result;
	  
	}
	public static void gen(int m, int n, String gen, Set<String> result)
	{
		if(m==0&&n==0)
		{
			result.add(gen);
			return;
		}
		if(m==0)
		{
			gen(m,n-1,gen+"-",result);
			return;
		}

		if(n==0)
		{
			gen(m-1,n,gen+".",result);
			return;
		}
		
		gen(m-1,n,gen+".",result);
		gen(m,n-1,gen+"-",result);
	}
}

