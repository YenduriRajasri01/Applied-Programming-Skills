class Solution {
    int[] st;
    int arr[];
    public void build(int node,int l,int r){
        if(l==r){
            st[node]=0;
            return;
        }
        int mid=l+(r-l)/2;
        build(2*node,l,mid);
        build(2*node+1,mid+1,r);
        st[node]=st[2*node]+st[2*node+1];

    }
    public  void update(int idx,int l,int r,int pos){
        if(l==r){
            st[idx]++;
            return;
        }
        int mid=l+(r-l)/2;
        if(pos<=mid){
            update(2*idx,l,mid,pos);
        } else {
            update(2*idx+1,mid+1,r,pos);
        }
        st[idx]=st[2*idx]+st[2*idx+1];
    }
    private int query(int idx,int sl,int sr,int l,int r){
        if( sl>r || sr<l) return 0;
        if(sl <= l && r <= sr) return st[idx];
        int mid = l+(r-l)/2;
        return query(2*idx,sl,sr,l,mid)+query(2*idx+1,sl,sr,mid+1,r);
    }
     public int sumRange(int left, int right) {
        return query(1,left,right,0,arr.length-1);
    }
    public List<Integer> countSmaller(int[] nums) {

        TreeSet<Integer> set=new TreeSet<>();
        for(int i:nums) set.add(i);
        int n=set.size();
        int[] narr=new int[n];
        int idx=0;
        for(int i:set){
            narr[idx++]=i;
        }
        st=new int[4*n];
        arr=narr;
        build(1,0,n-1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            map.put(narr[i],i);
        }
        int m=nums.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(m, 0));
        for(int i=m-1;i>=0;i--){
            int pos =map.get(nums[i]);
            ans.set(i,sumRange(0,pos-1));
            update(1,0,arr.length-1,pos);
        }
        return ans;
    }
}