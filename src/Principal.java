import java.util.Scanner;

public class Principal {
    static boolean salir = false;
    static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double conversion = 0.0;
        double monto = 0.0;


        ConsultarMoneda cm =new ConsultarMoneda();
        //consultamos la moneda base
        Moneda mn = cm.buscaMoneda("USD");


        while (!salir){
            System.out.println(menu());
            int opcion = obtenerOpcionUsuario();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion = cm.convertirUSD(mn, "MXN", monto);
                    System.out.println("La conversion es: "+conversion);
                }
                case 2 -> {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion=cm.convertirABase(mn, "MXN", monto);
                    System.out.println("La conversion es: "+conversion);
                }
                case 3 ->  {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion = cm.convertirUSD(mn, "BRL", monto);
                    System.out.println("La conversion es: "+conversion);
                }
                case 4 -> {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion=cm.convertirABase(mn, "BRL", monto);
                    System.out.println("La conversion es: "+conversion);
                }
                case 5 -> {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion = cm.convertirUSD(mn, "CNY", monto);
                    System.out.println("La conversion es: "+conversion);

                }
                case 6 -> {
                    System.out.println("Ingrese el monto: ");
                    monto = scanner.nextDouble();
                    conversion=cm.convertirABase(mn, "CNY", monto);
                    System.out.println("La conversion es: "+conversion);
                }
                case 7 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida, por favor elija nuevamente.");
            }

        }
    }


    public static String menu(){
        return
                """
                ++++++++++++++++++++++++++++++++++++++++++++++
                Bienvendio al conversor  de monedas :)
                
                1 ) Dolar ==> Peso mexicano
                2 ) Peso mexicano ==> Dolar
                3 ) Dolar ==> Real brazileño
                4 ) Real brazileño ==> Dolar
                5 ) Dolar ==> Renminbi chino
                6 ) Renminbi chino ==> Dolar
                7 ) Salir 
                """;
    }

    public static int obtenerOpcionUsuario() {
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        return opcion;
    }


}
