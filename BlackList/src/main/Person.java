package main;
public class Person {
	public Person(String par1, String par2, String par3, String par4, String par5, String par6, String par7,
			String par8, String par9, String par10) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
		this.par4 = par4;
		this.par5 = par5;
		this.par6 = par6;
		this.par7 = par7;
		this.par8 = par8;
		this.par9 = par9;
		this.par10 = par10;
	}
	public Person(String par1, String par2, String par3, String par4, String par5, String par6, String par7,
			String par8, String par9) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
		this.par4 = par4;
		this.par5 = par5;
		this.par6 = par6;
		this.par7 = par7;
		this.par8 = par8;
		this.par9 = par9;
	}
	public Person(String par1, String par2, String par3, String par4, String par5, String par6, String par7,
			String par8) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
		this.par4 = par4;
		this.par5 = par5;
		this.par6 = par6;
		this.par7 = par7;
		this.par8 = par8;
	}
	public Person(String par1, String par2, String par3, String par4, String par5, String par6, String par7) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
		this.par4 = par4;
		this.par5 = par5;
		this.par6 = par6;
		this.par7 = par7;
	}
	public Person(){};
    private String par1;
    private String par2;
    private String par3;
    private String par4;
    private String par5;
    private String par6;
    private String par7;
    private String par8;
    private String par9;
    private String par10;
	@Override
	public String toString() {
		return par1 + " |  " + par2 + " | " + par3 + " |  " + par4 + " |  " + par5
				+ " |  " + par6 + " |  " + par7 + " |  " + par8 + " |  " + par9 +" |  " + par10 + ".\n";
	}
	public String getPar1() {
		return par1;
	}
	public void setPar1(String par1) {
		this.par1 = par1;
	}
	public String getPar2() {
		return par2;
	}
	public void setPar2(String par2) {
		this.par2 = par2;
	}
	public String getPar3() {
		return par3;
	}
	public void setPar3(String par3) {
		this.par3 = par3;
	}
	public String getPar4() {
		return par4;
	}
	public void setPar4(String par4) {
		this.par4 = par4;
	}
	public String getPar5() {
		return par5;
	}
	public void setPar5(String par5) {
		this.par5 = par5;
	}
	public String getPar6() {
		return par6;
	}
	public void setPar6(String par6) {
		this.par6 = par6;
	}
	public String getPar7() {
		return par7;
	}
	public void setPar7(String par7) {
		this.par7 = par7;
	}
	public String getPar8() {
		return par8;
	}
	public void setPar8(String par8) {
		this.par8 = par8;
	}
	public String getPar9() {
		return par9;
	}
	public void setPar9(String par9) {
		this.par9 = par9;
	}
	public String getPar10() {
		return par10;
	}
	public void setPar10(String par10) {
		this.par10 = par10;
	}
}
