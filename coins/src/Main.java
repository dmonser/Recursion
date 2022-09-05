public class Main {
    public static void main(String[] args) {

        String answer = check(10);
        System.out.println(answer);
    }

    public static String check (int sum){       // TODO: 05.09.2022 Not working
        if (sum >= 3 && check(sum - 3).equals("да")){
            return "да";
        }
        if (sum >= 5 && check(sum - 5).equals("да")){
            return "да";
        }
        return "нет";
    }
}