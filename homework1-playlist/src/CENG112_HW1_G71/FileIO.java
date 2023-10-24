package CENG112_HW1_G71;

import java.io.*;
import java.util.Scanner;

import CENG112_HW1_G71.FileIO;



public class FileIO {
	private SongBag<Song> itemsArray;

	private Song[] songs = new Song[85];

    
//    Reading the text file 
    public SongBag<Song> readInventory() {
	try{
		Scanner scanner = new Scanner(new FileReader("tracks.txt"));
		
		
		
		
       
		int i = 0;
		while(scanner.hasNextLine()) {
			String token = scanner.nextLine();
			String[] separatedToken = token.split(",");
			songs[i] = new Song(Integer.parseInt(separatedToken[0]),Integer.parseInt(separatedToken[1]),Integer.parseInt(separatedToken[2]),Integer.parseInt(separatedToken[3]));
			itemsArray = new SongBag<>(songs);

			i++;
			}
			
	        
		return itemsArray;
		
		
	    }catch(IOException ex) {
		System.out.println("File cannot be found.");
		ex.printStackTrace();
	}
	return null;
}
    
}


