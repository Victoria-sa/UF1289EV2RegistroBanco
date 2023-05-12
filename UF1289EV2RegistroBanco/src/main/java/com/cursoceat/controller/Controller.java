package com.cursoceat.controller;

import java.io.File;
import java.security.PublicKey;
import java.util.Scanner;



import com.cursoceat.xml.schema.Banco;
import com.cursoceat.xml.schema.Banco.Cliente;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Controller {
	static	Banco miBanco= new Banco();
	static Scanner lector=new Scanner(System.in);

	public static void main(String[] args) throws JAXBException{
		// TODO Auto-generated method stub
		
	
		int menu=0;
		boolean salir=false;
	
		
		while(salir==false && menu !=4) {
			
		System.out.println("1. Alta del Cliente");
		
		System.out.println("2. Generar XML");
		
		System.out.println("3. Leer XML");
		
		System.out.println("4. Salir");
		menu=lector.nextInt();
		switch (menu) {
		case 1:alta();
		break;
		case 2:generarxml();
		break;
		case 3:leerxml();
		break;
			
			
			

		default:
			break;
		}
		
		
		}	
		
	}
	public static void generarxml() throws JAXBException {
		JAXBContext miContext=JAXBContext.newInstance(Banco.class);
		Marshaller miRegistro=miContext.createMarshaller();		
		miRegistro.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		miRegistro.marshal(miBanco, System.out);
		miRegistro.marshal(miBanco, new File("C:\\Users\\PROGRAMACION\\Documents\\Java\\UF1289EV2RegistroBanco\\datosCliente.xml"));
	
		
	}
	public static void alta() throws JAXBException{
		Cliente miCliente= new Cliente();
		System.out.println("Introduzca el Id del Cliente");
		miCliente.setIdCli(lector.nextInt());
		lector.nextLine();
		System.out.println("Indique el DNI del Cliente");
		miCliente.setDniCliente(lector.nextLine());
		System.out.println("Indique el nombre del Cliente");
		miCliente.setNombreCliente(lector.nextLine());
		System.out.println("Fecha de Nacimiento del Cliente");
		miCliente.setFechaNacimiento(lector.nextLine());
		System.out.println("El saldo de la cuenta es:");
		miCliente.setSaldo(lector.nextInt());
		miBanco.getCliente().add(miCliente);
		
		/*
		 * Banco miBanco=new Banco(); Cliente miCliente1= new Cliente();
		 * miCliente1.setDniCliente("20366898F");
		 * miCliente1.setNombreCliente("Juan Sanchez");
		 * miCliente1.setFechaNacimiento("10-05-1978"); miCliente1.setSaldo((int)
		 * 10200); miBanco.getCliente().add(miCliente1);
		 * 
		 * Cliente miCliente2= new Cliente(); miCliente2.setDniCliente("06237377F");
		 * miCliente2.setNombreCliente("Victoria Sevilla");
		 * miCliente2.setFechaNacimiento("08-04-1969"); miCliente2.setSaldo((int) 1200);
		 * miBanco.getCliente().add(miCliente1);
		 * 
		 * Cliente miCliente3= new Cliente(); miCliente3.setDniCliente("20369869E");
		 * miCliente3.setNombreCliente("Juan Sanchez");
		 * miCliente3.setFechaNacimiento("10-05-1978"); miCliente3.setSaldo((int)
		 * 102200); miBanco.getCliente().add(miCliente1);
		 * 
		 * JAXBContext miContext=JAXBContext.newInstance(Banco.class); Marshaller
		 * miRegistro=miContext.createMarshaller();
		 * miRegistro.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * miRegistro.marshal(miRegistro, System.out); miRegistro.marshal(miRegistro,
		 * new File("C:\\Users\\PROGRAMACION\\Documents\\Html\\registroB.xml"));
		 * 
		 */
	}
	
	public static void leerxml() throws JAXBException {
		File miArchivo=new File("C:\\Users\\PROGRAMACION\\Documents\\Java\\UF1289EV2RegistroBanco\\datosCliente.xml");
		JAXBContext miContext=JAXBContext.newInstance(Banco.class);
		Unmarshaller miRegistro=miContext.createUnmarshaller();
		Banco temBanco=(Banco)miRegistro.unmarshal(miArchivo);
		for (Cliente s:temBanco.getCliente()) {
			System.out.println(s.getIdCli());
			System.out.println(s.getDniCliente());
			System.out.println(s.getNombreCliente());
			System.out.println(s.getFechaNacimiento());
			System.out.println(s.getSaldo());
			System.out.println("______________________");
		}
		
		
	}
	

		
	}
	
	


