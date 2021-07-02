package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Pedido {

	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		Date pedidoMoment = new Date();
		String pedidoName = sc.nextLine();
		System.out.print("Email :");
		String pedidoEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date pedidoBirth = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus pedidoStatus = OrderStatus.valueOf(sc.next());
		Client pedidoClient = new Client(pedidoName, pedidoEmail, pedidoBirth);
		Order order = new Order(pedidoMoment,pedidoStatus, pedidoClient);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i<=n; i++) {
			System.out.print("Enter #" +i+ " item data: %\n");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Product quantity: ");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem =new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
			System.out.println(productName);
			System.out.println(productPrice);
			System.out.println(productQuantity);
		}
		
		System.out.println(order);
		
		
		sc.close();
	}

}
