class Solution {

    String s;
    int index;

    public List<String> braceExpansionII(String expression) {

        s = expression;
        index = 0;

        Set<String> result = expression();

        List<String> answer = new ArrayList<>(result);

        Collections.sort(answer);

        return answer;
    }

    // Handles union: A,B
    private Set<String> expression() {

        Set<String> result = term();

        while (index < s.length() && s.charAt(index) == ',') {

            index++; // skip ','

            result.addAll(term());
        }

        return result;
    }

    // Handles concatenation: AB
    private Set<String> term() {

        Set<String> result = new HashSet<>();

        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> current;

            if (s.charAt(index) == '{') {

                index++; // skip '{'

                current = expression();

                index++; // skip '}'

            } else {

                current = new HashSet<>();

                current.add(String.valueOf(s.charAt(index)));

                index++;
            }

            result = multiply(result, current);
        }

        return result;
    }

    // Cartesian product / concatenation
    private Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {

            for (String y : b) {

                result.add(x + y);
            }
        }

        return result;
    }
}