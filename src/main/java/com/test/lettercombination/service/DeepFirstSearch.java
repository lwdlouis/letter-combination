package com.test.lettercombination.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class DeepFirstSearch {

    private Map<Integer, String[]> letters;

    private List<String> result = new ArrayList<>();

    public DeepFirstSearch() {
        this.letters = new HashMap<>();

        letters.put(0, new String[]{});
        letters.put(1, new String[]{});
        letters.put(2, new String[]{"a", "b", "c"});
        letters.put(3, new String[]{"d", "e", "f"});
        letters.put(4, new String[]{"g", "i", "j"});

        letters.put(9, new String[]{"w", "x", "y", "z"});
    }

    public static void main(String[] args) {

        DeepFirstSearch dfs = new DeepFirstSearch();

        Integer[] input1 = {2, 1, 9};

        dfs.sum(input1);

        dfs.getResult().stream().forEach(r -> System.out.print(r + ","));

    }



    public void sum(Integer[] input) {

        String temp = "";

        dfs(input, 1, temp);

    }

    public void dfs(Integer[] input, int level, String combination) {

        String[] ls = letters.get(input[level - 1]);

        if (input.length > level) {
            int newLevel = level + 1;
            String ctemp = combination;

            if (ls.length > 0) {
                for (String l : ls) {
                    ctemp = combination + l;
                    dfs(input, newLevel, ctemp);
                }
            } else {
                dfs(input, newLevel, ctemp);
            }


        }

        if (input.length == level) {

            String ctemp = combination;
            if (ls.length > 0) {
                for (String l : ls) {
                    result.add(ctemp + l);
                }
            } else {
                result.add(ctemp);
            }

        }

    }
}
