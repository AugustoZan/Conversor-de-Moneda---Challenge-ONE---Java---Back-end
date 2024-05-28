#Conversor de monedas

*El conversor de monedas fue un challenge de [Alura Latam](https://github.com/alura-es-cursos "Alura Latam"). 
El proyecto consiste en que el programa le permita al usuario convertir el valor de una moneda a otra. Funciona a través del lenguaje de programación **Java** utilizando una API que almacena el valor de dichas monedas. *
## Características

> - Cuenta con 5 tipos de monedas (USD, ARS, BRL, COP & MXN)
>- Un menú con 9 opciones. Permite convertir monedas latinoamericanas a dólares y viceversa. También permite terminar con el programa.
>- Cuenta con depuración para evitar errores en la obtención de valores de monedas del API y para evitar que el programa tire error sí el usuario ingresa un valor no correspondiente al programa.


## Estructura

El proyecto utiliza 3 archivos .java:
- **Main.java**: Este archivo se encarga de llamar a la clase **Convertidor.java** y es, por lo tanto, la forma que tiene el usuario de correr el proyecto.

		public class Main {
	   	 public static void main(String[] args) {
       	 Convertidor convertir = new Convertidor();
        	convertir.menu();
		} }
- **Convertidor.java**: Es una clase que tiene como atributos los valores de las monedas y la cantidad que el usuario quiere saber. Cuenta con dos tipos de funciones: 
El primero es un menú, para que el usuario pueda elegir qué monedas quiere convertir o bien, para finalizar el programa. 

		public void menu() {
			int opcion = 0;
        	do {
				System.out.println("------------------------------------------\n");
				System.out.println("¡Convertidor de monedas!");
				System.out.println("1. Pasar Dólar a Peso Argentino");
				System.out.println("2. Pasar Dólar a Real Brasileño");
				System.out.println("3. Pasar Dólar a Peso Colombiano");
				System.out.println("4. Pasar Dólar a Peso Mexicano");
				System.out.println("5. Pasar Peso Argentino a Dólar");
				System.out.println("6. Pasar Real Brasileño a Dólar");
				System.out.println("7. Pasar Peso Colombiano a Dólar");
				System.out.println("8. Pasar Peso Mexicano a Dólar");
				System.out.println("9. Salir");
				System.out.println("\n------------------------------------------");
				//Continuación del código...
				} while (opcion != 9);
  
El segundo son funciones que toman los valores de las monedas y las pasan hacia la moneda que el usuario eligió en el menú. Se le preguntan cuánto será el monto de la moneda que escogió y, de ahí, se imprime un mensaje donde se le muestra al usuario por pantalla el valor de la moneda al convertirla.

        public void dolarAPesoArg() {
			Scanner leer = new Scanner(System.in);
			System.out.println("Ingrese la cantidad de dólares");
			try {
				this.cantidad = leer.nextDouble();
				System.out.println(this.cantidad + ((this.cantidad == 1)? " dólar " : " dólares ") + " son " + ((this.cantidad * this.dolar) * this.pesoArg) + ((((this.cantidad * this.dolar) * this.pesoArg) == 1)? " peso argentino" : " pesos argentinos"));
			} catch (InputMismatchException e) {
					System.out.println("Error: debe ingresar un número decimal");
					leer.next(); //En caso de error, permite al programa ingresar un nuevo valor.
				}
			}
    

- **ConvertidorRequest.java**: Esta clase  se conecta con la API y solicita los valores de las monedas para que **Convertidor.java** tome esos valores solicitados y los establezca en sus atributos.

       public static double obtenerValorDolar() {
			try {
				// URL de la API
				URL url = new URL("https://v6.exchangerate-api.com/v6/...");

				// Abrir conexión HTTP
				HttpURLConnection con = (HttpURLConnection) url.openConnection();

				// Método de solicitud (GET)
				con.setRequestMethod("GET");

				// Obtener la respuesta
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// Convertir la respuesta JSON a un objeto Java
				JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

				// Obtener el valor del dólar
				JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
				double usd = conversionRates.get("USD").getAsDouble();

				return usd;
			} catch (Exception e) {
				e.printStackTrace();
				return 0.0; // Devuelve un valor predeterminado en caso de error
			}
		}

## Tecnología utilizada
- Java (Lenguaje de programación dónde se trabajó el proyecto)
- [API](https://www.exchangerate-api.com/ "API") (Contenedor de los valores de las monedas)
- El Gson utilizado es  **google.code.gson**.
