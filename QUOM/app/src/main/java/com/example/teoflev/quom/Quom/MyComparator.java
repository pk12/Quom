package com.example.teoflev.quom.Quom;

import java.util.Comparator;

/**
 * Created by Oppai on 5/27/2017.
 */

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int start = o1.indexOf(":") + 2;
        int start2 = o2.indexOf(":") + 2;
        String sub1 = o1.substring(start);
        String sub2 = o2.substring(start2);

        if (Integer.parseInt(sub1) < Integer.parseInt(sub2))
            return 1;
        else if (Integer.parseInt(sub1) > Integer.parseInt(sub2))
            return -1;
        else
            return 0;
    }
}
