import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.FindException;
import java.security.PublicKey;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class merkez {

	public static void main(String[] args) throws IOException {

		int[][] calendar = new int[365][30];
		int[] call = new int[365];
		for (int i = 1; i <= 31; i++) {
			call[i] = i;
		}
		for (int i = 1; i <= 29; i++) {
			call[i + 31] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29] = i;
		}
		for (int i = 1; i <= 30; i++) {
			call[i + 31 + 29 + 31] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29 + 31 + 30] = i;
		}
		for (int i = 1; i <= 30; i++) {
			call[i + 31 + 29 + 31 + 30 + 31] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30 + 31] = i;
		}
		for (int i = 1; i <= 30; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30] = i;
		}
		for (int i = 1; i <= 30; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31] = i;
		}
		for (int i = 1; i <= 31; i++) {
			call[i + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 28] = i;
		}
		String Input;
		try {

			Scanner scanner = new Scanner(new File("commands.txt"));

			while (scanner.hasNextLine()) {
				Input = scanner.nextLine();

				// BOŞ SATIR GELMEDİĞİ YERE KADAR OKUU
				String[] parts = Input.split(";");

				if (parts[0].equalsIgnoreCase("addRoom")) {
					int numOfRoom = Integer.parseInt(parts[1]); // ODA SAYIUSI ALDIK SIMDI BU KADAR ODA YARATILACAK

					for (int i = 0; i < numOfRoom; i++) {

						Room newRoom = new Room(parts[2], parts[3], parts[4], parts[5]);

						// Yeni odayı diziye ekleyin ve sayaçı artırın
						rooms[count_room] = newRoom;
						count_room++;
					}

				}

				else if (parts[0].equalsIgnoreCase("addCustomer")) {
					Customer c = new Customer(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
							parts[8]);
					addCustomer(c);

				} else if (parts[0].equalsIgnoreCase("addEmployee")) {
					Staff s = new Staff(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8],
							parts[9], parts[10]);
					addEmployee(s);
					salaries += Integer.parseInt(parts[10]);

				} else if (parts[0].equalsIgnoreCase("listRooms")) {
					System.out.println("listRooms");
					for (int i = 0; i < count_room; i++) {
						Room room = rooms[i];
						System.out.println("Room " + (i + 1) + ": " + room.getType() + "   Aircondition: "
								+ room.getAircondition() +

								"   Balcony: " + room.getBalcony() + "   " + room.getPrice() + "TL");
					}

				} else if (parts[0].equalsIgnoreCase("addReservation")) {
					if (rescheck(calendar, findingDate("01.01", parts[3]), findingDate("01.01", parts[4]),
							Integer.parseInt(parts[2]), count_room)) {
						resToCal(calendar, findingDate("01.01", parts[3]), findingDate("01.01", parts[4]), // ayın 30
																											// unua yanı
																											// son
																											// gunede
																											// yerlestırmısler
								Integer.parseInt(parts[2]), count_room);
						Reservation r = new Reservation(parts[1], parts[2], parts[3], parts[4]);
						addReservation(r);

						int stayingTime = findingDate("01.01", parts[4]) - findingDate("01.01", parts[3]);
						int roomId = Integer.parseInt(parts[2]);
						income += rooms[roomId - 1].getPrice() * stayingTime;

					}

				} else if (parts[0].equalsIgnoreCase("listReservations")) {
					System.out.println("listReservations");
					listReservation();

					;
				} else if (parts[0].equalsIgnoreCase("listCustomers")) {
					System.out.println("listCustomer");
					listCostumers();

				} else if (parts[0].equalsIgnoreCase("listEmployees")) {
					System.out.println("listEmployees");
					listEmployee();

				} else if (parts[0].equalsIgnoreCase("statistics")) {
					System.out.println("statistics");
					System.out.print("1.");
					theMostReservedRoom(reservations, count_reservation);
					System.out.print("2.");
					theBestCustomer(reservations, customers, count_id_customer);
					System.out.print("3.");
					profit();
					System.out.println("4.Monthly occupancy rate");
					occupancy(calendar);
					System.out.println("\n");
				} else if (parts[0].equalsIgnoreCase("DeleteEmployee")) {
					deleteEmployee(Integer.parseInt(parts[1]), employees);
					count_employee--;
				}
				else if (parts[0].equalsIgnoreCase("searchCustomer")) {
					String input_name = parts[1];
					if (input_name.contains("*")) {
						int index_star = input_name.indexOf('*');
						String first_partString = input_name.substring(0, index_star);
						String second_partString = input_name.substring(index_star + 1);
						System.out.println();
						System.out.println("searchCustomer");
						for (int i = 0; i < count_id_customer; i++) {
							if (customers[i].getName().startsWith(first_partString)
									&& customers[i].getName().endsWith(second_partString)) {

								System.out.println("Costumer #" + (i + 1) + "   " + customers[i].getName() + " "
										+ customers[i].getSurname() + "   " + customers[i].getGender() + "   "
										+ customers[i].getBirthdate() + "   " + customers[i].getCity() + "   "
										+ customers[i].getPhone());
							}
						}

					} else if (input_name.contains("?")) {
						int question_mark_counter = 0, counter = 0;
						System.out.println();
						System.out.println("searchCustomer");
						for (int i = 0; i < input_name.length(); i++) {
							if (input_name.charAt(i) == '?') {
								question_mark_counter++;
							}
						}
						for (int i = 0; i < count_id_customer; i++) {
							if (input_name.length() == customers[i].getName().length()) {
								String temp = customers[i].getName();
								for (int j = 0; j < input_name.length(); j++) {
									if (input_name.charAt(j) == temp.charAt(j)) {
										counter++;
										if (input_name.length() - question_mark_counter == counter) {
											counter = 0;
											System.out.println("Costumer #" + (i + 1) + "   " + customers[i].getName()
													+ " " + customers[i].getSurname() + "   " + customers[i].getGender()
													+ "   " + customers[i].getBirthdate() + "   "
													+ customers[i].getCity() + "   " + customers[i].getPhone());
										}
									}
								}
							}
						}

					}

				} 
				else if (parts[0].equalsIgnoreCase("searchRoom")) {
					System.out.println("searchRoom");
					searchRoom(calendar, findingDate("01.01", parts[1]), findingDate("01.01", parts[2]), count_room);
				}
				else if (parts[0].equalsIgnoreCase("simulation")) {
					System.out.println("simulation");
					int start_index = findingDate("01.01", parts[1]);
					int between_days = findingDate(parts[1], parts[2]);
					// *********************************
					System.out.print("Day          :");
					for (int i = start_index + 1; i < start_index + between_days + 2; i++) {

						System.out.print(call[i] + "  ");
					}
					System.out.println();

					System.out.print("Customer     :");
					for (int i = start_index; i < start_index + between_days + 1; i++) {
						int count_customer_day = 0;
						for (int k = 0; k < 30; k++) {

							if (calendar[i][k] != 0) {// seçilen gün kaçtane müşteri var buluyoruz
								count_customer_day++;
							}

						}
						System.out.print(count_customer_day + "   ");
					}
					System.out.println();
					System.out.print("Satisfaction:");
					double total_satisf = 0;

					for (int i = start_index; i < start_index + between_days + 1; i++) {
						int count_customer_day = 0;
						for (int k = 0; k < 30; k++) {

							if (calendar[i][k] != 0) {// seçilen gün kaçtane müşteri var buluyoruz
								count_customer_day++;
							}

						}
						int count_housekeeper = 0;
						for (int k = 0; k < count_employee; k++) {
							if (employees[k].getJob().equalsIgnoreCase("housekeeper")) {
								count_housekeeper++;
							}
						}
						double satisf;
						if (count_customer_day == 0) {
							satisf = 100;
							total_satisf += satisf;
							System.out.print((int) satisf + "%");
						} else {
							satisf = (count_housekeeper * 3) / count_customer_day;
							if (satisf >= 1) {
								satisf = 100;
								total_satisf += satisf;
								System.out.print((int) satisf + "%");
							} else {
								satisf = (count_housekeeper * 3) * 100 / count_customer_day;// ********donulecek**********
								total_satisf += satisf;
								System.out.print((int) satisf + "%");
							}
						}

					}
					System.out.println();
					System.out.println("Average satisfaction = " + total_satisf / (between_days + 1));

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static Room[] rooms = new Room[30];
	public static int count_room = 0, income = 0, salaries = 0;

	static Customer[] customers = new Customer[30];
	public static int count_id_customer = 0;

	public static void addCustomer(Customer c) {
		if (count_id_customer < 30) {
			customers[count_id_customer] = c;
			count_id_customer++;
		}
	}

	public static void listCostumers() {
		for (int i = 0; i < count_id_customer; i++) {
			System.out.println("Costumer #" + (i + 1) + "   " + customers[i].getName() + " " + customers[i].getSurname()
					+ "   " + customers[i].getGender() + "   " + customers[i].getBirthdate() + "   "
					+ customers[i].getCity() + "   " + customers[i].getPhone());
		}
	}

	static Reservation[] reservations = new Reservation[30];
	private static int count_reservation = 0;

	private static void addReservation(Reservation r) {

		if (count_reservation < 30) {

			reservations[count_reservation] = r;
			count_reservation++;
		}
	}

	public static void listReservation() {
		for (int i = 0; i < count_reservation; i++) {
			System.out.println("Room #" + reservations[i].getRoom_id() + "  " + customers[i].getName() + " "
					+ customers[i].getSurname() + "  " + reservations[i].getDate_of_arrival() + " "
					+ reservations[i].date_of_departure);
		}

	}

	public static Staff[] employees = new Staff[50];
	public static int count_employee = 0;

	public static void addEmployee(Staff s) {
		if (count_employee < 50) {
			employees[count_employee] = s;
			count_employee++;
		}
	}

	public static void listEmployee() {
		for (int i = 0; i < count_employee; i++) {
			System.out.println("Employee #" + (i + 1) + "   " + employees[i].getName() + " " + employees[i].getSurname()
					+ "   " + employees[i].getBirthDate() + "   " + employees[i].getJob());
		}

	}

	// method for searching available room
	public static void searchRoom(int[][] calendar, int start_index, int end_index, int room_count) {
		for (int i = 0; i < room_count; i++) {
			if (rescheck(calendar, start_index, end_index, i + 1, room_count)) {
				System.out.println("Room " + (i + 1) + ": " + rooms[i].getType() + "   Aircondition: "
						+ rooms[i].getAircondition() +

						"   Balcony: " + rooms[i].getBalcony() + "   " + rooms[i].getPrice() + "TL");
			}
		}
	}

	public static void deleteEmployee(int employee_id, Staff[] array) {
		Staff temp;
		array[employee_id - 1] = null;

		// loop for deleting an employee and then merging the array altogether
		try {
			while (array[employee_id - 1] == null) {
				temp = array[employee_id];
				array[employee_id] = array[employee_id - 1];
				array[employee_id - 1] = temp;
				employee_id++;
			}
		} catch (Exception e) {

		}

	}

	public static void profit() {
		final int constantExpense = 10000;
		int profit = income - 12 * (salaries + constantExpense);
		System.out.println("Income = " + income); // income
		System.out.println("Salaries = " + salaries * 12); // salary
		System.out.println("Constant expenses = " + constantExpense*12); // constant expenses
		System.out
				.println("Profit = " + income + " - " + salaries * 12 + " - " + constantExpense * 12 + " = " + profit); // profit
	}

	public static void occupancy(int[][] calendar) {
		int reservedDays = 0;
		double res = 0;
		System.out.println("1   2   3   4   5   6   7   8   9   10   11   12");

		for (int i = 0; i <= 364; i++) {
			if (i == 30 || i == 90 || i == 151 || i == 212 || i == 243 || i == 304 || i == 365) {
				for (int j = 0; j < 31; j++) {
					for (int k = 0; k < count_room; k++) {
						if (calendar[i - j][k] != 0) {
							reservedDays += 1;
						}
					}
				}
				res = (double) 100 * reservedDays / (31 * count_room);
				System.out.print(Math.round(res) + "%  ");
			}
			// February has 29 days this year
			else if (i == 59) {
				for (int j = 0; j < 29; j++) {
					for (int k = 0; k < count_room; k++) {

						if (calendar[i - j][k] != 0) {
							reservedDays += 1;
						}
					}
				}

				res = (double) 100 * reservedDays / (29 * count_room);
				System.out.print(Math.round(res) + "%  ");
			}
			// other months have 30 days each
			else if (i == 120 || i == 181 || i == 273 || i == 334) {
				for (int j = 0; j < 30; j++) {
					for (int k = 0; k < count_room; k++) {

						if (calendar[i - j][k] != 0) {
							reservedDays += 1;
						}
					}
				}

				res = (double) 100 * reservedDays / (30 * count_room);
				System.out.print(Math.round(res) + "%  ");
			}
			reservedDays = 0;

		}
	}

	public static void theBestCustomer(Reservation[] array, Customer[] customers, int customer_count) {
		String[][] names = new String[30][2];// for storing the names who make a reservation

		String namesMushed = "", bestCustomer = "";
		int maxDays = -999;

		for (int n = 0; n < customer_count; n++) {
			if (!(namesMushed.contains(customers[n].name + " " + customers[n].surname)))// if the cell is empty and the
																						// name was never encountered
																						// before
			{
				names[n][0] = customers[n].name + " " + customers[n].surname;
				namesMushed += customers[n].name + " " + customers[n].surname;
				names[n][1] = Integer.toString(
						(names[n][1] == null ? +findingDate(array[n].date_of_arrival, array[n].date_of_departure)
								: (Integer.parseInt(names[n][1]))
										+ findingDate(array[n].date_of_arrival, array[n].date_of_departure)));
				if (Integer.parseInt(names[n][1]) > maxDays) {
					maxDays = Integer.parseInt(names[n][1]);
					bestCustomer = customers[n].name + " " + customers[n].surname;
				}
			} else {
				for (int j = 0; j < 30; j++) {
					if (names[j][0] == customers[n].name + " " + customers[n].surname) {
						names[j][1] = Integer.toString(((Integer.parseInt(names[j][1])
								+ (int) findingDate(array[n].date_of_arrival, array[n].date_of_departure))));
						if (Integer.parseInt(names[j][1]) > maxDays) {
							maxDays = Integer.parseInt(names[j][1]);
							bestCustomer = customers[n].name + " " + customers[n].surname;
						}
					}
				}
			}
		}

		System.out.println("The Best Customer is: " + bestCustomer + " with " + maxDays + " Days of stay");
	}

	public static int theMostReservedRoom(Reservation[] array, int reservation_count) {
		int[][] roomOcurrence = new int[30][2];
		int index = 0, maxResRoom = 0, maxOccur = -9999;
		while (array[index] != null) {
			roomOcurrence[index][0] = Integer.parseInt(array[index].room_id);
			// I will be using this loop to make the contains method
			for (int i = 0; i < reservation_count; i++) {
				if (Integer.parseInt(array[index].room_id) == roomOcurrence[i][0]) {
					roomOcurrence[i][1] += findingDate(array[index].date_of_arrival, array[index].date_of_departure);
				}
				if (roomOcurrence[i][1] > maxOccur) {
					maxOccur = roomOcurrence[i][1];
					maxResRoom = roomOcurrence[i][0];
				}
			}
			index++;
		}
		System.out.println("The Most Reserved Room is: Room#" + maxResRoom);
		return maxResRoom;
	}

	public static int findingDate(String startDate, String endDate) {
		String[] startArr = startDate.split("\\.");
		String[] endArr = endDate.split("\\.");

		int startDay = Integer.parseInt(startArr[0]);
		int startMonth = Integer.parseInt(startArr[1]);
		int endDay = Integer.parseInt(endArr[0]);
		int endMonth = Integer.parseInt(endArr[1]);
		int maxday, currentday = startDay, currentmonth = startMonth, daysofstay = 0;
		// loop will iterate for how many months between two dates
		for (int i = 0; i <= endMonth - startMonth; i++) {
			// these months of year have 31 days
			if (currentmonth == 1 || currentmonth == 3 || currentmonth == 5 || currentmonth == 7 || currentmonth == 8
					|| currentmonth == 10 || currentmonth == 12) {
				maxday = 31;
			}
			// February has 29 days this year
			else if (currentmonth == 2) {
				maxday = 29;
			}
			// other months have 30 days each
			else {
				maxday = 30;
			}

			// if we looped through a new month, our current day must be zero
			if (i != 0)
				currentday = 0;
			// if we are at the last iteration of the loop,then we cannot take maxday
			if (i == (endMonth - startMonth))
				maxday = endDay;
			daysofstay += maxday - currentday;
			currentmonth++;
		}
		return daysofstay;
	}

	public static boolean rescheck(int[][] calendar, int start_date_index, int end_date_index, int room_id,
			int room_count) {
		boolean flag = true;// our indicator for resembling if we can reserve that room or not
		boolean success = false;// our indicator for partially controlling the reservation status
		for (int i = start_date_index; (i <= end_date_index) && flag; i++) {// we can iterate from our start date to end
																			// date for more optimal loop and if our
																			// flag is been inverted (that means we
																			// cannot completely make our reservation)
																			// loop will break
			for (int n = 0; n < room_count; n++) {
				if (calendar[i][n] != 0 && calendar[i][n] == room_id)// if the cell is not empty
				{
					flag = false;
					break;// in this case we cannot make the reservation
				} else if (calendar[i][n] != 0)// the cell is not empty and we encountered this room is already reserved
												// before
				{
					continue;
				} else if (calendar[i][n] == 0)// if the cell is empty and we can
				{
					success = true;// we can understand here if we successfully make our one-day-reservation
					break;// in this case we are able to make reservation
				}
			}
			if (!success)
				flag = false;// if we exited inner loop with no success that means we cannot make a
								// reservation
			success = false;// for continuity
		}
		return flag;// returning the availability
	}

	public static int[][] resToCal(int[][] calendar, int start_date_index, int end_date_index, int room_id,
			int room_count) {
		for (int i = start_date_index; i < end_date_index; i++) {
			for (int n = 0; n < room_count; n++) {
				if (calendar[i][n] != 0)// if the cell is not empty
				{
					continue;// in this case we can move on and search for an opening
				} else {
					calendar[i][n] = room_id;// in this case we make our reservation and there's no more need to search
												// for an opening
					break;// so we break out of the loop
				}
			}
		}
		return calendar;
	}
}
