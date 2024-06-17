package iut.sae.algo;
public class Algo2 {

    public static String RLE(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
    
        StringBuilder code = new StringBuilder();
        int count = 1;
        char currentChar = input.charAt(0);
    
        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            if (nextChar == currentChar) {
                count++;
            } else {
                while (count > 9) {
                    code.append(9).append(currentChar);
                    count -= 9;
                }
                code.append(count).append(currentChar);
                currentChar = nextChar;
                count = 1;
            }
        }
    
        while (count > 9) {
            code.append(9).append(currentChar);
            count -= 9;
        }
        code.append(count).append(currentChar);
    
        return code.toString();
    }

    
    public static String RLEIteration(String input, int iteration) throws AlgoException {
    if (input == null || input.isEmpty()) {
        return "";
    }

    if (iteration < 1) {
        throw new AlgoException("Itération inférieure à 1");
    }

    String result = input;
    for (int i = 0; i < iteration; i++) {
        String newResult = RLE(result);
        if (newResult.equals(result)) {
            break;
        }
        result = newResult;
    }

    return result;
}


}
