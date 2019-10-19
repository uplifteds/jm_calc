public class RomanExpression implements IAriphmetics {
    private String arg0;
    private String arg2;
    public RomanExpression(String arg0, String arg2) {
        this.arg0 = arg0;
        this.arg2 = arg2;
    }

    RomanToNumber rtn = new RomanToNumber();
    NumberToRoman numberToRoman = new NumberToRoman();

    @Override
    public String sum() {
        int sum_result = rtn.romanToDecimal(arg0) + rtn.romanToDecimal(arg2);
        return numberToRoman.printRoman(sum_result);
    }

    @Override
    public String multiply() {
        int mult_result = rtn.romanToDecimal(arg0) * rtn.romanToDecimal(arg2);
        return numberToRoman.printRoman(mult_result);
    }

    @Override
    public String deduce() {
        int deduce_result = rtn.romanToDecimal(arg0) - rtn.romanToDecimal(arg2);
        return numberToRoman.printRoman(deduce_result);
    }

    @Override
    public String divide() {
        if (rtn.romanToDecimal(arg2) !=0) {
            double div_result = rtn.romanToDecimal(arg0) / rtn.romanToDecimal(arg2);
            String dts = numberToRoman.printRoman((int) div_result);
            return dts;
        } else {
            return "Can't divide by zero";
        }
    }
}
