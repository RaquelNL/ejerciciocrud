package com.hibernate;

import com.hibernate.dao.CiudadDAO;
import com.hibernate.model.Ciudad;


import java.util.Scanner; 

public class App {
	
	static void mostrarMenu() {
		System.out.println("Selecciona una opción:");
		System.out.println("1. Crear una nueva ciudad");
		System.out.println("2. Borrar una ciudad");
		System.out.println("3. Actualizar nombre de la ciudad");
		System.out.println("4. Mostrar todas las ciudades");
		System.out.println("5. Mostrar datos ciudad");
		System.out.println("6. Salir del programa");
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
				nombre = s.next();
				System.out.println("Ahora dime los nuevos habitantes: ");
				habitantes = s.nextInt();
				pers1.setHabitantes(40);
				ciudadDAO.updateCiudad(pers1);
				break;
			case 4:
				
				break;


	}
		} while (opcion != 6);
	}
}


