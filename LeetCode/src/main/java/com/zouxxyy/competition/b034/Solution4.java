package com.zouxxyy.competition.b034;

/**
 * @author zxy
 */
public class Solution4 {

    private static final int MOD  = 1000000007;

    private int res;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        dfs(locations, start, fuel, finish);
        return res;

    }

    private void dfs(int[] locations, int start, int fuel, int cur) {

        if (fuel < 0) {
            return;
        }

        if (cur != start && Math.abs(locations[cur] - locations[start]) <= fuel) {
            res ++;
            res %= MOD;
        }

        for (int i = 0; i < locations.length; i++) {
            if (i != cur) {
                dfs(locations, start, fuel - Math.abs(locations[cur] - locations[i]), locations[i]);
            }
        }


    }

}
