package kata.chronos;

public class NumberParser {


    public interface ParseResult{
        void parsed(int value);
    }

    public void parseNumberFrom(String input, ParseResult parseResult) {
        parseRoman(input, parseResult);
        parseInteger(input, parseResult);
    }

    private void parseInteger(String input, ParseResult parseResult) {
        try {
            parseResult.parsed(Integer.parseInt(input));
        } catch (NumberFormatException ex) {
            //do nothing
        }
    }

    private void parseRoman(String input, ParseResult parseResult) {
        try {
            parseResult.parsed(new RomanNumeral(input).toInt());
        } catch (NumberFormatException ex) {
            //do nothing
        }
    }
}
