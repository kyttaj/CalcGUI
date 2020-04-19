/*
 * Author: Jeffrey Kytta
 * This program takes coin count input
 * and outputs individual and total coin totals.
 * Course: CPSC 24500 OOP
 * Date: 4/9/20
 */

package hw9ChangeCalculator;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class CalcGUI extends JFrame {
	
	// Data fields
	private JPanel contentPane;
	private JTextField txtPenny;
	private JTextField txtNickel;
	private JTextField txtDime;
	private JTextField txtQuarter;
	private JTextField txtHalfDollar;
	private JTextField txtDollar;
	private JTextField output;
	private JTextField outputPenny;
	private JTextField outputNickel;
	private JTextField outputDime;
	private JTextField outputQuarter;
	private JTextField outputHalfDollar;
	private JTextField outputDollar;
	private DecimalFormat mydf = new DecimalFormat("00");
	
	double penny = 1;
	double nickel = 5;
	double dime = 10;
	double quarter = 25;
	double halfDollar = 50;
	double dollar = 100;
	
	/*
	 * panel constructor
	 */
	public CalcGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create Title label
		JLabel lblTitle = new JLabel("Change Calculator");
		lblTitle.setBounds(150, 15, 264, 14);
		contentPane.add(lblTitle);
		
		// Create separator
		JSeparator sepBar = new JSeparator();
		sepBar.setBounds(5, 40, 402, 1);
		contentPane.add(sepBar);
		
		// Create instruction label
		JLabel lblInstructions = new JLabel("Enter the number of "
				+ "each coin type and click calculate");
		lblInstructions.setBounds(50, 50, 430, 14);
		contentPane.add(lblInstructions);
		
		// Create coin labels
		JLabel lblPenny = new JLabel("Pennies:");
		lblPenny.setBounds(38, 90, 71, 14);
		contentPane.add(lblPenny);
		
		JLabel lblNickel = new JLabel("Nickels:");
		lblNickel.setBounds(38, 120, 71, 14);
		contentPane.add(lblNickel);
		
		JLabel lblDime = new JLabel("Dimes:");
		lblDime.setBounds(38, 150, 71, 14);
		contentPane.add(lblDime);
		
		JLabel lblQuarter = new JLabel("Quarters:");
		lblQuarter.setBounds(38, 180, 71, 14);
		contentPane.add(lblQuarter);
		
		JLabel lblHalfDollar = new JLabel("Half-Dollars:");
		lblHalfDollar.setBounds(38, 210, 71, 14);
		contentPane.add(lblHalfDollar);
		
		JLabel lblDollar = new JLabel("Dollars:");
		lblDollar.setBounds(38, 240, 71, 14);
		contentPane.add(lblDollar);
		
		// Text fields for coin count input
		txtPenny = new JTextField("0");
		txtPenny.setBounds(116, 89, 71, 20);
		contentPane.add(txtPenny);
		txtPenny.setColumns(10);
		
		txtNickel = new JTextField("0");
		txtNickel.setBounds(116, 119, 71, 20);
		contentPane.add(txtNickel);
		txtNickel.setColumns(10);
		
		txtDime = new JTextField("0");
		txtDime.setBounds(116, 149, 71, 20);
		contentPane.add(txtDime);
		txtDime.setColumns(10);
		
		txtQuarter = new JTextField("0");
		txtQuarter.setBounds(116, 179, 71, 20);
		contentPane.add(txtQuarter);
		txtQuarter.setColumns(10);
		
		txtHalfDollar = new JTextField("0");
		txtHalfDollar.setBounds(116, 209, 71, 20);
		contentPane.add(txtHalfDollar);
		txtHalfDollar.setColumns(10);
		
		txtDollar = new JTextField("0");
		txtDollar.setBounds(116, 239, 71, 20);
		contentPane.add(txtDollar);
		txtDollar.setColumns(10);
		
		// Calculate button
		JButton btnCalculate = new JButton("Calculate");
		SwingAction action = new SwingAction();
		btnCalculate.setAction(action);
		btnCalculate.setBounds(37, 278, 150, 20);
		contentPane.add(btnCalculate);
		
		// Total display
		JLabel lblOutput = new JLabel("Total Change:");
		lblOutput.setBounds(218, 278, 100, 14);
		contentPane.add(lblOutput);
		
		output = new JTextField();
		output.setBounds(308, 278, 71, 20);
		contentPane.add(output);
		output.setColumns(10);
		
		// Individual coin totals labels and text fields
		JLabel lblPennyTotal = new JLabel("$0.01 Total:");
		lblPennyTotal.setBounds(230, 90, 71, 14);
		contentPane.add(lblPennyTotal);
		
		outputPenny = new JTextField();
		outputPenny.setBounds(308, 89, 71, 20);
		contentPane.add(outputPenny);
		outputPenny.setColumns(10);
		
		JLabel lblNickelTotal = new JLabel("$0.05 Total:");
		lblNickelTotal.setBounds(230, 120, 71, 14);
		contentPane.add(lblNickelTotal);
		
		outputNickel = new JTextField();
		outputNickel.setBounds(308, 119, 71, 20);
		contentPane.add(outputNickel);
		outputNickel.setColumns(10);
		
		JLabel lblDimeTotal = new JLabel("$0.10 Total:");
		lblDimeTotal.setBounds(230, 150, 71, 14);
		contentPane.add(lblDimeTotal);
		
		outputDime = new JTextField();
		outputDime.setBounds(308, 149, 71, 20);
		contentPane.add(outputDime);
		outputDime.setColumns(10);
		
		JLabel lblQuarterTotal = new JLabel("$0.25 Total:");
		lblQuarterTotal.setBounds(230, 180, 71, 14);
		contentPane.add(lblQuarterTotal);
		
		outputQuarter = new JTextField();
		outputQuarter.setBounds(308, 179, 71, 20);
		contentPane.add(outputQuarter);
		outputQuarter.setColumns(10);
		
		JLabel lblHalfDollarTotal = new JLabel("$0.50 Total:");
		lblHalfDollarTotal.setBounds(230, 210, 71, 14);
		contentPane.add(lblHalfDollarTotal);
		
		outputHalfDollar = new JTextField();
		outputHalfDollar.setBounds(308, 209, 71, 20);
		contentPane.add(outputHalfDollar);
		outputHalfDollar.setColumns(10);
		
		JLabel lblDollarTotal = new JLabel("$1.00 Total:");
		lblDollarTotal.setBounds(230, 240, 71, 14);
		contentPane.add(lblDollarTotal);
		
		outputDollar = new JTextField();
		outputDollar.setBounds(308, 239, 71, 20);
		contentPane.add(outputDollar);
		outputDollar.setColumns(10);
	}
	
	/*
	 * Swing Action class
	 */
	private class SwingAction extends AbstractAction {
		
		/*
		 * Constructor
		 */
		public SwingAction() {
			putValue(NAME, "Calculate");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			// Validate input, no negative values
			try {
				if(Integer.parseInt(txtPenny.getText()) < 0 || 
						Integer.parseInt(txtDime.getText()) < 0 ||
						Integer.parseInt(txtNickel.getText()) < 0 ||
						Integer.parseInt(txtQuarter.getText()) < 0 ||
						Integer.parseInt(txtHalfDollar.getText()) < 0 ||
						Integer.parseInt(txtDollar.getText()) < 0) {
					JOptionPane.showMessageDialog(null, 
							"You cannot enter negative values");
				}
				
				else {
					int totalPenny = (int)(penny * 
							Integer.parseInt(txtPenny.getText()));
					int totalNickel = (int)(nickel * 
							Integer.parseInt(txtNickel.getText()));
					int totalDime = (int)(dime * 
							Integer.parseInt(txtDime.getText()));
					int totalQuarter = (int)(quarter * 
							Integer.parseInt(txtQuarter.getText()));
					int totalHalfDollar = (int)(halfDollar * 
							Integer.parseInt(txtHalfDollar.getText()));
					int totalDollar = (int)(dollar * 
							Integer.parseInt(txtDollar.getText()));
					
					// Calculate totals
					int total = totalPenny + totalNickel + totalDime + 
							totalQuarter + totalHalfDollar + totalDollar;
					int finalDollars = total / 100;
					int cents = total % 100;
					
					// Output individual coin totals
					String penny = "$" + totalPenny / 100 + 
							"." + mydf.format(totalPenny % 100);
					outputPenny.setText(penny);
					
					String nickel = "$" + totalNickel / 100 + 
							"." + mydf.format(totalNickel % 100);
					outputNickel.setText(nickel);
					
					String dime = "$" + totalDime / 100 + 
							"." + mydf.format(totalDime % 100);
					outputDime.setText(dime);
					
					String quarter = "$" + totalQuarter / 100 + 
							"." + mydf.format(totalQuarter % 100);
					outputQuarter.setText(quarter);
					
					String halfDollar = "$" + totalHalfDollar / 100 + 
							"." + mydf.format(totalHalfDollar % 100);
					outputHalfDollar.setText(halfDollar);
					
					String dollar = "$" + totalDollar / 100 + 
							"." + mydf.format(totalDollar % 100);
					outputDollar.setText(dollar);
					
					// Output total
					String display = "$" + finalDollars + 
							"." + mydf.format(cents);
					output.setText(display);
					
				}
				
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, 
						"Integers must be entered");
			}
			
		} // end of actionPerformed
		
	} // end of SwingAction()
	
	public static void main(String[] args) {
		
		// Create frame object and display
		CalcGUI frame = new CalcGUI();
		frame.setVisible(true);

	} // end of main()

} // end of CalcGUI()
