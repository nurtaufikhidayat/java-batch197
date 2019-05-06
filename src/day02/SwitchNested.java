package day02;

public class SwitchNested {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char branch  = 'C';
		int collegeYear = 4;
		switch(collegeYear) {
		case 1:
			System.out.println("English, Maths, Science");
			break;
		case 2:
			switch(branch) {
			case 'C':
				System.out.println("Operational System, Java, Data Structure");
				break;
			case 'E':
				System.out.println("Micro Processor, Logic Switching theory");
				break;
			case 'M':
				System.out.println("Drawing, Manufacturing Machines");
				break;
			}
			break;
		case 3:
			switch(branch) {
			case 'C':
				System.out.println("Computer Organization, Multimedia");
				break;
			case 'E':
				System.out.println("Fundamental of logic design, Microelectronic");
				break;
			case 'M':
				System.out.println("Internal Combustion Engine, Mechanical Vibration");
				break;
			}
			break;
		case 4:
			switch(branch) {
			case 'C':
				System.out.println("Data Communication and networks, multimedia");
				break;
			case 'E':
				System.out.println("Embeded System,");
				break;
			case 'M':
				System.out.println("Production Technology, Thermal Enginering");
				break;
			}
			break;
		}

	}
}

