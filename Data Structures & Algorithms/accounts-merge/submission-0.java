class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailIdToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        // initialise
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i=1;i<account.size();i++) {
                parent.put(account.get(i), account.get(i));
                emailIdToName.put(account.get(i), name);
            }
        }

        // union
        for(List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i=2;i<account.size();i++) {
                union(parent, firstEmail, account.get(i));
            }
        }

        // group
        Map<String, List<String>> groups = new HashMap<>();
        for(String email : parent.keySet()) {
            String root = find(parent, email);
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // result
        List<List<String>> result = new ArrayList<>();
        for(var g : groups.entrySet()) {
            String name = emailIdToName.get(g.getKey());
            List<String> emails = g.getValue();
            Collections.sort(emails);
            emails.add(0, name);
            result.add(emails);
        }
        return result;
    }

    private String find(Map<String, String> parent, String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent, parent.get(email)));
        }
        return parent.get(email);
    }

    private void union(Map<String, String> parent, String parentEmail, String currentEmail) {
        String pp = find(parent, parentEmail);
        String cp = find(parent, currentEmail);
        if (!pp.equals(cp)) {
            parent.put(cp, pp);
        }
    }
}