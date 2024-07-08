class Solution {
    int last_alive=0;
    public int findTheWinner(int n, int k) {
        int index=0;
        k--;
        int temp;
        List<Integer> person = new LinkedList<Integer>();
        int i;
        for(i=1;i<=n;i++)
        {
            person.add(i);
        }
        person_alive(person,k,index);
        return last_alive;
    }
    public void person_alive(List<Integer> person,int k,int index)
    {
        if(person.size()==1)
        {
            last_alive=person.get(0);
            return ;
        }
        index = ((index+k)%person.size());
        person.remove(index);
        person_alive(person,k,index);

    }
}