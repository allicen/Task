public class Number {
    private static int line = 1; // Порядковый номер числа
    static int armstrong (int numberStart){
        int numberStartLen = (int)Math.log10(numberStart) + 1; // Вычисляем длину числа
        int iThousend = numberStart / 1000 % 10; // Вычисление цифр разрядов
        int iHunghed = numberStart / 100 % 10;
        int iTen = numberStart / 10 % 10;
        int iOne = numberStart % 10;
        if(numberStartLen == 3 || numberStartLen == 4){ // Если число по условию 3 или 4 разрядное
            int lenPow = 50; // Счетчик для степени
            for(int pow = 0; pow < lenPow; pow++){
                if(Math.pow(iThousend, pow) + Math.pow(iHunghed, pow) + Math.pow(iTen, pow) + Math.pow(iOne, pow) == numberStart && numberStartLen == pow){
                    System.out.println("Число " + line + ": " + numberStart + ", степень: " +pow);
                    line = line + 1;
                    return pow;
                }
            }
        }
        return line;
    }
    public static void main(String[] args){
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 10; c++){
                    for(int d = 0; d < 10; d++){
                        int numberStart = Integer.valueOf(a+""+b+""+c+""+d); // Преобразуем строку с полученнымии числами в число
                        armstrong(numberStart);
                    }
                }
            }
        }
    }
}
