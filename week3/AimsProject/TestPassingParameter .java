package week3;

public class TestPassingParameter {
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.printf("jungle dvd title: " + jungleDVD.getTitle()+"\n");
		System.out.printf("cinderella dvd title: " + cinderellaDVD.getTitle()+"\n");
		
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.printf("jungle dvd title: "+ jungleDVD.getTitle()+"\n");
	}
	
	
	public static void swap(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		
		
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
