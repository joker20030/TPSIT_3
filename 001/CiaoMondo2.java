// Il nostro secondo programma

//Il nome della classe è uguale al nome del file
class CiaoMondo2 {
    public static void main(String[] args) {
        String hello = "Ciao ";
        String world = "mondo\n";
        System.out.print(hello.toUpperCase()); 
        for(int i=0; i<world.length(); i++) {
            System.out.print(world.charAt(i));
        }
        System.out.print(hello.toUpperCase()); 
        System.out.println("---"); 
        for(int i=world.length(); i>0; i++) {
            System.out.print(world.charAt(i));
        }
        System.out.println("---"); 
        System.out.println("---"); 
        System.out.println("---"); 
    }
}
