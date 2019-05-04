package test;

public class MainTrain {

	public static void main(String[] args) {
		// design test (50 points)
		DesignTest dt=new DesignTest();
		TestSetter.setClasses(dt);
		dt.testDesign();
		
		// we are not testing the American questions here...
		
		System.out.println("done");
	}

}
