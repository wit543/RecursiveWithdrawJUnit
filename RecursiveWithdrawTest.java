package coinpurse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import coinpurse.strategy.RecursiveWithdraw;

public class RecursiveWithdrawTest {
	@Test
	public void testCreatePurse(){
		Purse purse = new Purse(10);
	}
	@Test
	public void testSetWithdrawStrategy(){
		Purse purse = new Purse(10);
		purse.setWithdrawStrategy(new RecursiveWithdraw());
	}
	@Test
	public void test3_2_2_2_withdraw_6(){
		Purse purse =depositDialog("3 2 2 2");
		Valuable[] valuable = purse.withdraw(6);
		assertNotNull(valuable);
		assertTrue("2 2 2".equals(convertToString(valuable)));
		
	}
	@Test
	public void test2_3_2_2_withdraw_6(){
		Purse purse =depositDialog("2 3 2 2");
		Valuable[] valuable = purse.withdraw(6);
		assertNotNull(valuable);
		assertTrue("2 2 2".equals(convertToString(valuable)));
		
	}
	@Test
	public void test2_2_3_2_withdraw_6(){
		Purse purse =depositDialog("2 2 3 2");
		Valuable[] valuable = purse.withdraw(6);
		assertNotNull(valuable);
		assertTrue("2 2 2".equals(convertToString(valuable)));
		
	}
	@Test
	public void test2_2_2_3_withdraw_6(){
		Purse purse =depositDialog("2 2 2 3");
		Valuable[] valuable = purse.withdraw(6);
		assertNotNull(valuable);
		assertTrue("2 2 2".equals(convertToString(valuable)));
		
	}
	@Test
	public void test5_2_2_2_withdraw_6(){
		Purse purse =depositDialog("5 2 2 2");
		Valuable[] valuable = purse.withdraw(6);
		assertNotNull(valuable);
		assertTrue("2 2 2".equals(convertToString(valuable)));
		
	}
	@Test
	public void test5_3_2_3_withdraw_9(){
		Purse purse =depositDialog("5 3 2 2");
		Valuable[] valuable = purse.withdraw(9);
		assertNotNull(valuable);
		String[] answer =new String[]{"5 2 2","2 5 2","2 2 5"};
		assertTrue(check(answer,convertToString(valuable)));
		}
	@Test
	public void test15_8_7_5_3_withdraw_14(){
		Purse purse =depositDialog("15 8 7 5 3 1");
		Valuable[] valuable = purse.withdraw(14);
		assertNotNull(valuable);
		String[] answer =new String[]{"8 5 1","5 8 1","1 5 8"};
		assertTrue(check(answer,convertToString(valuable)));
	}
	@Test
	public void test107_89_67_45_23_12_7_4withdraw_150(){
		Purse purse =depositDialog("107 89 67 45 23 12 7 4");
		Valuable[] valuable = purse.withdraw(150);
		System.out.println("Test: test107_89_67_45_23_12_7_4withdraw_150");
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains: [89 45 12 4]\n");
		assertNotNull(valuable);
		String[] answer =new String[]{"89 45 12 4","45 89 12 4","12 89 45 4","4 89 45 12","4 12 45 89"};
		assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 150));
	}
	@Test
	public void test245_86_77_53_46_34_28_12_9_5_3_1withdraw_300(){
		Purse purse =depositDialog("245 86 77 53 46 34 28 12 9 5 3 1");
		Valuable[] valuable = purse.withdraw(300);
		System.out.println("Test: test245_86_77_53_46_34_28_12_9_5_3_1withdraw_300");
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains:[86 77 53 46 34 3 1], [9 46 245],[5 34 12 28 9 46 86 77 3],[245 34 12 9],[3 5 9 12 28 34 46 77 86"
				+ "] There are many solution\n");
		assertNotNull(valuable);
		String[] answer =new String[]{"86 77 53 46 34 3 1","5 34 12 28 9 46 86 77 3","9 46 245","245 34 12 9","86 77 46 34 28 12 9 5 3","3 5 9 12 28 34 46 77 86"};
		//assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 300));
	}
	@Test
	public void test3_77_86_53_46_9_28_12_34_5_245_1withdraw_300(){
		Purse purse =depositDialog("3 77 86 53 46 9 28 12 34 5 245");
		Valuable[] valuable = purse.withdraw(300);
		System.out.println("Test: test3_77_86_53_46_9_28_12_34_5_245_1withdraw_300");
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains:[86 77 53 46 34 3 1], [9 46 245],[5 34 12 28 9 46 86 77 3],[3 5 9 12 28 34 46 77 86] There are many solution\n");
		assertNotNull(valuable);
		String[] answer =new String[]{"86 77 53 46 34 3 1","9 46 245","5 34 12 28 9 46 86 77 3","86 77 46 34 28 12 9 5 3","3 5 9 12 28 34 46 77 86"};
		assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 300));
	}
	@Test
	public void Test41_61_25_37_607_758_41056_42_45_245_887_452_23_1022_1054_1024_1111_75_83_454_251_451_458_withdraw_5214(){
		Purse purse =depositDialog("41 61 25 37 607 758 41056 42 45 245 887 452 23 1022 1054 1024 1111 75 83 454 251 451 458");
		Valuable[] valuable = purse.withdraw(5214);
		System.out.println("Test: test41_61_25_37_607_758_41056_42_45_245_887_452_23_1022_1054_1024_1111_75_83_454_251_451_458_withdraw_5214");
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains:[1111 1054 758 458 454 451 251 245 83 75 61 45 42 41 37 25 23] There are many solution\n");
		assertNotNull(valuable);
		String[] answer =new String[]{""};
		//assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 5214));
	}
	@Test(timeout=1000000000)
	public void Test41_37_607_245_887_452_1054_1024_75_83_251_458_withdraw_5214(){
		Purse purse = depositDialog("41 37 607 245 887 452 1054 1024 75 83 251 458");
		Valuable[] valuable = purse.withdraw(5214);
		System.out.println("Test: hardcoreTest41_37_607_245_887_452_1054_1024_75_83_251_458_withdraw_5214");
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains:[1054 1024 887 607 458 452 251 245 83 75 41 37] There are many solution\n");
	
		assertNotNull(valuable);
		String[] answer =new String[]{"1054 1024 887 607 458 452 251 245 83 75 41 37"};
		//assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 5214));
	}
	@Test
	public void test41_61_25_37_607_758_4156_42_45_245_887_452_23_1022_1054_1024_1111_75_83_454_251_451_458_withdraw_5214(){
		Purse purse =depositDialog("41 61 25 37 607 758 4156 42 45 245 887 452 23 1022 1054 1024 1111 75 83 454 251 451 458");
		Valuable[] valuable = purse.withdraw(5214);
		System.out.println("Test: test41_61_25_37_607_758_4156_42_45_245_887_452_23_1022_1054_1024_1111_75_83_454_251_451_458_withdraw_5214");
		System.out.println(valuable==null);
		System.out.println("Your answer: "+convertToString(valuable));
		System.out.println("Expected answer should contains: [245 42 4156 607 37 25 61 41],[4156 607 245 61 42 41 37 25],[25 37 41 42 61 245 607 4156] There are many solution\n");
		assertNotNull(valuable);
		String[] answer =new String[]{"245 42 4156 607 37 25 61 41","4156 607 245 61 42 41 37 25","25 37 41 42 61 245 607 4156"};
		//assertTrue(check(answer,convertToString(valuable)));
		assertTrue(checkByAdding(valuable, 5214));
	}
	public boolean checkByAdding(Valuable[] array,int amount){
		int computeAmount=0;
		for(Valuable v:array){
			computeAmount+=(int)v.getValue();
		}
		if(computeAmount==amount)
			return true;
		return false;
	}
	public boolean check(String[] array,String result){
		for(String s:array){
			if(result.equals(s)){
				return true;
			}
		}
		return false;
	}
	public String convertToString(Valuable[] arg){
		String s = "";
		for(Valuable v:arg)
			s+=((int)v.getValue())+" ";
		return s.trim();
	}
    public Purse depositDialog(String args) {
    	Purse purse = new Purse(50);
    	purse.setWithdrawStrategy(new RecursiveWithdraw());
        // parse the input line into numbers
        Scanner scanline = new Scanner(args);
        Valuable money = null;
        while( scanline.hasNext() ) {
           
                      // of Coins, BankNotes, Coupons we should create.
            // Move this code to MoneyFactory and call
            // MoneyFactory.getInstance().makeMoney(String)
            // to create a Valuable.
            
           
            if (scanline.hasNextDouble() ) {
                // create a coin or banknote
                double value = scanline.nextDouble();
                if (value < 20) money = new Coin(value);
                else money = new BankNote((int)value);
            }
            boolean ok = purse.insert(money);
        }
        return purse;
    }
	public static void main(String[] args) {
		Class<?> testclass = RecursiveWithdrawTest.class;
		Result result = org.junit.runner.JUnitCore.runClasses( testclass );
	}
}
