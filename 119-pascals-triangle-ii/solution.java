class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j=1; j<i; j++){
                List<Integer> prev = ans.get(i-1);
                row.add(prev.get(j-1)+ prev.get(j));
            }
            if(i>0)
                row.add(1);
            ans.add(row);
        }
        return ans.get(rowIndex);
    }
}