public class Main {
    //En primer lugar declaramos el numero de personas que hay en la cima
    static int MAX_NUMBERS = 86;

    public static void main(String[] args) {
        // es un objeto compartido,es decir lo que nos permite usar la variable MAX NUMBER EN TODOS LOS HILOS
        Main obj = new Main();
        // Creamos los tres threads, es decir los tres hilos de ejecución
        Thread t1 = new Thread(new NumberRunnable(obj, 0,5), "Helicoptero 1");//El obj es el numero de personas en la cima, El result es como un id y el name es el nombre que le das al hilo
        Thread t2 = new Thread(new NumberRunnable(obj, 1,3), "Helicoptero 2");
        Thread t3 = new Thread(new NumberRunnable(obj, 2,1), "Helicoptero 3");
        t1.start();//inicio hilos
        t2.start();
        t3.start();
    }
    public static void restarcima(int plazas){
        MAX_NUMBERS-=plazas;//Metodo para restar el num actual de personas en la cima menos el total al numero total de personas les restanel numero de personas q hay en el helicoptero
    }
}

class NumberRunnable implements Runnable {
    Main obj;//
    int numsitios;//numero de asientos que tiene helicoptero
    int threadNumber;//es el id
    static int number = 0;//sirve para cambiar entre hilos

    //constructor de esta clase
    NumberRunnable(Main obj, int result, int numsitios) {
        this.obj = obj;
        this.threadNumber = result;
        this.numsitios = numsitios;
    }
    @Override
    public void run() {//Implementamos metodo run que es necessario cuando implementamos runnable
        while (0 < Main.MAX_NUMBERS) {
            int numal = (int) Math.random()*10+10; //Declaramos segundos aleatorios entre el 10 y el 20 para que recojan pasajeros
            try {//Try catch pq es obligatorio
                Thread.sleep(numal*10);// el metodo sleep duerme el proceso y simula que los recoje cada entre 10 y 20 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();//Es un método de la clase arrojable de Java que imprime el arrojable junto con otros detalles como el número de línea y el nombre de la clase donde ocurrió la excepción.
            }
            synchronized(obj) {// se declara syncronized para evitar que los hilos se ejecuten a la vez
                if (number % 3 == threadNumber && 0 < Main.MAX_NUMBERS) {// el thread number lo uqe  hace es seleccionar  el "ID" y si el residuo que le ha dado es divisible entre 1, coje el primer helicoptero, si es divisible entre 3, pilla el segundo y si es entre 5 pilla el 3er helicoptero
                    //n

                    if(Main.MAX_NUMBERS<4){//para que cuando sea menor que 5 que recoja a las personas y no lo haga en negativo
                        //ejecucion metodo restar sitios que se hace sumando las personas recogidas
                        System.out.println(Thread.currentThread().getName() + "- Ha recogido "+Main.MAX_NUMBERS +" personas:" +" ya no quedan personas.");
                        Main.restarcima(Main.MAX_NUMBERS);
                    }else {//para la ejecución normal.
                        Main.restarcima(numsitios);//ejecucion metodo restar sitios que se hace sumando las personas recogidas
                        System.out.println(Thread.currentThread().getName() + "- Ha recogido "+numsitios +" personas:" +" y quedan en la cima :"+(Main.MAX_NUMBERS)+ " personas.");
                    }
                    number++;

                }

            }
        }System.out.println("Todos los pasajeros han sido rescatados con exito");//mensaje final

    }
}