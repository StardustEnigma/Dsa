class Solution {
    public String evaluate(String s, List<List<String>> grid) {
        Map<String,String> map=new HashMap<>();

        for (int i = 0; i < grid.size(); i++) {
            map.put(grid.get(i).get(0), grid.get(i).get(1));
        }
        StringBuilder curr= new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '(') {

            String key = "";
            int j=0;
            for ( j = i + 1; s.charAt(j) != ')'; j++) {
                key = key + s.charAt(j);
                
            }
            i=j;
        curr.append(map.getOrDefault(key,"?"));
        }
        else{
            curr.append(s.charAt(i));
        }
    }
    return curr.toString();
    }
}