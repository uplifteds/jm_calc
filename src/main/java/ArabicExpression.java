
public class ArabicExpression implements IAriphmetics{

    private int arg0_int;
    private Integer arg2_int;

    public ArabicExpression(String arg0, String arg2) {
        try {
            this.arg0_int = Integer.parseInt(arg0);
            this.arg2_int = Integer.parseInt(arg2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    @Override
    public String sum() {
        int sum_result = arg0_int + arg2_int;
        return String.valueOf(sum_result);
    }

    @Override
    public String multiply (){
        int mult_result = arg0_int * arg2_int;
        return String.valueOf(mult_result);
    }

    @Override
    public String deduce() {
        int deduce_result = arg0_int - arg2_int;
        return String.valueOf(deduce_result);
    }

    @Override
    public String divide() {
        if (!arg2_int.equals(0)) {
            double div_result = arg0_int / arg2_int;
            return String.valueOf(div_result);
        } else {
            return "Can't divide by zero";
        }
    }
}