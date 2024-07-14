class Solution {
    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0, n = formula.length();

        while(i < n){
            char ch = formula.charAt(i);
            if(Character.isAlphabetic(ch)){
                StringBuilder cur = new StringBuilder();
                cur.append(ch);
                int j = i + 1;
                int count = 0;
                while(j < n && Character.isLowerCase(formula.charAt(j))){
                    cur.append(formula.charAt(j));
                    j++;
                }
                while(j < n && Character.isDigit(formula.charAt(j))){
                    count = count * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                count = count > 0 ? count : 1;
                String s = cur.toString();
                map.put(s, map.getOrDefault(s, 0) + count);
                i = j;
            }else if(ch == '('){
                stack.push(map);
                map = new HashMap<>();
                i++;
            }else{
                int count = 0;
                int j = i + 1;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    count = count * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                count = count > 0 ? count : 1;
                if(!stack.isEmpty()){
                    Map<String, Integer> prev = stack.pop();
                    for(Map.Entry<String, Integer> v : map.entrySet()){
                        prev.put(v.getKey(), prev.getOrDefault(v.getKey(), 0) + (count * v.getValue()));
                    }
                    map = prev;
                }else if(count > 1){
                    for(Map.Entry<String, Integer> v : map.entrySet()){
                        map.put(v.getKey(), v.getValue() * count);
                    }
                }
                i = j;
            }
        }
        while(!stack.isEmpty()){
            Map<String, Integer> prev = stack.pop();
            for(Map.Entry<String, Integer> v : map.entrySet()){
                prev.put(v.getKey(), prev.getOrDefault(v.getKey(), 0) + v.getValue());
            }
            map = prev;
        }

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> k = new TreeMap<>(map);
        for(Map.Entry<String, Integer> val : k.entrySet()){
            sb.append(val.getKey());
            int c = val.getValue();
            if(c > 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}