package com.hibernate;

import com.hibernate.dao.CiudadDAO;
import com.hibernate.model.Ciudad;

import java.util.List;
import java.util.Scanner; 

public class App {
	
	static void mostrarMenu() {
		System.out.println("Selecciona una opción:");
		System.out.println("1. Crear una nueva ciudad");
		System.out.println("2. Borrar una ciudad");
		System.out.println("3. Actualizar nombre de la ciudad");
		System.out.println("4. Mostrar todas las ciudades");
		System.out.println("5. Mostrar datos ciudad");
		System.out.println("6. Seleccionar ciudades con más de 1 millón de habitantes");
		System.out.println("7. Seleccionar ciudades con menos habitantes");
		System.out.println("8. Mostrar habitantes de la ciudad seleccionada");
		System.out.println("9. Salir del programa");
	}

	public static void main(String[] args) {
		
		CiudadDAO ciudadDAO = new CiudadDAO();
		int opcion;
		Scanner s = new Scanner(System.in);
		String nombre;
		int habitantes;
		int codigo;
		
		do {
			mostrarMenu();
			opcion = s.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Dime el nombre de la ciudad: ");
				nombre = s.next();
				System.out.println("Dime los habitantes de la ciudad: ");
				habitantes = s.nextInt();
				Ciudad ciudad1 = new Ciudad (nombre, habitantes);
				ciudadDAO.insertCiudad(ciudad1);
				break;
			case 2:
				System.out.println("Dime el código de la ciudad que quieras borrar: ");
				codigo = s.nextInt();
				ciudadDAO.deleteCiudad(codigo);
				break;
			case 3:
				System.out.println("Dime la ciudad que quieras actualizar: ");
				codigo = s.nextInt();
				System.out.println("Ahora dime los nuevos habitantes: ");
				habitantes = s.nextInt();
				ciudadDAO.updateCiudad(codigo);
				codigo.setHabitantes(habitantes);
				break;
			case 4:
				List<Ciudad> ciudades = ciudadDAO.selectAllCiudad();
				ciudades.forEach(c->System.out.println(c.getNombre()+ " "+ c.getHabitantes()));
				break;
			case 5:
				System.out.println("Elige la ciudad que quieras ver sus datos: ");
				codigo = s.nextInt();
				ciudadDAO.selectCiudadById(codigo);
				break;
			case 6:
				List<Ciudad> ciudades1M = ciudadDAO.selectCiudad1MHab();
				ciudades1M.forEach(c->System.out.println(c.getNombre()+ " "+ c.getHabitantes()));
				break;
				break;
			case 7:
				break;
			case 8:
				break;
			case 9: 
				System.out.println("Has salido del programa");
				break;
			default: System.out.println("Escoge una opción válida");


	}
		} while (opcion != 9);
	}
}


