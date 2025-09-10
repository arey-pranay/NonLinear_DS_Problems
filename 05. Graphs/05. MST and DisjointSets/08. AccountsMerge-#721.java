class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, ArrayList<Node>> adj = new HashMap<>();

        // Build adjacency list
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                adj.putIfAbsent(email, new ArrayList<Node>());
                for (int j = 1; j < list.size(); j++) {
                    String neighbourEmail = list.get(j);
                    adj.get(email).add(new Node(name, neighbourEmail));
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();

        for (String email : adj.keySet()) {
            if (visited.contains(email)) continue;

            HashSet<String> hs = new HashSet<>();
            String[] name = new String[1]; // use array to pass by reference
            dfs(email, adj, visited, hs, name);

            List<String> curr = new ArrayList<>(hs);
            Collections.sort(curr);
            curr.add(0, name[0]); // add name at the beginning
            ans.add(curr);
        }

        return ans;
    }

    public void dfs(String email, HashMap<String, ArrayList<Node>> adj, HashSet<String> visited, HashSet<String> hs, String[] name) {
        visited.add(email);
        hs.add(email);

        for (Node n : adj.getOrDefault(email, new ArrayList<Node>())) {
            if (name[0] == null) name[0] = n.name; // store name once
            if (!visited.contains(n.email)) {
                dfs(n.email, adj, visited, hs, name);
            }
        }
    }

    class Node {
        String name;
        String email;
        Node(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}


// class Solution {
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         int n = accounts.size();
//         DisjointSet ds = new DisjointSet(n);
//         HashMap<String, Integer> map = new HashMap<>();

//         for(int i = 0; i < n; i++){
//             for(int j = 1; j < accounts.get(i).size(); j++){
//                 String mail = accounts.get(i).get(j);
//                 if(map.containsKey(mail)){
//                     ds.unionBySize(i, map.get(mail));
//                 }else{
//                     map.put(mail, i);
//                 }
//             }
//         }

//         ArrayList<String>[] mergedMail = new ArrayList[n];
//         for(int i = 0; i < n; i++){
//             mergedMail[i] = new ArrayList<>();
//         }
//         for(String key: map.keySet()){
//             int node = map.get(key);
//             int ultp = ds.findUParent(node);
//             mergedMail[ultp].add(key);
//         }

//         List<List<String>> ans = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             if(mergedMail[i].size() == 0) continue;
//             List<String> cur = new ArrayList<>();
//             Collections.sort(mergedMail[i]);
//             cur.add(accounts.get(i).get(0));
//             for(String mail: mergedMail[i]){
//                 cur.add(mail);
//             }
//             ans.add(cur);
//         }
//         return ans;
//     }
// }


// class DisjointSet{
//     int size[];
//     int parent[];
//     DisjointSet(int n){
//         size = new int[n + 1];
//         parent = new int[n + 1];
//         for(int i = 0; i <= n; i++){
//             size[i] = 1;
//             parent[i] = i;
//         }
//     }

//     int findUParent(int node){
//         if(parent[node] == node) return node;
//         return parent[node] = findUParent(parent[node]);
//     }

//     void unionBySize(int u, int v){
//         int ult_u = findUParent(u);
//         int ult_v = findUParent(v);
//         if(ult_u == ult_v) return;
//         if(size[ult_u] > size[ult_v]){
//             size[ult_u] += size[ult_v];
//             parent[ult_v] = ult_u;
//         }else{
//             size[ult_v] += size[ult_u];
//             parent[ult_u] = ult_v;
//         }
//     }
// }
