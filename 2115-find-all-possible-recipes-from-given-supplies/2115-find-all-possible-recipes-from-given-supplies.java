class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> supp = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        for(int i=0; i<recipes.length; i++){
            indegree.put(recipes[i], ingredients.get(i).size());

            for(String in : ingredients.get(i)){
                List<String> temp = graph.getOrDefault(in, new ArrayList<>());
                temp.add(recipes[i]);
                graph.put(in, temp);
            }
        }

        Queue<String> q = new LinkedList<>(supp);

        while(q.size()>0){
            String rm = q.poll();
            if(!graph.containsKey(rm))
                continue;

            for(String recipe : graph.get(rm)){
                indegree.put(recipe, indegree.get(recipe)-1);
                if(indegree.get(recipe) == 0){
                    q.offer(recipe);
                    result.add(recipe);
                }
            }
        }

        return result;
    }
}