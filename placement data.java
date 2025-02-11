package java_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class project {
    // private static int entryCounter = 1;

    public static void main1(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Placement Information");

        frame.setSize(1151, 667);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 20, 3000, 100);
        frame.add(nameLabel);

        JTextField entry1 = new JTextField();
        entry1.setBackground(new Color(200, 200, 200));
        entry1.setForeground(new Color(0, 7, 22));
        entry1.setBounds(160, 60, 400, 28);
        frame.add(entry1);

        JLabel emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(30, 60, 3000, 100);
        frame.add(emailLabel);

        JTextField entry2 = new JTextField();
        entry2.setBackground(new Color(200, 200, 200));
        entry2.setForeground(new Color(0, 7, 22));
        entry2.setBounds(160, 100, 400, 28);
        frame.add(entry2);

        JLabel DepartmentLabel = new JLabel("Department");
        DepartmentLabel.setBounds(30, 100, 3000, 100);
        frame.add(DepartmentLabel);

        JTextField entry3 = new JTextField();
        entry3.setBackground(new Color(200, 200, 200));
        entry3.setForeground(new Color(0, 7, 22));
        entry3.setBounds(160, 140, 400, 28);
        frame.add(entry3);

        JLabel PRNLabel = new JLabel("PRN No");
        PRNLabel.setBounds(30, 140, 3000, 100);
        frame.add(PRNLabel);

        JTextField entry4 = new JTextField();
        entry4.setBackground(new Color(200, 200, 200));
        entry4.setForeground(new Color(0, 7, 22));
        entry4.setBounds(160, 180, 400, 28);
        frame.add(entry4);

        JLabel ContactLabel = new JLabel("Contact No");
        ContactLabel.setBounds(30, 180, 3000, 100);
        frame.add(ContactLabel);

        JTextField entry5 = new JTextField();
        entry5.setBackground(new Color(200, 200, 200));
        entry5.setForeground(new Color(0, 7, 22));
        entry5.setBounds(160, 220, 400, 28);
        frame.add(entry5);

        entry5.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed
            }
        });

        JLabel AddressLabel = new JLabel("Address");
        AddressLabel.setBounds(30, 220, 3000, 100);
        frame.add(AddressLabel);

        JTextField entry6 = new JTextField();
        entry6.setBackground(new Color(200, 200, 200));
        entry6.setForeground(new Color(0, 7, 22));
        entry6.setBounds(160, 260, 400, 100);
        frame.add(entry6);

        JLabel GenderLabel = new JLabel("Gender");
        GenderLabel.setBounds(30, 330, 3000, 100);
        frame.add(GenderLabel);

        JTextField entry7 = new JTextField();
        entry7.setBackground(new Color(200, 200, 200));
        entry7.setForeground(new Color(0, 7, 22));
        entry7.setBounds(160, 370, 200, 28);
        frame.add(entry7);

        JButton genderButton = new JButton("Select Gender");
        genderButton.setBounds(370, 370, 150, 28);
        frame.add(genderButton);

        // Add an ActionListener to the genderButton to open a dialog
        genderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] genderOptions = { "Male", "Female" };
                int selectedOption = JOptionPane.showOptionDialog(frame,
                        "Select Gender", "Gender Selection", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, genderOptions, genderOptions[0]);

                if (selectedOption == 0) {
                    entry7.setText("Male");
                } else if (selectedOption == 1) {
                    entry7.setText("Female");
                }
            }
        });

        JLabel YearLabel = new JLabel("Year Of Passing 10th");
        YearLabel.setBounds(30, 370, 3000, 100);
        frame.add(YearLabel);

        JTextField entry8 = new JTextField();
        entry8.setBackground(new Color(200, 200, 200));
        entry8.setForeground(new Color(0, 7, 22));
        entry8.setBounds(160, 410, 200, 28);
        frame.add(entry8);

        JButton year10thButton = new JButton("Select Year");
        year10thButton.setBounds(370, 410, 150, 28);
        frame.add(year10thButton);

        // Create a list of years from 2000 to 2040
        String[] yearOptions = new String[41];
        for (int i = 0; i < yearOptions.length; i++) {
            yearOptions[i] = String.valueOf(2000 + i);
        }

        // Add an ActionListener to the year10thButton to open a dialog with a
        // scrollable list
        year10thButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JList<String> yearList = new JList<>(yearOptions);
                JScrollPane yearScrollPane = new JScrollPane(yearList);
                int selectedOption = JOptionPane.showOptionDialog(frame, yearScrollPane,
                        "Select Year of Passing 10th", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (selectedOption == JOptionPane.OK_OPTION) {
                    entry8.setText(yearList.getSelectedValue());
                }
            }
        });

        // "Year of Passing 12th" field
        JLabel Year1Label = new JLabel("Year Of Passing 12th");
        Year1Label.setBounds(30, 410, 3000, 100);
        frame.add(Year1Label);

        JTextField entry9 = new JTextField();
        entry9.setBackground(new Color(200, 200, 200));
        entry9.setForeground(new Color(0, 7, 22));
        entry9.setBounds(160, 450, 200, 28);
        frame.add(entry9);

        JButton year12thButton = new JButton("Select Year");
        year12thButton.setBounds(370, 450, 150, 28);
        frame.add(year12thButton);

        // Add an ActionListener to the year12thButton to open a dialog with a
        // scrollable list
        year12thButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JList<String> yearList = new JList<>(yearOptions);
                JScrollPane yearScrollPane = new JScrollPane(yearList);
                int selectedOption = JOptionPane.showOptionDialog(frame, yearScrollPane,
                        "Select Year of Passing 12th", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (selectedOption == JOptionPane.OK_OPTION) {
                    entry9.setText(yearList.getSelectedValue());
                }
            }
        });

        JLabel Year2Label = new JLabel("Percentage 10th");
        Year2Label.setBounds(30, 450, 3000, 100);
        frame.add(Year2Label);

        JTextField entry10 = new JTextField();
        entry10.setBackground(new Color(200, 200, 200));
        entry10.setForeground(new Color(0, 7, 22));
        entry10.setBounds(160, 490, 400, 28);
        frame.add(entry10);

        // Add a KeyListener to allow only digits
        entry10.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == '%' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed
            }
        });

        JLabel Year3Label = new JLabel("Percentage 12th");
        Year3Label.setBounds(30, 490, 3000, 100);
        frame.add(Year3Label);

        JTextField entry11 = new JTextField();
        entry11.setBackground(new Color(200, 200, 200));
        entry11.setForeground(new Color(0, 7, 22));
        entry11.setBounds(160, 530, 400, 28);
        frame.add(entry11);

        // Add a KeyListener to allow only digits
        entry11.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == '%' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed
            }
        });

        JLabel CGPALabel = new JLabel("CGPA");
        CGPALabel.setBounds(650, 20, 3000, 100);
        frame.add(CGPALabel);

        JTextField entry12 = new JTextField();
        entry12.setBackground(new Color(200, 200, 200));
        entry12.setForeground(new Color(0, 7, 22));
        entry12.setBounds(800, 60, 400, 28);
        frame.add(entry12);

        entry12.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed
            }
        });

        JLabel companyLabel = new JLabel("Company Name");
        companyLabel.setBounds(650, 60, 3000, 100);
        frame.add(companyLabel);

        JTextField entry13 = new JTextField();
        entry13.setBackground(new Color(200, 200, 200));
        entry13.setForeground(new Color(0, 7, 22));
        entry13.setBounds(800, 100, 400, 28);
        frame.add(entry13);

        JLabel DOBLabel = new JLabel("Date Of Birth");
        DOBLabel.setBounds(650, 100, 3000, 100);
        frame.add(DOBLabel);

        JTextField entry14 = new JTextField();
        entry14.setBackground(new Color(200, 200, 200));
        entry14.setForeground(new Color(0, 7, 22));
        entry14.setBounds(800, 140, 400, 28);
        frame.add(entry14);

        JLabel PILLabel = new JLabel("Package in LPA");
        PILLabel.setBounds(650, 140, 3000, 100);
        frame.add(PILLabel);

        JTextField entry15 = new JTextField();
        entry15.setBackground(new Color(200, 200, 200));
        entry15.setForeground(new Color(0, 7, 22));
        entry15.setBounds(800, 180, 400, 28);
        frame.add(entry15);

        JLabel ParentLabel = new JLabel("Parent Contact No");
        ParentLabel.setBounds(650, 180, 3000, 100);
        frame.add(ParentLabel);

        JTextField entry16 = new JTextField();
        entry16.setBackground(new Color(200, 200, 200));
        entry16.setForeground(new Color(0, 7, 22));
        entry16.setBounds(800, 220, 400, 28);
        frame.add(entry16);

        entry16.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Not needed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed
            }
        });

        // Add a "Submit" button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(1100, 530, 100, 28);
        frame.add(submitButton);

        // Add an ActionListener to the "Submit" button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String name = entry1.getText();
                String email = entry2.getText();
                String department = entry3.getText();
                String prnNo = entry4.getText();
                String contactNo = entry5.getText();
                String address = entry6.getText();
                String gender = entry7.getText();
                String year10th = entry8.getText();
                String year12th = entry9.getText();
                String percentage10th = entry10.getText();
                String percentage12th = entry11.getText();
                String cgpa = entry12.getText();
                String companyname = entry13.getText();
                String dateofbirth = entry14.getText();
                String packageinlpa = entry15.getText();
                String parentcontactno = entry16.getText();

                // Specify the file path where you want to save the data
                // String filePath = "C:\\Users\\Sayli
                // Tambe\\OneDrive\\Desktop\\placement_info.txt";

                // Write the data to the text file
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    // jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
                    System.out.print("connected");
                    Connection con = (Connection) DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/placement_info", "root", "Sayli@123");
                    PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                            "insert into placement values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, department);
                    ps.setString(4, prnNo);
                    ps.setString(5, contactNo);
                    ps.setString(6, address);
                    ps.setString(7, gender);
                    ps.setString(8, year10th);
                    ps.setString(9, year12th);
                    ps.setString(10, percentage10th);
                    ps.setString(11, percentage12th);
                    ps.setString(12, cgpa);
                    ps.setString(13, companyname);
                    ps.setString(14, dateofbirth);
                    ps.setString(15, packageinlpa);
                    ps.setString(16, parentcontactno);

                    ps.executeUpdate();
                    con.close();

                    entry1.setText("");
                    entry2.setText("");
                    entry3.setText("");
                    entry4.setText("");
                    entry5.setText("");
                    entry6.setText("");
                    entry7.setText("");
                    entry8.setText("");
                    entry9.setText("");
                    entry10.setText("");
                    entry11.setText("");
                    entry12.setText("");
                    entry13.setText("");
                    entry14.setText("");
                    entry15.setText("");
                    entry16.setText("");

                    JOptionPane.showMessageDialog(null, "Record Save Sucessfully..");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error while saving data to the file.");
                }
            }
        });

        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
