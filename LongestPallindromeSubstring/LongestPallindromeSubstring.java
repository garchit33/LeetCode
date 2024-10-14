public static int getLongestPallindrome(String s){
	
	int result = -404;
	if(s == null || s.length() == 0){
		return result;
	}

	s = s.toLowerCase();

	Map<Character, Integer> vowelsMap = new HashMap<>();
	Map<Character, Integer> consonantsMap = new HashMap<>();

	for(char c : s.toCharArray()){
		if(isVowel(c)){
			vowelsMap.put(c, vowelsMap.getOrDefault(c, 0) + 1);
		}else {
			consonantsMap.put(c, consonantsMap.getOrDefault(c,0) + 1);
		}
	}

	int vowelsCount = getCount(vowelsMap);
	int consonantsCount = getCount(consonantsMap);

	return Math.max(vowelsCount, consonantsCount);
}

private static int getCount(Map<Character, Integer> map){
	PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
	int count = 0;
	boolean flag = false;
	for(Entry<Character, Integer> c : map.entrySet()){
		pq.offer(c.getValue());
	}

	while(pq.size() > 0){
		int x = pq.poll();
		if(x%2 == 0){
			count+=x;
		}else {
			if(!flag){
				count+=x;
				flag = true;
			}else {
				count+=x-1;
			}
		}
	}
	return count;
}

private static boolean isVowel(char c){
	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
		return true;
	}
	return false;
}