package dsai.TestDisc;

//Wrapper class to cover the entire object

import dsai.DigitalVideoDisc.DigitalVideoDisc;

class dvdWrapper{
    DigitalVideoDisc dvd;

    dvdWrapper(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        dvdWrapper wrapper1 = new dvdWrapper(jungleDVD);
        dvdWrapper wrapper2 = new dvdWrapper(cinderellaDVD);
        
        swap(wrapper1, wrapper2);

        System.out.println(wrapper1.dvd.getTitle());
        System.out.println(wrapper2.dvd.getTitle());

        swap(jungleDVD, cinderellaDVD);
        //After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two objects still remain?
        //The method swap only swaps their references in the memory, not the entire object
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        //After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is the title of the JungleDVD changed?
        //The method changes the title according to the string "title" provided, and also provides a copy of the JungleDVD object, but since the new object is assigned to the local copy of the dvd parameter, it does not affect the original dvd object.
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    
    //Swap method for swapping 2 objects correctly
    public static void swap(dvdWrapper wrapper1, dvdWrapper wrapper2){
        DigitalVideoDisc temp = wrapper1.dvd;
        wrapper1.dvd = wrapper2.dvd;
        wrapper2.dvd = temp;
    }
}
