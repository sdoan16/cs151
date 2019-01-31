public class Strings
{
	public static String uniqueLetters(String s)
	{
		String unique = "";
		
		for(int i=0; i < s.length(); i++)
		{
			int cnt = 0;
			for(int j=0; j < s.length(); j++)
			{
				if(s.charAt(j) == s.charAt(i))
				{
					cnt++;
				}
				
			}
			if(cnt == 1)
			{
				unique = unique + String.valueOf(s.charAt(i));
			}
			
		}
		return unique;
	}
	public static void main(String[] args)
	{
		System.out.println(uniqueLetters("harrasses"));
		System.out.println(uniqueLetters("banana"));
	}

}
