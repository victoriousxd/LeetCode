package org.example.lists;

import org.example.lists.UniqueEmails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueEmailsTest {

    @Test
    public void testUniqueEmails(){
        String[] emails =new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        Assertions.assertEquals(
                1,
                UniqueEmails.numUniqueEmails(emails));
    }
}
