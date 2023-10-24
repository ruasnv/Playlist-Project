package CENG112_HW1_G71;
import java.util.*;


public class PlaylistGenerator {
	
	static FileIO dc;
	private static Scanner scanner;
	static Genre<Song> acustic ; 
	static Genre<Song> instrumental; 
	static Genre<Song> rock ; 
	static Genre<Song> rap ; 
	static Genre<Song> jazz ; 
	static Genre<Song> pop ; 
	
	static Genre<Song> instrumentalbin;
	static Genre<Song> acusticbin ;
	static Genre<Song> rockbin ;
	static Genre<Song> rapbin ;
	static Genre<Song> jazzbin ;
	static Genre<Song> popbin ;
	
	static SongBag<Song> mySongArray;
	private static Playlist<Song> sleeping ;
	private static Playlist<Song> workout;
	private static Playlist<Song> dining;
	private static Playlist<Song> meditation;
	private static Playlist<Song> roadtrip;
	
	/**Main method**/
	public static void main(String[] args)
	{	
		acustic= new Genre<>();
		instrumental= new Genre<>();
		rock= new Genre<>();
		rap= new Genre<>();
		jazz= new Genre<>();
		pop= new Genre<>();
		
		
		dc = new FileIO();
		mySongArray=dc.readInventory();
		System.out.println("Total number of songs avalible = " + mySongArray.getArray().length);
       
		
		
		for(int i=0;i<mySongArray.getArray().length;i++){
			
        	if(mySongArray.getArray()[i].getGenre_id()==1){
        		acustic.add(mySongArray.getArray()[i]);	
        	}
        	
        	else if(mySongArray.getArray()[i].getGenre_id()==2){
        	    instrumental.add(mySongArray.getArray()[i]);	
            }
        	
        	else if(mySongArray.getArray()[i].getGenre_id()==3){
        		rock.add(mySongArray.getArray()[i]);	
            }
        	
        	else if(mySongArray.getArray()[i].getGenre_id()==4){
        		rap.add(mySongArray.getArray()[i]);	
            }
        	
        	else if(mySongArray.getArray()[i].getGenre_id()==5){
        		jazz.add(mySongArray.getArray()[i]);	
            }
        	else if(mySongArray.getArray()[i].getGenre_id()==6){
        		pop.add(mySongArray.getArray()[i]);	
            }
         } 
		
		
		System.out.println("Number of acustic songs = " + acustic.getNumberOfSongs()+
				"\nNumber of instrumental songs = "+ instrumental.getNumberOfSongs()+
			    "\nNumber of rock songs = " + rock.getNumberOfSongs()+
			    "\nNumber of rap songs = "+ rap.getNumberOfSongs()+
			    "\nNumber of jazz songs = " + jazz.getNumberOfSongs()+
			    "\nNumber of pop songs = " + pop.getNumberOfSongs());
		
		
		sleeping = new Playlist<Song>(1,2700);
		workout = new Playlist<Song>(2,3600);
		dining = new Playlist<Song>(3,5400);
		meditation = new Playlist<Song>(4,7200);
		roadtrip = new Playlist<Song>(5,10800);
		
		scanner = new Scanner(System.in);
		int userChoice = getUserInput();

		
		if(userChoice == 1) {
			Playlist<Song> first = createPlaylist(sleeping,instrumental, acustic, jazz);
			System.out.println("There are "+ first.getNumberOfSongs() + "number of songs in this playlist, "+" it is "
			+ first.getDuration()/60 + "minutes long.");
			
		}
		
		else if(userChoice == 2) {
			Playlist<Song> second = createPlaylist(workout,rap, rock, pop);	
			System.out.println("There are "+ second.getNumberOfSongs() + "number of songs in this playlist, "+" it is "
		   + second.getDuration()/60 + "minutes long.");
			
		}
		
		else if(userChoice == 3) {
			Playlist<Song> third = createPlaylist(dining,jazz, acustic, instrumental);	
			System.out.println("There are "+ third.getNumberOfSongs() + "number of songs in this playlist, "+" it is "
		   + third.getDuration()/60 + "minutes long.");
			
		}
		
		else if(userChoice == 4) {
			Playlist<Song> fourth = createPlaylist(meditation,instrumental, acustic, jazz);	
			System.out.println("There are "+ fourth.getNumberOfSongs() + "number of songs in this playlist, "+" it is "
		   + fourth.getDuration()/60 + "minutes long.");
	
			
		}
		
		else if(userChoice == 5) {
			Playlist<Song> fifth =createPlaylist(roadtrip,rock, pop, acustic);	
			System.out.println("There are "+ fifth.getNumberOfSongs() + "number of songs in this playlist, "+" it is "
		   + fifth.getDuration()/60 + "minutes long.");
		
		}
		
	    else if(userChoice == 0) {
		     System.out.println("App Closed. GoodBye <3");;
		}

}
	

    private static Playlist<Song> createPlaylist(Playlist<Song> demo,Genre<Song> xxx, Genre<Song> yyy, Genre<Song> zzz) {
		int demotimer = 0;
		Genre<Song> xxxbin = new Genre<Song>();
		Genre<Song> yyybin = new Genre<Song>();
		Genre<Song> zzzbin = new Genre<Song>();
		while(demotimer <= demo.getDuration()) {
		    
			for(int i=0; i<xxx.getNumberOfSongs(); i++){
			      Song a = xxx.maxPopularity();
			      demo.add(a);
			      int b = xxx.getIndexOf(a);
			      xxx.removeByIndex(b);
			      xxxbin.add(a);
			      demotimer = demotimer + a.getTrack_duration();
		                                                  }
		     
		   for(int i=0;i<yyy.getNumberOfSongs();i++){
		          Song a = yyy.maxPopularity();
		          demo.add(a);
		          int b = yyy.getIndexOf(a);
		          yyy.removeByIndex(b);
		          yyybin.add(a);
		          demotimer = demotimer + a.getTrack_duration();
	                                                  }
		    
		    for(int i=0;i<zzz.getNumberOfSongs();i++){
		          Song a = zzz.maxPopularity();
		          demo.add(a);
		          int b = zzz.getIndexOf(a);
		          zzz.removeByIndex(b);
		          zzzbin.add(a);
		          demotimer = demotimer + a.getTrack_duration();
	                                                  }
		    }
		for(int f = 0; f < acusticbin.getNumberOfSongs();f++) {
			   Song b = acusticbin.getArray()[f];
			   int c = acusticbin.getIndexOf(b);
		       acusticbin.transferTo(acustic,b);
		       acusticbin.removeByIndex(c);
		       }
		for(int f = 0; f < instrumentalbin.getNumberOfSongs();f++) {
			 Song b = instrumentalbin.getArray()[f];
			   int c = instrumentalbin.getIndexOf(b);
			   instrumentalbin.transferTo(acustic,b);
			   instrumentalbin.removeByIndex(c);
		       }
		for(int f = 0; f < jazzbin.getNumberOfSongs();f++) {
			 Song b = jazzbin.getArray()[f];
			   int c = jazzbin.getIndexOf(b);
			   jazzbin.transferTo(acustic,b);
			   jazzbin.removeByIndex(c);
		       }
	return demo ;	
    }
   
	private static int getUserInput() {
		System.out.print("Please enter the playlist you want to create:\n"
				+ "[1]Sleeping Playlist.\n"
				+ "[2]Workout Playlist.\n"
				+ "[3]Dining Playlist.\n"
				+ "[4]Meditation Playlist.\n"
				+ "[5]Roadtrip Playlist.\n"
				+ "[0]Exit.\n:");
                int input = scanner.nextInt();
                 while(!(input == 1)&&!(input == 2)&&!(input == 3)&&!(input == 4)&&!(input == 5)&&!(input == 0)) {
                 System.out.println("Please enter an available number: ");
                 input = scanner.nextInt();
                                                                       }
       return input;}
}
       
