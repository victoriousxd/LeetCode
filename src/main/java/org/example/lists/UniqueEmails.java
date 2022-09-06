package org.example.lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/unique-email-addresses/
 */

public class UniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        HashMap<String, Set<String>> uniqueEmails = new HashMap<>();

        for (String email : emails) {

            StringBuilder sb = new StringBuilder();
            int i = 0;
            boolean foundLocal = false;
            while (!foundLocal){
                char c = email.charAt(i);

                switch(c){

                    case '+':
                        while (email.charAt(++i) != '@') {}
                    case '@':
                        foundLocal = true;
                        break;
                    case '.':
                        i++;
                        break;
                    default:
                        i++;
                        sb.append(c);

                }

            }

            String domain = email.substring(i+1, email.length()-4);

            if (email.endsWith(".com")){
                Set<String> localList = uniqueEmails.get(domain);
                if (localList == null){
                    localList = new HashSet<String>();
                    uniqueEmails.put(domain, localList);
                }
                localList.add(sb.toString());
            }

        }

        int total = 0;
        for (Set<String> localList : uniqueEmails.values()){
            total += localList.size();
        }
        return total;
    }


}
