public class Main {
    public static void main(String[] args) {

        String answer = check(7);
        System.out.println(answer);
    }

    public static String check (int sum){
        if(sum == 0){
            return "да";
        }
        if (sum >= 3 && check(sum - 3).equals("да")){
            return "да";
        }
        if (sum >= 5 && check(sum - 5).equals("да")){
            return "да";
        }
        return "нет";
    }
}