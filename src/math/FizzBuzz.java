package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/fizz-buzz
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new FizzBuzz().fizzBuzzExtendable(3);
        System.out.println(strings);
    }

    public List<String> fizzBuzzExtendable(int n) {
        RuleContainer ruleContainer = new RuleContainer();
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(ruleContainer.findAndApply(i));
        }

        return result;
    }

    private static class RuleContainer {

        private final List<Rule> rules;

        public RuleContainer() {
            // use bean autowire to get all the rules
            this.rules = List.of(new FizzRule(), new BuzzRule(), new FizzBuzzRule(), new DefaultRule());
        }

        public String findAndApply(int n) {
            for (Rule rule : rules) {
                if (rule.isApplicable(n)) return rule.apply(n);
            }

            throw new UnsupportedOperationException();
        }
    }

    private interface Rule {
        boolean isApplicable(int n);
        String apply(int n);
    }

    private static class FizzRule implements Rule {

        @Override
        public boolean isApplicable(int n) {
            return n % 3 == 0 && n % 5 != 0;
        }

        @Override
        public String apply(int n) {
            return "Fizz";
        }
    }

    private static class BuzzRule implements Rule {

        @Override
        public boolean isApplicable(int n) {
            return n % 5 == 0 && n % 3 != 0;
        }

        @Override
        public String apply(int n) {
            return "Buzz";
        }
    }

    private static class FizzBuzzRule implements Rule {

        @Override
        public boolean isApplicable(int n) {
            return n % 3 == 0 && n % 5 == 0;
        }

        @Override
        public String apply(int n) {
            return "FizzBuzz";
        }
    }

    private static class DefaultRule implements Rule {

        @Override
        public boolean isApplicable(int n) {
            return n % 3 != 0 && n % 5 != 0;
        }

        @Override
        public String apply(int n) {
            return "" + n;
        }
    }
}
