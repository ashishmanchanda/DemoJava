package neetcodequestions.trees.backtracking;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

class Combination {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList();
        List<String> result = new ArrayList<>();
        String[] mappings = {"", "", "abc",
                "def", "ghi", "jkl", "mno", "pars", "tuv", "wxyz"};
        result.add("");
        for (char d : digits.toCharArray()) {
            List<String> list = new ArrayList();
            for (String comb : result) {
                for (char c : mappings[d - '0'].toCharArray()) {
                    list.add(comb + c);
                }
            }
            result = list;
        }
        return result;
    }
}
