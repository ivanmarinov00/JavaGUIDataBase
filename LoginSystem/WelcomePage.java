package LoginSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class WelcomePage  implements ActionListener {

    String url = "jdbc:mysql://localhost:3306/HotelDB2";
    String username = "root";
    String password = "pass";

    String [] tables = {"Reservation", "Employee" , "Client", "Accommodation", "Room"};

    JFrame frame = new JFrame();
    JLabel welcomeLabel= new JLabel("Welcome to the Hotel DataBase");
    JLabel tablesLabel = new JLabel("Print information for:");
    JTextField deleteField= new JTextField();
    JLabel deleteLabel = new JLabel("Delete from:");
    JLabel insertReservationLabel = new JLabel("Insert Reservation values:");
    JTextField insertReservationIdFIELD = new JTextField("Insert Reservation ID");
    JTextField insertReservationDateFIELD = new JTextField("Date YYYY-MM-DD");
    JButton deleteButton = new JButton("Delete");
    JButton insertReservationValuesButton = new JButton("Insert");
    JLabel updateReservationLabel = new JLabel("Update Reservation (After adding client egn)");
    JTextField updateReservationFIELD = new JTextField("Client egn");
    JButton updateReservationButton = new JButton("Update");
    JTextField updateReservationIDField = new JTextField("Reservation ID");
    JLabel insertEmployeeLabel = new JLabel("Insert Employee values:");
    JTextField insertEmployeeIDFIELD = new JTextField("Employee ID");
    JTextField insertEmployeeFirstNameFIELD = new JTextField("FirstName");
    JTextField insertEmployeeLastNameFIELD = new JTextField("LastName");
    JTextField insertEmployeePhoneFIELD = new JTextField("Phone");
    JButton insertEmployeeValuesBUTTON = new JButton("Insert");
    JLabel updateEmployeeLABEL = new JLabel("Update Employee FK (ReservationID)");
    JTextField updateEmployeeIDFIELD = new JTextField("Employee ID");
    JTextField updateEmployeeReservationFIELD = new JTextField("Reservation ID");
    JButton updateEmployeeBUTTON = new JButton("Update");
    JLabel insertClientLABEL = new JLabel("Insert values in Client Table");
    JTextField insertClientEGNFIELD = new JTextField("Client EGN");
    JTextField insertClientAgeFIELD = new JTextField("Client AGE");
    JTextField insertClientFirstNameFIELD = new JTextField("Client firstNAME");
    JTextField insertClientLastNameFIELD = new JTextField("Client lastNAME");
    JButton insertClientBUTTOn = new JButton("Insert");
    JLabel updateClientLABEL = new JLabel("Update Client FK (Reservation ID)");
    JTextField updateClientEGN = new JTextField("Client EGN");
    JTextField updateClientReservation = new JTextField("Reservation ID");
    JButton updateClientBUTTON = new JButton("Update");
    JLabel insertAccommodationLABEL = new JLabel("Insert Accommodation Values");
    JTextField insertAccommodationNumberFIELD = new JTextField("Number");
    JTextField insertAccommodationClientEGN = new JTextField("ClientEGN");
    JButton insertAccommodationButton = new JButton("Insert");
    JLabel updateAccommodationLABEL = new JLabel("Update Accommodation FK (RoomNumber)");
    JTextField updateAccommodationROOMFIELD = new JTextField("Room number");
    JTextField updateAccommodationNUMBERFIELD = new JTextField("Number");
    JButton updateAccommodationBUTTON = new JButton("Update");
    JLabel insertNewRoomLABEL = new JLabel("Insert Room Values:");
    JTextField insertRoomNUMBERFIELD = new JTextField("Room Number");
    JTextField insertRoomTYPEFIELD = new JTextField("Room type");
    JTextField insertRoomFloorsFIELD = new JTextField("Floor number");
    JButton insertRoomBUTTON = new JButton("Insert");
    JLabel updateRoomLABEL = new JLabel("Update Room FK (Accommodation number)");
    JTextField updateRoomNumberFIELD = new JTextField("Room number");
    JTextField updateRoomAccommNumberFIELD = new JTextField("Accomm. Number");
    JButton updateRoomBUTTON = new JButton("Update");






    JComboBox tableBox;
    JComboBox deleteBox;

    WelcomePage() {

        welcomeLabel.setBounds(200,20 , 300,20);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 20));

        tablesLabel.setBounds(0,100, 300, 35);
        tablesLabel.setFont(new Font(null, Font.ITALIC, 15));
        tableBox = new JComboBox(tables);
        tableBox.addActionListener(this);
        tableBox.setBounds(135, 100, 100,35);



        deleteLabel.setBounds(0, 150, 300, 35);
        deleteLabel.setFont(new Font(null, Font.ITALIC,15));
        deleteBox = new JComboBox(tables);
        deleteBox.addActionListener(this);
        deleteBox.setBounds(85, 150, 100,35);
        deleteField.setBounds(188, 150,100 ,35);
        deleteButton.setBounds(290, 150,100,35);
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);

        insertReservationLabel.setBounds(0,200,300,35);
        insertReservationLabel.setFont(new Font(null, Font.ITALIC,15));
        insertReservationIdFIELD.setBounds(173,200,120,35);
        insertReservationDateFIELD.setBounds(294,200,105,35);
        insertReservationValuesButton.setBounds(399,200,100,35);
        insertReservationValuesButton.addActionListener(this);
        insertReservationValuesButton.setFocusable(false);

        updateReservationLabel.setBounds(0,250,300,35);
        updateReservationLabel.setFont(new Font(null,Font.ITALIC,15));
        updateReservationFIELD.setBounds(295,250,63,35);
        updateReservationIDField.setBounds(360,250,85,35);
        updateReservationButton.setBounds(445,250,100,35);
        updateReservationButton.addActionListener(this);
        updateReservationButton.setFocusable(false);

        insertEmployeeLabel.setBounds(0,300,300,35);
        insertEmployeeLabel.setFont(new Font(null,Font.ITALIC,15));
        insertEmployeeIDFIELD.setBounds(165,300,80,35);
        insertEmployeeFirstNameFIELD.setBounds(245,300,80,35);
        insertEmployeeLastNameFIELD.setBounds(325,300,80,35);
        insertEmployeePhoneFIELD.setBounds(405,300,80,35);
        insertEmployeeValuesBUTTON.setBounds(485,300,80,35);
        insertEmployeeValuesBUTTON.addActionListener(this);
        insertEmployeeValuesBUTTON.setFocusable(false);

        updateEmployeeLABEL.setBounds(0, 350,300,35);
        updateEmployeeLABEL.setFont(new Font(null,Font.ITALIC,15));
        updateEmployeeIDFIELD.setBounds(280,350,80,35);
        updateEmployeeReservationFIELD.setBounds(360,350,95,35);
        updateEmployeeBUTTON.setBounds(455,350,80,35);
        updateEmployeeBUTTON.addActionListener(this);
        updateEmployeeBUTTON.setFocusable(false);

        insertClientLABEL.setBounds(0,400,300,35);
        insertClientLABEL.setFont(new Font(null,Font.ITALIC,15));
        insertClientEGNFIELD.setBounds(200,400,100,35);
        insertClientAgeFIELD.setBounds(300,400,80,35);
        insertClientFirstNameFIELD.setBounds(380,400,100,35);
        insertClientLastNameFIELD.setBounds(480,400,100,35);
        insertClientBUTTOn.setBounds(580,400,100,35);
        insertClientBUTTOn.addActionListener(this);
        insertClientBUTTOn.setFocusable(false);

        updateClientLABEL.setBounds(0,450,300,35);
        updateClientLABEL.setFont(new Font(null,Font.ITALIC,15));
        updateClientEGN.setBounds(235,450,100,35);
        updateClientReservation.setBounds(335,450,80,35);
        updateClientBUTTON.setBounds(415,450,100,35);
        updateClientBUTTON.addActionListener(this);
        updateClientBUTTON.setFocusable(false);

        insertAccommodationLABEL.setBounds(0,500,300,35);
        insertAccommodationLABEL.setFont(new Font(null,Font.ITALIC,15));
        insertAccommodationNumberFIELD.setBounds(200,500,100,35);
        insertAccommodationClientEGN.setBounds(302,500,100,35);
        insertAccommodationButton.setBounds(403,500,100,35);
        insertAccommodationButton.addActionListener(this);
        insertAccommodationButton.setFocusable(false);

        updateAccommodationLABEL.setBounds(0,550,300,35);
        updateAccommodationLABEL.setFont(new Font(null,Font.ITALIC,15));
        updateAccommodationNUMBERFIELD.setBounds(300,550,100,35);
        updateAccommodationROOMFIELD.setBounds(400,550,100,35);
        updateAccommodationBUTTON.setBounds(500,550,100,35);
        updateAccommodationBUTTON.addActionListener(this);
        updateAccommodationBUTTON.setFocusable(false);

        insertNewRoomLABEL.setBounds(0,600,300,35);
        insertNewRoomLABEL.setFont(new Font(null,Font.ITALIC,15));
        insertRoomNUMBERFIELD.setBounds(180,600,80,35);
        insertRoomTYPEFIELD.setBounds(262,600,100,35);
        insertRoomFloorsFIELD.setBounds(363,600,100,35);
        insertRoomBUTTON.setBounds(465,600,100,35);
        insertRoomBUTTON.addActionListener(this);
        insertRoomBUTTON.setFocusable(false);

        updateRoomLABEL.setBounds(0,650,300,35);
        updateRoomLABEL.setFont(new Font(null,Font.ITALIC,15));
        updateRoomNumberFIELD.setBounds(300,650,100,35);
        updateRoomAccommNumberFIELD.setBounds(400,650,100,35);
        updateRoomBUTTON.setBounds(500,650,100,35);
        updateRoomBUTTON.addActionListener(this);
        updateRoomBUTTON.setFocusable(false);



        frame.add(updateRoomLABEL);
        frame.add(updateRoomBUTTON);
        frame.add(updateRoomAccommNumberFIELD);
        frame.add(updateRoomNumberFIELD);
        frame.add(insertNewRoomLABEL);
        frame.add(insertRoomBUTTON);
        frame.add(insertRoomNUMBERFIELD);
        frame.add(insertRoomTYPEFIELD);
        frame.add(insertRoomFloorsFIELD);
        frame.add(updateAccommodationNUMBERFIELD);
        frame.add(updateAccommodationLABEL);
        frame.add(updateAccommodationROOMFIELD);
        frame.add(updateAccommodationBUTTON);
        frame.add(insertAccommodationLABEL);
        frame.add(insertAccommodationButton);
        frame.add(insertAccommodationClientEGN);
        frame.add(insertAccommodationNumberFIELD);
        frame.add(updateClientLABEL);
        frame.add(updateClientBUTTON);
        frame.add(updateClientEGN);
        frame.add(updateClientReservation);
        frame.add(insertClientLABEL);
        frame.add(insertClientEGNFIELD);
        frame.add(insertClientAgeFIELD);
        frame.add(insertClientFirstNameFIELD);
        frame.add(insertClientLastNameFIELD);
        frame.add(insertClientBUTTOn);
        frame.add(updateEmployeeBUTTON);
        frame.add(updateEmployeeIDFIELD);
        frame.add(updateEmployeeLABEL);
        frame.add(updateEmployeeReservationFIELD);
        frame.add(insertEmployeeLabel);
        frame.add(insertEmployeeIDFIELD);
        frame.add(insertEmployeeFirstNameFIELD);
        frame.add(insertEmployeeLastNameFIELD);
        frame.add(insertEmployeePhoneFIELD);
        frame.add(insertEmployeeValuesBUTTON);
        frame.add(updateReservationIDField);
        frame.add(updateReservationButton);
        frame.add(updateReservationFIELD);
        frame.add(updateReservationLabel);
        frame.add(insertReservationValuesButton);
        frame.add(insertReservationDateFIELD);
        frame.add(insertReservationIdFIELD);
        frame.add(insertReservationLabel);
        frame.add(deleteButton);
        frame.add(deleteField);
        frame.add(deleteBox);
        frame.add(deleteLabel);
        frame.add(tableBox);
        frame.add(welcomeLabel);
        frame.add(tablesLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==tableBox){
            //SHOW INFORMATION FROM
           if (tableBox.getSelectedIndex() == 0){
               //Reservation
               showAllReservations();
           }
           if (tableBox.getSelectedIndex() == 1){
               //Employee
                showAllEmployees();
           }
           if (tableBox.getSelectedIndex() == 2){
               //Client
               showAllClients();
           }
           if (tableBox.getSelectedIndex() == 3){
               showAllAccommodations();
           }
           if (tableBox.getSelectedIndex() == 4){
               showAllRooms();
           }
        }
        if (e.getSource() == deleteButton){
            //DELETE
            if (deleteBox.getSelectedIndex() == 0){
                //Delete from Reservation
                deleteFromReservation();
            }
            if (deleteBox.getSelectedIndex() == 1) {
                //Delete from Employee
                deleteFromEmployee();
            }
            if (deleteBox.getSelectedIndex() == 2){
                //Delete from Client
                deleteFromClient();
            }
            if (deleteBox.getSelectedIndex() == 3){
                //Delete from Accommodation
                deleteFromAccommodations();
            }
            if (deleteBox.getSelectedIndex() ==4){
                //Delete from Rooms
                deleteFromRooms();
            }
        }
        if (e.getSource() == insertReservationValuesButton){
            //INSERT RESERVATION ID AND DATE
            insertReservationValues();
        }
        if (e.getSource() == updateReservationButton){
            //UPDATE CLIENT EGN IN RESERVATION
            updaterReservation();
        }
        if (e.getSource() == insertEmployeeValuesBUTTON){
            //INSERT VALUES INTO EMPLOYEE TABLE
            insertIntoEmployee();
        }
        if (e.getSource() == updateEmployeeBUTTON){
            //UPDATE EMPLOYEE FK(RESERVATION_ID)
            updateEmployee();
        }
        if (e.getSource()== insertClientBUTTOn){
            //INSERT CLIENT VALUES
            insertClientValues();
        }
        if (e.getSource() == updateClientBUTTON){
            //UPDATE CLIENT FK(RESERVATION ID)
            updateClientValues();
        }
        if (e.getSource() == insertAccommodationButton){
            //INSERT VALUES IN ACCOMMODATION TABLE
            insertAccommodationValues();
        }
        if (e.getSource() == updateAccommodationBUTTON){
            //UPDATE ACCOMMODATION FK (ROOM NUMBER)
            updateAccommodationFK();
        }
        if (e.getSource()== insertRoomBUTTON){
            //INSERT VALUES IN ROOM TABLE
            insertRoomValues();
        }
        if (e.getSource() == updateRoomBUTTON){
            //UPDATE ROOM FK (ACCOMMODATION NUMBER)
            updateRoomFK();
        }

    }
    public void updateRoomFK(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int roomNumber = Integer.parseInt(updateRoomNumberFIELD.getText());
            int accommodationNumber = Integer.parseInt(updateRoomAccommNumberFIELD.getText());
            statement.executeUpdate("UPDATE room SET accommodation_number="+accommodationNumber +" WHERE room_number= "+roomNumber+";");
            System.out.println("Successfully updated values into Room table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void updateAccommodationFK(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int number = Integer.parseInt(updateAccommodationNUMBERFIELD.getText());
            int roomNumber = Integer.parseInt(updateAccommodationROOMFIELD.getText());
            statement.executeUpdate("UPDATE accommodation SET room_number="+roomNumber +" WHERE accommodation_number= "+number+";");
            System.out.println("Successfully updated values into Accommodation table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void insertRoomValues(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int number = Integer.parseInt(insertRoomNUMBERFIELD.getText());
            String roomType = insertRoomTYPEFIELD.getText();
            int floors = Integer.parseInt(insertRoomFloorsFIELD.getText());
            statement.executeUpdate("INSERT INTO room VALUES("+number+", '"+roomType+"',"+floors+" ,NULL);");
            System.out.println("Successfully inserted values into Rooms table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void insertAccommodationValues(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int number = Integer.parseInt(insertAccommodationNumberFIELD.getText());
            int clientEGN = Integer.parseInt(insertAccommodationClientEGN.getText());
            statement.executeUpdate("INSERT INTO accommodation VALUES("+number+", "+clientEGN+", NULL);");
            System.out.println("Successfully inserted values into Accommodation table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void updateClientValues(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int clientEGN = Integer.parseInt(updateClientEGN.getText());
            int reservationID = Integer.parseInt(updateClientReservation.getText());
            statement.executeUpdate("UPDATE client SET reservation_id="+reservationID +" WHERE client_egn= "+clientEGN+";");
            System.out.println("Successfully update values into Client table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void insertClientValues(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int clientEGN = Integer.parseInt(insertClientEGNFIELD.getText());
            int clientAge = Integer.parseInt(insertClientAgeFIELD.getText());
            String clientFirstName = insertClientFirstNameFIELD.getText();
            String clientLastName = insertClientLastNameFIELD.getText();
            statement.executeUpdate("INSERT INTO client VALUES("+clientEGN+", "+clientAge+", '"+clientFirstName+"', '"+clientLastName+"', NULL);");
            System.out.println("Successfully inserted values into Clients table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void updateEmployee(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int employeeID = Integer.parseInt(updateEmployeeIDFIELD.getText());
            int reservationID = Integer.parseInt(updateEmployeeReservationFIELD.getText());
            statement.executeUpdate("UPDATE employee SET reservation_id="+employeeID +" WHERE emp_id= "+reservationID+";");
            System.out.println("Successfully update values into Employee table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void insertIntoEmployee(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int employeeID = Integer.parseInt(insertEmployeeIDFIELD.getText());
            String employeeFirstName = insertEmployeeFirstNameFIELD.getText();
            String employeeLastName = insertEmployeeLastNameFIELD.getText();
            int employeePhone = Integer.parseInt(insertEmployeePhoneFIELD.getText());
            statement.executeUpdate("INSERT INTO employee VALUES ("+ employeeID+", '"+employeeFirstName+"', '" + employeeLastName+"', "+employeePhone+", NULL);");
            System.out.println("Successfully inserted values into Employee table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void updaterReservation(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int clientEGN = Integer.parseInt(updateReservationFIELD.getText());
            int reservationID = Integer.parseInt(updateReservationIDField.getText());
            statement.executeUpdate("UPDATE reservation SET client_egn="+clientEGN +" WHERE reservation_id= "+reservationID+";");
            System.out.println("Successfully update values into Reservation table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void insertReservationValues(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int reservationID = Integer.parseInt(insertReservationIdFIELD.getText());
            String reservationDate = insertReservationDateFIELD.getText();
            statement.executeUpdate("INSERT INTO reservation VALUES("+reservationID +", NULL, 01, '"+ reservationDate+"')");
            System.out.println("Successfully inserted values into Reservation table");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void deleteFromRooms(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String deleteText = deleteField.getText();
            int roomNumber = Integer.parseInt(deleteText);
            statement.executeUpdate("DELETE FROM room WHERE room_number =" + roomNumber);
            System.out.println("Deleted room number:" + roomNumber + " from the Room table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void deleteFromAccommodations(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String deleteText = deleteField.getText();
            int accommNUM = Integer.parseInt(deleteText);
            statement.executeUpdate("DELETE FROM client WHERE client_egn =" + accommNUM);
            System.out.println("Deleted accommodation number:" + accommNUM + " from the Accommodation table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void deleteFromClient(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String deleteText = deleteField.getText();
            int clientEGN = Integer.parseInt(deleteText);
            statement.executeUpdate("DELETE FROM client WHERE client_egn =" + clientEGN);
            System.out.println("Deleted client egn:" + clientEGN + " from the Client table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void deleteFromEmployee(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String deleteText = deleteField.getText();
            int employeeID = Integer.parseInt(deleteText);
            statement.executeUpdate("DELETE FROM employee WHERE emp_id =" + employeeID);
            System.out.println("Deleted employee id:" + employeeID + " from the Employee table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void deleteFromReservation(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String deleteText = deleteField.getText();
            int reservationID = Integer.parseInt(deleteText);
            statement.executeUpdate("DELETE FROM reservation WHERE reservation_id =" + reservationID);
            System.out.println("Deleted reservation_id:" + reservationID + " from the Reservation table\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void showAllReservations(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM reservation");
            System.out.println("***************************** RESERVATION TABLE *****************************");
            while (rs.next()){
                System.out.println("reservation_id:" + rs.getInt("reservation_id") + "  " +
                        "client_egn:" + rs.getInt("client_egn") + "  " +
                        "emp_id:" + rs.getInt("emp_id") + "  " +
                        "reservation_date:" + rs.getString("reservation_date") + System.lineSeparator());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void showAllEmployees(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            System.out.println("********************************* EMPLOYEE TABLE **********************************");
            while (rs.next()){
                System.out.println("employee id:" + rs.getInt("emp_id") + "  " +
                        "first name:" + rs.getString("first_name") + "  " +
                        "last name:" + rs.getString("last_name") + "  " +
                        "phone:" + rs.getString("phone") + "  "+
                        "reservation id:" + rs.getInt("reservation_id") + System.lineSeparator());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void showAllClients(){
          try {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM client");
        System.out.println("********************************** CLIENT TABLE ***********************************");
        while (rs.next()){
            System.out.println("client egn:" + rs.getInt("client_egn") + "  " +
                    "age:" + rs.getInt("age") + "  " +
                    "first name:" + rs.getString("client_fName") + "  " +
                    "last name:" + rs.getString("client_lName") + "  "+
                    "reservation id:" + rs.getInt("reservation_id") + System.lineSeparator());
        }
    } catch (Exception exc) {
        exc.printStackTrace();
        }
    }
    public void showAllAccommodations(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM accommodation");
            System.out.println("********************************** ACCOMMODATION TABLE ***********************************");
            while (rs.next()){
                System.out.println("accommodation number:" + rs.getInt("accommodation_number") + "  " +
                        "client egn:" + rs.getInt("client_egn") + "  " +
                        "room number:" + rs.getInt("room_number") + System.lineSeparator());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void showAllRooms (){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM room");
            System.out.println("********************************** ROOM TABLE ***********************************");
            while (rs.next()){
                System.out.println("room number:" + rs.getInt("room_number") + "  " +
                        "room type:" + rs.getString("room_type") + "  " +
                        "floor:" + rs.getInt("floors") + "  " +
                        "accommodation number:" + rs.getInt("accommodation_number") + System.lineSeparator());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
